package objectsMethods;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerTabEditCustomerPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/customer/link/']")
	private WebElement clickCustomer_Link;

	@FindBy(xpath = "//a[@href='/customer/list/']")
	private WebElement customerList;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchCustomer;

	@FindBy(xpath = "//*[@id='customer_list']/tbody/tr[1]/td[8]/a[2]/i")
	private WebElement clickEditBtn;

	@FindBy(name = "email")
	private WebElement EnterEmail;

	@FindBy(id = "submit-id-save")
	private WebElement submitBtn;

	public CustomerTabEditCustomerPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void Time_wait(WebElement element) {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(40));
		fluent.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);

		fluent.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void elementClickableTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickCustomerDashboard() {

		Time_wait(clickCustomer_Link);
		clickCustomer_Link.click();
	}

	public void clickCustomerList() {

		elementClickableTime(customerList);
		customerList.click();
	}

	public void editCustomer_Action(String search, String email) throws InterruptedException {

		elementClickableTime(searchCustomer);
		searchCustomer.click();

		Time_wait(searchCustomer);
		searchCustomer.sendKeys(search);
		Thread.sleep(2000);

		elementClickableTime(clickEditBtn);
		clickEditBtn.click();

		Time_wait(EnterEmail);
		EnterEmail.clear();
		Thread.sleep(2000);

		Time_wait(EnterEmail);
		EnterEmail.sendKeys(email);
		Thread.sleep(1000);

	}

	public void submitButton() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(submitBtn);
		submitBtn.click();
	}

}
