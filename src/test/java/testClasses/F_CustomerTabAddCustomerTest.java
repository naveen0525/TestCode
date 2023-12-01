package testClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import objectsMethods.CustomerTabAddCustomerPage;
import objectsMethods.LoginPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
public class F_CustomerTabAddCustomerTest extends BaseClass {

	LoginPage loginPg;
	CustomerTabAddCustomerPage addCustPg;

	/* This test is for Adding New Customer */
	@Test
	public void addCustomer() throws IOException, InterruptedException {
		driver = setUp();
		loginPg = new LoginPage(driver);
		addCustPg = new CustomerTabAddCustomerPage(driver);
		Properties prop = readPropertiesFile(".\\src\\Resources\\Property\\AddNewCustomer.properties");
		test = report.startTest("AddCustomer");

		/* Provider's Customer DashBoard */

		/* TestCase# 11 */
		loginPg.enterCredentials(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
		test.log(LogStatus.INFO, "Enter Email ID and Password");

		loginPg.clickLogin();
		test.log(LogStatus.INFO, "Click on Login Button");

		addCustPg.clickCustomerDashboardLink();
		test.log(LogStatus.INFO, "Click on Customer Dashboard Link");

		addCustPg.clickCustomerListTab();
		test.log(LogStatus.INFO, "Click on Customer List Tab");

		addCustPg.clickAddNewButton();
		test.log(LogStatus.INFO, "Click on Add New Button");

		addCustPg.addCustomerAction(prop.getProperty("CustomerTabFirstName"), prop.getProperty("CustomerTabLastName"),
				prop.getProperty("CustomerTabEmail"), prop.getProperty("CustomerTabPhone"),
				prop.getProperty("CustomerTabCompany"), prop.getProperty("CustomerTabSalesRepresentative"),
				prop.getProperty("CustomerTabAddress"), prop.getProperty("CustomerTabCountry"),
				prop.getProperty("CustomerTabState"), prop.getProperty("CustomerTabCity"),
				prop.getProperty("CustomerTabLocation"), prop.getProperty("CustomerTabStreet"));
		test.log(LogStatus.INFO, "Enter New Customer Detail");

		addCustPg.clickSubmitButton();
		test.log(LogStatus.INFO, "Click on Submit Button");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		WebElement element = driver.findElement(By.xpath("(//strong)[1]"));

		String expectedValue = "Record has been saved successfully.";

		Assert.assertEquals(element.getText(), expectedValue);
		System.out.print("------ Add New Customer ");

	}
}
