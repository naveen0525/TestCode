package objectsMethods;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[@class='btn btn-primary float-right btn-login'])[2]")
	private WebElement clickOnRegistrationButton;

	@FindBy(name = "firstname")
	private WebElement enterFirstName;

	@FindBy(name = "lastname")
	private WebElement enterLastName;

	@FindBy(name = "email")
	private WebElement enterEmail;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "password")
	private WebElement enterPassword;

	@FindBy(name = "cpass")
	private WebElement confirmPassword;

	@FindBy(name = "phone")
	private WebElement enterPhoneNumber;

	@FindBy(name = "search_provider")
	private WebElement enterProviderName;

	@FindBy(xpath = "//p[contains(text(), 'Provider1')]")
	private WebElement suggestedName;

	@FindBy(id = "register")
	private WebElement clickOnSubmitBtn;

	public void Time_wait(WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500));
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementClickableTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickRegistrationButton() {

//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(clickOnRegistrationButton);
		clickOnRegistrationButton.sendKeys(Keys.RETURN);
	}

	public void registrationDetails(String Fname, String Lname, String email, String company, String password,
			String cpassword, String phone, String provider) throws InterruptedException {

		Time_wait(enterFirstName);
		enterFirstName.sendKeys(Fname);
		this.enterLastName.sendKeys(Lname);
		this.enterEmail.sendKeys(email);
		this.companyName.sendKeys(company);
		this.enterPassword.sendKeys(password);
		confirmPassword.sendKeys(cpassword);
		this.enterPhoneNumber.sendKeys(phone);
		Time_wait(enterProviderName);
		enterProviderName.sendKeys(provider);
		Thread.sleep(2000);
		Time_wait(suggestedName);
		suggestedName.click();
	}

	public void clickSubmitButton() {

		Time_wait(clickOnSubmitBtn);
		clickOnSubmitBtn.click();
	}

}
