package objectsMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProcessPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@id='hold']")
	private WebElement holdOrdersTab_link;

	@FindBy(xpath = "//button[@class='btn text-white hold_buttons manual_hold ml-2 mb-2 bg_theme']")
	private WebElement holdTab_manualHold_link;

	@FindBy(xpath = "//a[@class='detail'][@id='373']")
	private WebElement viewManualHoldOrders;

	@FindBy(xpath = "//button[@build_type='now']")
	private WebElement holdTab_clickBuildNow;

	@FindBy(id = "build")
	private WebElement buildTab_link;

	@FindBy(xpath = "//a[@class='detail'][@id='373']")
	private WebElement buildViewDetails;

	@FindBy(xpath = "//button[@id='in_progress_order']")
	private WebElement buildTab_prepareOrder;

	@FindBy(id = "in_progress")
	private WebElement inProgressLink;

	@FindBy(xpath = "//a[@class='detail'][@id='373']")
	private WebElement inProgressViewDetails;

	@FindBy(xpath = "//button[@id='ready_for_delivery']")
	private WebElement inProgessTab_readyForDeliveryBtn;

	@FindBy(xpath = "//h3[@class='ready_for_pickup_head']")
	private WebElement readyForDelivery_pickup_link;

	@FindBy(id = "delivery_order")
	private WebElement readyForDelivery_sub_link;

	@FindBy(xpath = "//a[@class='detail'][@id='373']")
	private WebElement readyForDeliveryViewDetails;

	@FindBy(xpath = "//button[@class='btn btn-success btn-sm change_order_status mr-3 ']")
	private WebElement CompleteBtn;

	@FindBy(xpath = "//div[@class='dash_home']/a[@id='complete']")
	private WebElement completeLink;

	@FindBy(xpath = "//a[@class='detail'][@id='373']")
	private WebElement completeViewDetails;

	@FindBy(xpath = "(//button[@class='close'])[5]")
	private WebElement completeTab_closeEyeWindow;

	public OrderProcessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void Time_wait(WebElement element) {
		FluentWait<WebDriver> fluent = new FluentWait<>(driver);
		fluent.withTimeout(Duration.ofSeconds(40));
		fluent.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);

		fluent.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void elementClickableTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void holdOrderTab() {

		Time_wait(holdOrdersTab_link);
		holdOrdersTab_link.click();

	}

	public void manualHoldOrderTab() throws InterruptedException {

		Time_wait(viewManualHoldOrders);
		viewManualHoldOrders.click();
		TimeUnit.SECONDS.sleep(1);

	}

	public void buildNowButton() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(holdTab_clickBuildNow);
		holdTab_clickBuildNow.sendKeys(Keys.RETURN);
		TimeUnit.SECONDS.sleep(2);

	}

	public void buildOrderlink() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)");

		Time_wait(holdOrdersTab_link);
		holdOrdersTab_link.click();

		Time_wait(buildTab_link);
		buildTab_link.click();
		TimeUnit.SECONDS.sleep(2);

	}

	public void viewBuildOrder() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(buildViewDetails);
		buildViewDetails.click();
		TimeUnit.SECONDS.sleep(2);

	}

	public void prepareOrderButton() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(buildTab_prepareOrder);
		buildTab_prepareOrder.click();
		TimeUnit.SECONDS.sleep(2);

	}

	public void inProgressLink() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)");
		Time_wait(inProgressLink);
		inProgressLink.click();
		TimeUnit.SECONDS.sleep(2);

	}

	public void viewInProgressOrder() throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(inProgressViewDetails);
		inProgressViewDetails.click();
		TimeUnit.SECONDS.sleep(1);

	}

	public void readyForDeliveryButton() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		elementClickableTime(inProgessTab_readyForDeliveryBtn);
		inProgessTab_readyForDeliveryBtn.sendKeys(Keys.RETURN);
		TimeUnit.SECONDS.sleep(2);

	}

	public void readyForDeliveryPickup() {

		Time_wait(readyForDelivery_pickup_link);
		readyForDelivery_pickup_link.click();
//		TimeUnit.SECONDS.sleep(800);

	}

	public void subLink() throws InterruptedException {

		Time_wait(readyForDelivery_sub_link);
		readyForDelivery_sub_link.sendKeys(Keys.RETURN);
		TimeUnit.SECONDS.sleep(1);

	}

	public void viewReadyForDeliveryOrders() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(readyForDeliveryViewDetails);
		readyForDeliveryViewDetails.click();
		TimeUnit.SECONDS.sleep(2);

	}

	public void completeButton() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(CompleteBtn);
		CompleteBtn.sendKeys(Keys.RETURN);
		TimeUnit.SECONDS.sleep(1);

	}

	public void completeTab() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)");
		Time_wait(completeLink);
		completeLink.click();
		TimeUnit.SECONDS.sleep(1);

	}

	public void viewCompletedOrder() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(completeViewDetails);
		completeViewDetails.sendKeys(Keys.RETURN);
		TimeUnit.SECONDS.sleep(1);

	}

	public void closeViewWindow() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)");
		Time_wait(completeTab_closeEyeWindow);
		completeTab_closeEyeWindow.sendKeys(Keys.RETURN);

	}
}