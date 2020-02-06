package com.epam.automation.browser.configuration;

import com.epam.automation.browser.DriverType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String RESOURCES_PATH = "src\\main\\resources\\";
    private static Properties properties;

    public static void readProperties() {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            properties.load(new FileReader(new File(RESOURCES_PATH, "env.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "chrome.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "browser.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "mail.properties")));
            properties.load(new FileReader(new File(RESOURCES_PATH, "datasource.properties")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DriverType getDriverType() {
        if (properties == null) {
            readProperties();
        }
        return DriverType.valueOf(properties.getProperty("browserType"));
    }

    public static String getMainURL() {
        if (properties == null) {
            readProperties();
        }
        return (properties.getProperty("mainUrl"));
    }
    public static String getLoginOne() {
        if (properties == null) {
            readProperties();
        }
        return (properties.getProperty("mailOne"));
    }
    public static String getLoginTwo() {
        if (properties == null) {
            readProperties();
        }
        return (properties.getProperty("mailTwo"));
    }
    public static String getMailPassword() {
        if (properties == null) {
            readProperties();
        }
        return (properties.getProperty("mailPassword"));
    }
    public static String getDataUrl() {
        if (properties == null) {
            readProperties();
        }
        return (properties.getProperty("dataUrl"));
    }
    public static String getDataUser() {
        if (properties == null) {
            readProperties();
        }
        return (properties.getProperty("dataUser"));
    }
    public static String getDataPassword() {
        if (properties == null) {
            readProperties();
        }
        return (properties.getProperty("dataPassword"));
    }
}
