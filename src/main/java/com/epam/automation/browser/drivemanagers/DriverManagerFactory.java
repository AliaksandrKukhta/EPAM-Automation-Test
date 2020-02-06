package com.epam.automation.browser.drivemanagers;

import com.epam.automation.browser.DriverType;
import com.epam.automation.browser.drivemanagers.browsermanager.ChromeDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                throw new IllegalArgumentException("No such driver type");
        }
        return driverManager;
    }
}