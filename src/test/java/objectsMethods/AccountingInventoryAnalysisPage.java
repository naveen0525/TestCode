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

public class AccountingInventoryAnalysisPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/management/accounting/accounting-sub-menus/']")
	private WebElement clickAccountingDashboard;

	@FindBy(xpath = "//p[contains(text(), 'Inventory Analysis')]")
	private WebElement clickInventoryAnalysisTab;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement enterPassword;

	@FindBy(xpath = "//button[contains(text(), 'Verify')]")
	private WebElement clickVerifyButton;

	@FindBy(name = "from_date")
	private WebElement selectFromDate;

	@FindBy(name = "to_date")
	private WebElement selectToDate;

	@FindBy(id = "filter_inventory")
	private WebElement clickSubmitBtn;

	public AccountingInventoryAnalysisPage(WebDriver driver) {

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

		elementClickableTime(clickInventoryAnalysisTab);
		clickInventoryAnalysisTab.click();

	}

	public void popUpWindow(String Password) throws InterruptedException {

		Time_wait(enterPassword);
		enterPassword.click();

		Time_wait(enterPassword);
		enterPassword.sendKeys(Password);

		elementClickableTime(clickVerifyButton);
		clickVerifyButton.click();
		Thread.sleep(3000);
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

	public void clickSubmitButton() throws InterruptedException {

		elementClickableTime(clickSubmitBtn);
		clickSubmitBtn.click();
		Thread.sleep(3000);

	}

}
