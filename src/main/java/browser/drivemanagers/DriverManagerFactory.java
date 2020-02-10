package browser.drivemanagers;

import browser.DriverType;
import browser.drivemanagers.browsermanager.ChromeDriverManager;

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