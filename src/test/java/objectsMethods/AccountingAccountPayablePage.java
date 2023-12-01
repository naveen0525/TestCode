package objectsMethods;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountingAccountPayablePage {

	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/management/accounting/accounting-sub-menus/']")
	private WebElement clickAccountingDashboard;

	@FindBy(xpath = "//a[@href='/management/accounting/get-account-payable-orders/']")
	private WebElement clickAccountPayable;

	@FindBy(name = "from_date")
	private WebElement selectFromDate;

	@FindBy(name = "to_date")
	private WebElement selectToDate;

	@FindBy(xpath = "//span[@aria-labelledby='select2-order_status-container']")
	private WebElement selectStatus;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchStatus;

	@FindBy(xpath = "//li[contains(text(), 'Open PO’s')]")
	private WebElement selectStatusValue;

	@FindBy(id = "select2-select_vendor-container")
	private WebElement selectVendor;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchVendor;

	@FindBy(id = "submit_filter")
	private WebElement clickSubmitBtn;

	@FindBy(xpath = "//a[contains(text(), 'AP Aging')]")
	private WebElement clickAPaging;

	public AccountingAccountPayablePage(WebDriver driver) {

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

	public void accountingDashboard() {

		elementClickableTime(clickAccountingDashboard);
		clickAccountingDashboard.click();

		elementClickableTime(clickAccountPayable);
		clickAccountPayable.click();
	}

	public void selectDate(String fromDate, String toDate) {

		Time_wait(selectFromDate);
		selectFromDate.click();

		selectFromDate.clear();

		selectFromDate.sendKeys(fromDate);
		selectFromDate.sendKeys(Keys.ENTER);

		elementClickableTime(selectToDate);
		selectToDate.click();

		selectToDate.clear();

		selectToDate.sendKeys(toDate);
		selectToDate.sendKeys(Keys.ENTER);

	}

	public void selectPOstatus(String PO) {

		elementClickableTime(selectStatus);
		selectStatus.click();

		elementClickableTime(searchStatus);
		searchStatus.click();

		Time_wait(searchStatus);
		searchStatus.sendKeys(PO);

		searchStatus.sendKeys(Keys.ENTER);

	}

	public void selectVendors(String Vendor) {

		elementClickableTime(selectVendor);
		selectVendor.click();

		elementClickableTime(searchVendor);
		searchVendor.click();

		Time_wait(searchVendor);
		searchVendor.sendKeys(Vendor);

		searchVendor.sendKeys(Keys.ENTER);

	}

	public void clickSubmitButton() {

		elementClickableTime(clickSubmitBtn);
		clickSubmitBtn.click();

	}

}
