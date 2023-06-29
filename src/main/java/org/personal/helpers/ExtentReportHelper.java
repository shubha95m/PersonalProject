package org.personal.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ExtentReportHelper {

    private static String testName;
    private static WebDriver driver;
    private static final String getCurrentDate = DateTimeFormatter.ofPattern("dd MMMM yyyy").format(LocalDateTime.now());
    private static final String path = "src/target/ReportsAndScreenshots/" + getCurrentDate + "/" + getDateTimeInEpoc() + "/";
    private static final ExtentReports extent = new ExtentReports();
    public final ExtentSparkReporter spark = new ExtentSparkReporter(path + "Report.html");
    public static ExtentTest log;

    public ExtentReportHelper(String lTestName, WebDriver lDriver) {
        testName = lTestName;
        driver = lDriver;

        extent.attachReporter(spark);
        log = extent.createTest(testName);
    }

    public void setStatus(String status, String title, String... details) {
        if (status.equals("pass")) {
            log.info("screenshot path is:");
            log.pass(Arrays.toString(details), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(), title).build());
        } else {
            log.info("screenshot path is:");
            log.fail(Arrays.toString(details), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(), title).build());
        }
    }

    public void flush() {
        extent.flush();
    }

    public static String getDateTimeInEpoc() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String takeScreenshot() {
        File screenshotPath = new File(path + getDateTimeInEpoc() + testName +  "_Screenshot.png");
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("screenshot path is: " + File.separator + screenshotPath);
        return File.separator + screenshotPath;
    }

}
