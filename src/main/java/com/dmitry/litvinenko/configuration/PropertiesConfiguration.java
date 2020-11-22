package com.dmitry.litvinenko.configuration;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesConfiguration {
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties prop = new Properties();

    private PropertiesConfiguration() {}

    public static String getGoogleHomeUrl() { return getProperty("google.home.url"); }

    @SneakyThrows
    private static String getProperty(String property) {
        prop.load(new FileInputStream(CONFIG_FILE_PATH));
        return prop.getProperty(property);
    }
}