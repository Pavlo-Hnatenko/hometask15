public class Main {

    public static void main(String[] args) {

        System.out.println("\nAppProperties fields before modifying:\n");

        System.out.println("appProperties id: " + AppPropertiesModifier.appProperties.id);
        System.out.println("appProperties name: " + AppPropertiesModifier.appProperties.name);
        System.out.println("appProperties utility: " + AppPropertiesModifier.appProperties.utility);
        System.out.println("appProperties price: " + AppPropertiesModifier.appProperties.price);
        System.out.println("appProperties someLong: " + AppPropertiesModifier.appProperties.someLong);

        try {
            AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("id"));
            AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("name"));
            AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("utility"));
            AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("price"));
            AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("someLong"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("\nAppProperties fields after modifying:\n");

        System.out.println("appProperties id: " + AppPropertiesModifier.appProperties.id);
        System.out.println("appProperties name: " + AppPropertiesModifier.appProperties.name);
        System.out.println("appProperties utility: " + AppPropertiesModifier.appProperties.utility);
        System.out.println("appProperties price: " + AppPropertiesModifier.appProperties.price);
        System.out.println("appProperties someLong: " + AppPropertiesModifier.appProperties.someLong);
    }
}
