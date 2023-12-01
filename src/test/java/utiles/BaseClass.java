package utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass implements ITestListener {

    public static WebDriver driver;
    public static ExtentReports report;
    protected static ExtentTest test;
    public static ITestResult result;

    public WebDriver setUp() throws IOException {

        Properties prop = readPropertiesFile("./src/Resources/Property/url.properties");

        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("----window-size=1440x600");
        options.addArguments("----headless");
        WebDriver driver = new ChromeDriver(options);

//        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        System.out.println("Running the browser");

        return driver;

    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
        
    }

    public static String scrShot(String screenShotName) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date d = new Date();

        String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");

        File Dest = new File("./src/Resources/screenshots/" + screenShotName + "_" + TimeStamp + ".png");
        
        String errflpath = Dest.getAbsolutePath();
        try {
            FileUtils.copyFile(scrFile, Dest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            test.log(LogStatus.FAIL, e);
        }
        return errflpath;

    }

    public void scrollPageDown() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        report = new ExtentReports("./reports/ExtentReportResults.html/");

    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, (result.getName() + " Test PASSED"));
            report.flush();
        }

        System.out.println("Test Pass");
        driver.quit();
    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub

        scrShot(result.getMethod().getMethodName());

        if (result.getStatus() == ITestResult.FAILURE) {

//			test.log(LogStatus.FAIL, (result.getName() + " Test FAILED "));
            String screenShot = scrShot(result.getName());
            test.log(LogStatus.FAIL, "Test Failed: " + test.addScreenCapture(screenShot));
            test.log(LogStatus.FAIL, result.getThrowable());
            report.flush();

        }

        System.out.println("Test Fail");
        driver.quit();

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
//		driver.close();

    }

}
