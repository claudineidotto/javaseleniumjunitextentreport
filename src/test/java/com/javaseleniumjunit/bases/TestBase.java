package com.javaseleniumjunit.bases;

import com.aventstack.extentreports.Status;
import com.javaseleniumjunit.utils.BDUtils;
import com.javaseleniumjunit.utils.ExtentReportUtils;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import com.javaseleniumjunit.utils.DriverFactory;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.javaseleniumjunit.utils.ExtentReportUtils.TEST;


public class TestBase {

    @BeforeClass
    public static void init(){
   // BDUtils bdUtils = new BDUtils();
    ExtentReportUtils.createReport();
    //bdUtils.criarProjetoCarga();
    }

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        DriverFactory.createInstance();
        DriverFactory.Instance.manage().window().maximize();
        ExtentReportUtils.createReport();
        ExtentReportUtils.addTest("teste","teste");
    }

    @After
    public void teardown() throws IOException {
        TakesScreenshot ts = (TakesScreenshot)DriverFactory.Instance;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "C:\\RepositoriodeProjetos\\javaseleniumjunitextentreport\\reports\\teste.png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        TEST.log(Status.INFO, "Snapshot below: " + TEST.addScreenCaptureFromPath(dest));

        DriverFactory.Instance.quit();
        ExtentReportUtils.generateReport();
    }
}
