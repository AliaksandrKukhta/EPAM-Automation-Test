package com.epam.automation.screen;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ListenersClass implements ITestListener {
    protected final Logger logger = Logger.getLogger(ListenersClass.class);
    private static final String screenshortFilenamePattern = "D:/Java/AUTOMATION/Test/screenshots/FailedTest.png";
    public ITestResult res;

    public void onTestFailure(ITestResult result) {
        logger.info(String.format("Test failed %s", result.getName()));
        WebDriver driver = (WebDriver)result.getTestContext().getAttribute("webDriver");
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        String fileName = String.format(screenshortFilenamePattern, result.getName(), LocalDateTime.now());
        logger.warn("Get the test results");
        res=result;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(fileName));
        } catch (IOException e) {
           throw new ScreenshotException("failed to take a screenshot", e);
        }
        logger.info(String.format("Screenshot [%s] saved", fileName));

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Success Test");
        logger.info(String.format("Test success %s", result.getName()));
        res=result;
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped Test");
        logger.info(String.format("Test skipped %s", result.getName()));
        res=result;
    }
}
