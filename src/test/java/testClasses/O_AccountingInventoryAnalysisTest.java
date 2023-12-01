package testClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import objectsMethods.AccountingInventoryAnalysisPage;
import objectsMethods.LoginPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
public class O_AccountingInventoryAnalysisTest extends BaseClass {

	LoginPage loginPg;
	AccountingInventoryAnalysisPage InvAnalysisPg;

	/* This test is for filtering Inventory Analysis Report */
	@Test
	public void inventoryAnalysisReport() throws IOException, InterruptedException {

		driver = setUp();
		loginPg = new LoginPage(driver);
		InvAnalysisPg = new AccountingInventoryAnalysisPage(driver);
		Properties prop = readPropertiesFile("./src/Resources/Property/InventoryAnalysis.properties");
		test = report.startTest("inventoryAnalysisReport");

		loginPg.enterCredentials(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
		test.log(LogStatus.INFO, "Enter Email ID and Password");

		loginPg.clickLogin();
		test.log(LogStatus.INFO, "Click on Login Button");

		InvAnalysisPg.accountingDashboard();
		test.log(LogStatus.INFO, "Click on Accounting Dashboard");

		InvAnalysisPg.popUpWindow(prop.getProperty("Password"));
		test.log(LogStatus.INFO, "Enter Password and Click on Verify Button");

		InvAnalysisPg.selectDate(prop.getProperty("fromDate"), prop.getProperty("toDate"));
		test.log(LogStatus.INFO, "Select from and to date");

		InvAnalysisPg.clickSubmitButton();
		test.log(LogStatus.INFO, "Click on Submit Button");

		WebElement element = driver.findElement(By.xpath("//p[contains(text(), 'Inventory Analysis')]"));

		String expectedValue = ("Inventory Analysis");

		Assert.assertEquals(element.getText(), expectedValue);
		System.out.print("------");

	}

}
