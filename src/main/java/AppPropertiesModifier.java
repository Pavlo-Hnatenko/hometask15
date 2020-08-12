import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class AppPropertiesModifier {

    static AppProperties appProperties = new AppProperties();
    static Properties props;

    static {
        props = new Properties();

        try (InputStream input = AppProperties.class.getResourceAsStream("app.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static boolean isAnnotated(PropertyKey propertyKey) {
        return propertyKey != null;
    }

    protected static void modify(Field field) {

        PropertyKey propertyKey = field.getAnnotation(PropertyKey.class);

        if (isAnnotated(propertyKey)) {

            try {
                switch (propertyKey.value()) {
                    case PROPERTY_NAME:
                        field.set(appProperties, props.getProperty(field.getName()));
                        break;
                    case PROPERTY_UTILITY:
                        field.setBoolean(appProperties, Boolean.parseBoolean(props.getProperty(field.getName())));
                        break;
                    case PROPERTY_PRICE:
                        field.setInt(appProperties, Integer.parseInt(props.getProperty(field.getName())));
                        break;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

}
