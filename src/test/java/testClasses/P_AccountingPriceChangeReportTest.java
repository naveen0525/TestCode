package testClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import objectsMethods.AccountingPriceChangeReportPage;
import objectsMethods.LoginPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
public class P_AccountingPriceChangeReportTest extends BaseClass {

	LoginPage loginPg;
	AccountingPriceChangeReportPage PriceChangeRprtPg;

	/* This test is for filtering the Price change report. */
	@Test
	public void priceChangeReport() throws IOException, InterruptedException {

		driver = setUp();
		loginPg = new LoginPage(driver);
		PriceChangeRprtPg = new AccountingPriceChangeReportPage(driver);
		Properties prop = readPropertiesFile("./src/Resources/Property/PriceChangeReport.properties");
		test = report.startTest("priceChangeReport");

		loginPg.enterCredentials(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
		test.log(LogStatus.INFO, "Enter Email ID and Password");

		loginPg.clickLogin();
		test.log(LogStatus.INFO, "Click on Login Button");

		PriceChangeRprtPg.accountingDashboard();
		test.log(LogStatus.INFO, "Click on Accounting Dashboard");

		PriceChangeRprtPg.selectDate(prop.getProperty("fromDate"), prop.getProperty("toDate"));
		test.log(LogStatus.INFO, "Select from and to date");

		PriceChangeRprtPg.clickSubmitButton();
		test.log(LogStatus.INFO, "Click on Submit Button");
		
		WebElement element = driver.findElement(By.xpath("//h5[contains(text(), 'Price Change Report')]"));

		String expectedValue = "Price Change Report";

		Assert.assertEquals(element.getText(), expectedValue);
		System.out.print("------");
	}

}
