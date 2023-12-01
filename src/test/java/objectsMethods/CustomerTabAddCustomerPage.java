package objectsMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerTabAddCustomerPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='/customer/link/']")
	private WebElement clickCustomer_Link;

	@FindBy(xpath = "//a[@href='/customer/list/']")
	private WebElement customerList;

	@FindBy(xpath = "//a[@href='/customer/create-customer/']")
	private WebElement addNewBtn;

	@FindBy(name = "first_name")
	private WebElement EnterFirstName;

	@FindBy(name = "last_name")
	private WebElement EnterLasteName;

	@FindBy(name = "email")
	private WebElement EnterEmail;

	@FindBy(name = "phone")
	private WebElement EnterPhone;

	@FindBy(name = "company")
	private WebElement EnterCompany;

	@FindBy(name = "sales_rep")
	private WebElement EnterSaleRepresentative;

	@FindBy(name = "address_1")
	private WebElement EnterAddress;

	@FindBy(xpath = "//span[@aria-labelledby='select2-id_country_test-container']")
	private WebElement countryDropDown;

	@FindBy(xpath = "//input[@aria-controls='select2-id_country_test-results']")
	private WebElement countryDropDown_Search;

	@FindBy(xpath = "//span[@aria-labelledby='select2-id_state-container']")
	private WebElement stateDropDown;

	@FindBy(xpath = "//input[@aria-controls='select2-id_state-results']")
	private WebElement stateDropDown_Search;

	@FindBy(name = "city")
	private WebElement cityField;

//	@FindBy(name = "zipcode")
//	private WebElement zipcodeField;

	@FindBy(name = "address_2")
	private WebElement locationNameField;

	@FindBy(name = "street")
	private WebElement streetField;

	@FindBy(id = "same_as_delivery")
	private WebElement sameAsDeliveryCheckBox;

	@FindBy(id = "submit-id-save")
	private WebElement submitBtn;

	public CustomerTabAddCustomerPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void Time_wait(WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500));
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementClickableTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickCustomerDashboardLink() {

		Time_wait(clickCustomer_Link);
		clickCustomer_Link.click();
	}

	public void clickCustomerListTab() {

		Time_wait(customerList);
		customerList.click();
	}

	public void clickAddNewButton() {

		elementClickableTime(addNewBtn);
		addNewBtn.click();
	}

	public void addCustomerAction(String enterFName, String enterLName, String enterEmail, String enterPhone,
			String enterEnterCompany, String SaleRepresentative, String address, String country, String state,
			String city, String locationName, String streetName) throws InterruptedException {

		Time_wait(EnterFirstName);
		EnterFirstName.sendKeys(enterFName);

		Time_wait(EnterLasteName);
		EnterLasteName.sendKeys(enterLName);

		Time_wait(EnterEmail);
		EnterEmail.sendKeys(enterEmail);

		Time_wait(EnterPhone);
		EnterPhone.sendKeys(enterPhone);

		Time_wait(EnterCompany);
		EnterCompany.sendKeys(enterEnterCompany);

		Time_wait(EnterSaleRepresentative);
		EnterSaleRepresentative.sendKeys(SaleRepresentative);

		Time_wait(EnterAddress);
		EnterAddress.sendKeys(address);

		elementClickableTime(countryDropDown);
		countryDropDown.click();

		Time_wait(countryDropDown_Search);
		countryDropDown_Search.sendKeys(country);

		countryDropDown_Search.sendKeys(Keys.ENTER);
		TimeUnit.SECONDS.sleep(2);

		elementClickableTime(stateDropDown);
		stateDropDown.click();

		Time_wait(stateDropDown_Search);
		stateDropDown_Search.sendKeys(state);

		stateDropDown_Search.sendKeys(Keys.ENTER);

		Time_wait(cityField);
		cityField.sendKeys(city);

//		Time_wait(zipcodeField);
//		zipcodeField.sendKeys(zipCode);

		Time_wait(locationNameField);
		locationNameField.sendKeys(locationName);

		Time_wait(streetField);
		streetField.sendKeys(streetName);

		elementClickableTime(sameAsDeliveryCheckBox);
		sameAsDeliveryCheckBox.click();

	}

	public void clickSubmitButton() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Time_wait(submitBtn);
		submitBtn.click();

	}

}
