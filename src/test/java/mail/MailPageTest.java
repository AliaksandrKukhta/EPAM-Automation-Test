package mail;

import browser.DriverType;
import browser.configuration.Configuration;
import browser.drivemanagers.DriverManager;
import browser.drivemanagers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MailPageTest {
    private MailPage mail;
    DriverManager driverManager;
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, SECONDS);
        driver.get(Configuration.getMainURL());
        mail = new MailPage(driver);
        mail.clickMail();
        mail.clearLoginLine();
        mail.fillingInLoginLine(Configuration.getMailLogin());
        mail.clearPasswordLine();
        mail.fillingInPasswordLine(Configuration.getMailPassword());
        mail.clickEnterButton();
    }

    @Test
    public void getInfo(){
        mail.getLettersInfo();
        mail.getAllLetters();
        Assert.assertTrue(mail.isLettersInfoDisplayed());
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
}