package com.epam.automation.mail;

import com.epam.automation.browser.DriverType;
import com.epam.automation.browser.configuration.Configuration;
import com.epam.automation.browser.drivemanagers.DriverManager;
import com.epam.automation.browser.drivemanagers.DriverManagerFactory;
import com.epam.automation.data.DataBase;
import com.epam.automation.model.User;
import com.epam.automation.screen.ListenersClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import com.epam.automation.parsing.Parsing;
import com.epam.automation.send.SendEmail;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;

@Listeners(ListenersClass.class)
public class MailPageTest {
    ListenersClass listenersClass = new ListenersClass();
    DataBase dataBase = new DataBase();
    public static WebDriver driver;
    Map<String, ITestResult> accounts = new HashMap<>();
    ArrayList<String> usersMail = new ArrayList<>();
    String someMail = null;
    private MailPage mail;
    DriverManager driverManager;
    Parsing parsing = new Parsing();
    SendEmail sendEmail = new SendEmail();
    User lobanov = new User();
    User vasechkin = new User();
    User letnik = new User();
    User jarosh = new User();
    User kashirov = new User();
    User revt = new User();
    protected final Logger logger = Logger.getLogger(MailPageTest.class);
    private String messageText = "Some text";
    private static final String USERS_XML = "D:\\Java\\AUTOMATION\\Test\\src\\main\\resources\\users.xml";
    private static final String USERS_CSV = "D:\\Java\\AUTOMATION\\Test\\src\\main\\resources\\user.txt";

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, SECONDS);
        context.setAttribute("webDriver", driver);
        logger.trace("Use implicitlyWait");
        driver.get(Configuration.getMainURL());
        mail = new MailPage(driver);
        dataBase.fillingInUser(usersMail);
        logger.info("Filling in usersMail from DB");
        System.out.println(usersMail);
        parsing.cSVParse(USERS_CSV);
        logger.warn("com.epam.automation.parsing csv file");
        parsing.xMLParse(USERS_XML);
        logger.warn("com.epam.automation.parsing xml File");
    }

    public String returnE_Mail(String e_mail) {
        return someMail = e_mail;
    }

    public void send(String e_mail, String messageText) {
        mail.clickMail();
        mail.clearLoginLine();
        mail.fillingInLoginLine(Configuration.getLoginTwo());
        mail.clearPasswordLine();
        mail.fillingInPasswordLine(Configuration.getMailPassword());
        mail.clickEnterButton();
        mail.clickNewMessageButton();
        mail.clearWhomLine();
        mail.fillingInWhom(returnE_Mail(e_mail));
        mail.cleatTextLine();
        mail.fillingInTextMessage(messageText);
        mail.clickSendButton();
    }

    @Test
    public void sendSecondLetter() {
        send(usersMail.get(1), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendFirstLetter() {
        send(usersMail.get(0), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendThirdLetter() {
        send(usersMail.get(2), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendFourthLetter() {
        send(usersMail.get(3), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendFifthLetter() {
        send(lobanov.getE_mail(), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendSixLetter() {
        send(vasechkin.getE_mail(), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendSeventhLetter() {
        send(letnik.getE_mail(), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendEighthLetter() {
        send(jarosh.getE_mail(), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendNinthLetter() {
        send(kashirov.getE_mail(), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendTenthLetter() {
        send(revt.getE_mail(), messageText);
        Assert.assertTrue(mail.isSendLetterMessageDisplayed());
    }

    @Test
    public void sendFolder() {
        mail.clickMail();
        mail.clearLoginLine();
        mail.fillingInLoginLine(Configuration.getLoginOne());
        mail.clearPasswordLine();
        mail.fillingInPasswordLine(Configuration.getMailPassword());
        mail.clickEnterButton();
        Assert.assertTrue(mail.isSendFolderDisplayed());
    }

    @Test
    public void inbox() {
        sendEmail.sendAPIMessage();
        logger.info("Send Message from account1 to account2");
        mail.clickMail();
        mail.clearLoginLine();
        mail.fillingInLoginLine(Configuration.getLoginTwo());
        mail.clearPasswordLine();
        mail.fillingInPasswordLine(Configuration.getMailPassword());
        mail.clickEnterButton();
        Assert.assertTrue(mail.IsMessageInInboxDisplayed());
    }

    @AfterTest
    public void testResults() {
        accounts.put(someMail, listenersClass.res);
        logger.info("Display accounts with test results");
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
        logger.trace("quit Driver");
    }
}