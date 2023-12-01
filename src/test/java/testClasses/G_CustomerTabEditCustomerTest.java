package testClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import objectsMethods.CustomerTabEditCustomerPage;
import objectsMethods.LoginPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
public class G_CustomerTabEditCustomerTest extends BaseClass {

	LoginPage loginPg;
	CustomerTabEditCustomerPage EditCustPg;

	/* This test is for Editing the Customer. */

	@Test
	public void editCustomer() throws IOException, InterruptedException {
		driver = setUp();
		loginPg = new LoginPage(driver);
		EditCustPg = new CustomerTabEditCustomerPage(driver);
		Properties prop = readPropertiesFile(".\\src\\Resources\\Property\\EditCustomerDetail.properties");
		test = report.startTest("EditCustomer");

		/* Provider's Customer DashBoard */

		/* TestCase# 37 */
		loginPg.enterCredentials(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
		test.log(LogStatus.INFO, "Enter Email ID and Password");

		loginPg.clickLogin();
		test.log(LogStatus.INFO, "Click on Login Button");

		EditCustPg.clickCustomerDashboard();
		test.log(LogStatus.INFO, "Click on Customer Dashboard Link");

		EditCustPg.clickCustomerList();
		test.log(LogStatus.INFO, "Click on Customer Tab");

		EditCustPg.editCustomer_Action(prop.getProperty("SearchCustomer"), prop.getProperty("CustomerTabEditEmail"));
		test.log(LogStatus.INFO, "Search Customer, click on Edit button and Enter Details");

		EditCustPg.submitButton();
		test.log(LogStatus.INFO, "Click on Submit Button");

		WebElement element = driver.findElement(By.xpath("(//strong)[1]"));

		String expectedValue = "Record Updated Successfully.";

		Assert.assertEquals(element.getText(), expectedValue);
		System.out.print("------");

	}

}
