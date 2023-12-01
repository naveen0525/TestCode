package testClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectsMethods.RegistrationPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
public class A_RegistrationTest extends BaseClass {
	RegistrationPage registrationpg;

	/* This test is for the User Registration */
	@Test
	public void registration() throws IOException, InterruptedException {
		driver = setUp();
		registrationpg = new RegistrationPage(driver);
		Properties prop = readPropertiesFile("./src/Resources/Property/newRegistration.properties");
//		test = report.startTest("registration");

		/* Provider's DashBoard */
		
		/* TestCase# 01 */
		registrationpg.clickRegistrationButton();
//		test.log(LogStatus.INFO, "Click on Registration Button");

		/* TestCase# 02 */
		registrationpg.registrationDetails(prop.getProperty("Fname"), prop.getProperty("Lname"),
				prop.getProperty("registerEmail"), prop.getProperty("company"), prop.getProperty("registerPassword"),
				prop.getProperty("cpassword"), prop.getProperty("phone"), prop.getProperty("provider"));
//		test.log(LogStatus.INFO, "Enter New Customer Details");

		registrationpg.clickSubmitButton();
//		test.log(LogStatus.INFO, "Click on Submit Button");

		WebElement element = driver.findElement(By.xpath("//strong"));

		String expectedValue = "User has been registered successfully.";

		Assert.assertEquals(element.getText(), expectedValue);
		System.out.print("------");

	}

}