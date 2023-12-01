package testClasses;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import objectsMethods.LoginPage;
import objectsMethods.OrderProcessPage;
import utiles.BaseClass;

@Listeners(BaseClass.class)
public class H_OrderProcessTest extends BaseClass {
	LoginPage loginPg;
	OrderProcessPage orderProcessPg;

	/* This test is for Order Processing. */
	@Test
	public void buildOrders() throws Exception {
		driver = setUp();
		loginPg = new LoginPage(driver);
		orderProcessPg = new OrderProcessPage(driver);
		Properties prop = readPropertiesFile("./src/Resources/Property/url.properties");
//		test = report.startTest("orderProcessing");

		/* Provider's DashBoard */

		/* TestCase# 03 */
		loginPg.enterCredentials(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"));
//		test.log(LogStatus.INFO, "Enter Email ID and Password");

		loginPg.clickLogin();
//		test.log(LogStatus.INFO, "Click on Login Button");

		/* Provider's Home DashBoard */

		/* TestCase# 16 */
		orderProcessPg.holdOrderTab();
//		test.log(LogStatus.INFO, "Click on HoldOrder Tab");

		/* TestCase# 17 */
		orderProcessPg.manualHoldOrderTab();
//		test.log(LogStatus.INFO, "Click on View Button");

		/* TestCase# 21 */
		orderProcessPg.buildNowButton();
//		test.log(LogStatus.INFO, "Click on Build Now Button");

		/* TestCase# 38 */
		orderProcessPg.buildOrderlink();
//		test.log(LogStatus.INFO, "Click on BuildOrder Tab");

		/* TestCase# 42 */
		orderProcessPg.viewBuildOrder();
//		test.log(LogStatus.INFO, "Click on View Button");

		/* TestCase# 45 */
		orderProcessPg.prepareOrderButton();
//		test.log(LogStatus.INFO, "Click on PrepareOrder Button");

		/* TestCase# 47 */
		orderProcessPg.inProgressLink();
//		test.log(LogStatus.INFO, "Click on InProgress Tab");

		/* TestCase# 54 */
		orderProcessPg.viewInProgressOrder();
//		test.log(LogStatus.INFO, "Click on View Button");

		/* TestCase# 57 */
		orderProcessPg.readyForDeliveryButton();
//		test.log(LogStatus.INFO, "Click on Ready For Delivery/Pickup Button");

		/* TestCase# 67 */
		orderProcessPg.readyForDeliveryPickup();
//		test.log(LogStatus.INFO, "Click on Ready For Delivery/Pickup Link");

		/* TestCase# 73 */
		orderProcessPg.subLink();
//		test.log(LogStatus.INFO, "Click on Ready For Delivery sub_link Tab");

		/* TestCase# 76 */
		orderProcessPg.viewReadyForDeliveryOrders();
//		test.log(LogStatus.INFO, "Click on View Button");

		/* TestCase# 80 & 81 */
		orderProcessPg.completeButton();
//		test.log(LogStatus.INFO, "Click on Complete Button");

		/* TestCase# 97 */
		orderProcessPg.completeTab();
//		test.log(LogStatus.INFO, "Click on Complete Tab");

		/* TestCase# 100 */
		orderProcessPg.viewCompletedOrder();
//		test.log(LogStatus.INFO, "Click on View Button");

		/* TestCase# 105 */
		orderProcessPg.closeViewWindow();
//		test.log(LogStatus.INFO, "Click on Cross Icon");

		WebElement element = driver.findElement(By.xpath("//div[contains(text(), 'Order Changed successfully.')]"));

		String expectedValue = "Order Changed successfully.";
		Assert.assertEquals(element.getText(), expectedValue);

		System.out.print("------");
	}

}
