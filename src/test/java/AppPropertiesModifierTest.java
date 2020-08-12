import static org.junit.jupiter.api.Assertions.*;

class AppPropertiesModifierTest {

    @org.junit.jupiter.api.Test
    void modify() throws NoSuchFieldException {

        assertEquals(AppPropertiesModifier.appProperties.id, 0);
        assertNull(AppPropertiesModifier.appProperties.name);
        assertFalse(AppPropertiesModifier.appProperties.utility);
        assertEquals(AppPropertiesModifier.appProperties.price, 0);
        assertEquals(AppPropertiesModifier.appProperties.someLong, 0);

        AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("id"));
        assertEquals(AppPropertiesModifier.appProperties.id, 0);

        AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("name"));
        assertEquals(AppPropertiesModifier.appProperties.name, "appProperties name");

        AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("utility"));
        assertTrue(AppPropertiesModifier.appProperties.utility);

        AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("price"));
        assertEquals(AppPropertiesModifier.appProperties.price, 100);

        AppPropertiesModifier.modify(AppPropertiesModifier.appProperties.getClass().getDeclaredField("someLong"));
        assertEquals(AppPropertiesModifier.appProperties.someLong, 0);

    }
}