package objectsMethods;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	@FindBy(name = "username")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login_button;

	public LoginPage(WebDriver driver) {
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

	public void enterCredentials(String superAdminEmail, String superAdminPassword) throws InterruptedException {
		Time_wait(email);
		email.sendKeys(superAdminEmail);

		Time_wait(password);
		password.sendKeys(superAdminPassword);

	}

	public void clickLogin() {

		Time_wait(login_button);
		login_button.click();
	}

}
