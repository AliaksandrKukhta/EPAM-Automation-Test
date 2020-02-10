package com.epam.automation.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;

    @FindBy(xpath = ".//a[@data-url-1=\"https://www.tut.by/resource/?id=10&ua=top_menu_www.tut.by%7E10#ua:top_menu_www." +
            "tut.by~10\"]")
    private WebElement mail;
    @FindBy(name = "login")
    private WebElement login;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = ".//input[@type=\"submit\"]")
    private WebElement enterButton;
    @FindBy(xpath = ".//div[text()=\"com.epam.automation.mail-test1@tut.by\"]")
    private WebElement log;
    @FindBy(xpath = ".//a[@href=\"#sent\"]")
    private WebElement sendFolder;
    @FindBy(xpath = "(.//div[@class=\"b-messages__placeholder-item\"])[1]")
    private WebElement e_mailMessage;
    @FindBy(xpath = ".//span[text()=\"Test E-Mail through Java\"]")
    private WebElement messageTopic;
    @FindBy(xpath = ".//span[@class=\"com.epam.automation.mail-ComposeButton-Text\"]")
    private WebElement writeNewMessageButton;
    @FindBy(name = "to")
    private WebElement whom;
    @FindBy(xpath = ".//div[@role=\"textbox\"]")
    private WebElement text;
    @FindBy(xpath = "(.//button[@type=\"submit\"]")
    private WebElement sendButton;
    @FindBy(xpath = ".//div[@class=\"com.epam.automation.mail-Done-Title js-title-info\"]")
    private WebElement sendLetterMessage;

    public MailPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
    }


    public void clickNewMessageButton() {
        writeNewMessageButton.click();
    }

    public void clearWhomLine() {
        whom.clear();
    }

    public void fillingInWhom(String e_Mail) {
        whom.sendKeys(e_Mail);
    }

    public void cleatTextLine() {
        text.clear();
    }

    public void fillingInTextMessage(String someText) {
        text.sendKeys(someText);
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public boolean isSendLetterMessageDisplayed() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sendLetterMessage));
        return sendLetterMessage.isDisplayed();
    }

    public void clickMail() {
        mail.click();
    }

    public void clearLoginLine() {
        login.clear();
    }

    public void fillingInLoginLine(String name) {
        login.sendKeys(name);
    }

    public void clearPasswordLine() {
        password.clear();
    }

    public void fillingInPasswordLine(String pass) {
        password.sendKeys(pass);
    }

    public void clickEnterButton() {
        enterButton.click();
    }

    public boolean IsMessageInInboxDisplayed() {
        return messageTopic.isDisplayed();
    }

    public boolean isSendFolderDisplayed() {
        sendFolder.click();
        return e_mailMessage.isDisplayed();
    }

}