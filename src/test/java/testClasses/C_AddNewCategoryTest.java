package testClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import objectsMethods.AddNewCategoryPage;
import objectsMethods.LoginPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
/* This test is for Adding New Category */
public class C_AddNewCategoryTest extends BaseClass {

	LoginPage loginPg;
	AddNewCategoryPage AddCategoryPg;

	/* This test is for Adding New Category */
	@Test
	public void addNewCategory() throws IOException, InterruptedException {
		driver = setUp();
		loginPg = new LoginPage(driver);
		AddCategoryPg = new AddNewCategoryPage(driver);
		Properties prop = readPropertiesFile(".\\src\\Resources\\Property\\addNewCategory.properties");
		test = report.startTest("addNewCategory");

		/* Provider's Inventory DashBoard */

		/* TestCase# 03 */
		loginPg.enterCredentials(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
		test.log(LogStatus.INFO, "Enter Email ID and Password");

		loginPg.clickLogin();
		test.log(LogStatus.INFO, "Click on Login button");

		AddCategoryPg.clickInventoryDashBoard();
		test.log(LogStatus.INFO, "Click on Inventory Dashboard Link");

		AddCategoryPg.clickOnCategoryTab();
		test.log(LogStatus.INFO, "Click on CategoryTab");

		AddCategoryPg.clickOnaddNewCatoryButton();
		test.log(LogStatus.INFO, "Click on Add New Category Button");

		AddCategoryPg.addNewCategory_action(prop.getProperty("NewCategoryName"),
				prop.getProperty("NewCategoryDescription"), prop.getProperty("NewCategoryPriority"),
				prop.getProperty("NewCategoryUOM"), prop.getProperty("NewCategorySize"));
		test.log(LogStatus.INFO, "Enter New Category Detail");

		AddCategoryPg.saveButton();
		test.log(LogStatus.INFO, "Click on Save Button");

		WebElement element = driver.findElement(By.xpath("(//strong)[1]"));

		String expectedValue = "Record has been saved successfully.";

		Assert.assertEquals(element.getText(), expectedValue);
		System.out.print("------");

	}

}
