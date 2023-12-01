package objectsMethods;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPayablePageApAging {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/management/accounting/accounting-sub-menus/']")
	private WebElement clickAccountingDashboard;

	@FindBy(xpath = "//a[@href='/management/accounting/get-account-payable-orders/']")
	private WebElement clickAccountPayable;

	@FindBy(xpath = "//a[contains(text(), 'AP Aging')]")
	private WebElement clickAPaging;

	public AccountPayablePageApAging(WebDriver driver) {

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

	public void apAging() {

		elementClickableTime(clickAPaging);
		clickAPaging.click();
	}

}
