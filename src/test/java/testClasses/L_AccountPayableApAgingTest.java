package testClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import objectsMethods.AccountPayablePageApAging;
import objectsMethods.LoginPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
public class L_AccountPayableApAgingTest extends BaseClass {

	LoginPage loginPg;
	AccountPayablePageApAging ApAging;

	/* This test is to showing AP Aging. */
	@Test
	public void agAgingTab() throws IOException, InterruptedException {

		driver = setUp();
		loginPg = new LoginPage(driver);
		ApAging = new AccountPayablePageApAging(driver);
		Properties prop = readPropertiesFile("./src/Resources/Property/accountingPayable.properties");
		test = report.startTest("agAgingTab");

		loginPg.enterCredentials(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
		test.log(LogStatus.INFO, "Enter Email ID and Password");

		loginPg.clickLogin();
		test.log(LogStatus.INFO, "Click on Login Button");

		ApAging.accountingDashboard();
		test.log(LogStatus.INFO, "Click on Accounting Dashboard");

		ApAging.apAging();
		test.log(LogStatus.INFO, "Click on AP Aging Button");

		WebElement element = driver.findElement(By.xpath("(//div[@class='row'])[2]"));

		String expectedValue = "Account Payable";

		Assert.assertEquals(element.getText(), expectedValue);
		System.out.print("------");

	}

}
