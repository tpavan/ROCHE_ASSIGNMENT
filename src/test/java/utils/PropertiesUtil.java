package utils;

import config.TestConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties properties = null;
    private static String propertyDirectory = "/resources/properties/";

    public static Properties loadProperties(String propertyFile) {

        propertyFile = TestConfig.appDir.concat(propertyDirectory).concat(propertyFile);

        properties = new Properties();
        try {
            properties.load(new FileInputStream(propertyFile));
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException io) {
            io.fillInStackTrace();
        }
        return properties;
    }

    public static Properties getPropertyInsts() {
        return properties;
    }
}
