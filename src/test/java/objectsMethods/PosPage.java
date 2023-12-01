package objectsMethods;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PosPage {

	WebDriver driver;

	@FindBy(id = "pos_order")
	WebElement pos_button;

	@FindBy(id = "search-customer")
	WebElement searchbar;

	@FindBy(xpath = "//div[contains(@id,'customer-suggestion')]/div/p | //div[contains(@id,'customer-suggestion')]/div/a")
	WebElement searchName;

	@FindBy(xpath = "//div[@class='customer-suggestion']/a")
	WebElement customerSugession;

	// search product elements

	@FindBy(id = "search-box")
	WebElement searchBox;

	@FindBy(xpath = "//a[@class='view-product-details']")
	WebElement productOption;

	@FindBy(xpath = "//a[contains(@class,'btn buy-now-btn pos-buy-now')]")
	WebElement buyNow_btn;

	@FindBy(xpath = "//a[contains(text(),'Continue Checkout')]")
	WebElement continue_checkout_btn;

	// order summary
	@FindBy(xpath = "(//a[text()='Continue'])[1]")
	WebElement order_summary_continue;

	// delivery address

	@FindBy(xpath = "//input[@name='default_status']")
	WebElement addressRadioBtn;

	@FindBy(xpath = "//div[@class='address-form-section']/div[2]/a")
	WebElement delivery_add_continue;

	@FindBy(xpath = "//div[@id='del_address']//div/div/div/label")
	List<WebElement> available_add;

	// Pickup address
	@FindBy(xpath = "//*[@id='collapseFour']/div/a")
	WebElement pickup_continue;

	// Additional info /PO number

	@FindBy(xpath = "//*[@id='collapseFour']/div/a")
	WebElement po_continue;

	// Communication preferences
	@FindBy(xpath = "//*[@id='accordion']/div[6]/a/div/h5")
	WebElement communicationFrame;

	@FindBy(xpath = "//*[@id='collapseFive']/div/div[3]/a")
	WebElement communication_continue;

	// Payment options
	@FindBy(id = "continue-pay")
	WebElement continue_pay;

	@FindBy(xpath = "//*[@id='id_payment']")
	WebElement payment_btn;

	@FindBy(id = "tokenFrame")
	WebElement token_frame;

	@FindBy(id = "ccnumfield")
	WebElement card_no;

	@FindBy(id = "ccexpirymonth")
	WebElement exp_month_field;

	@FindBy(id = "ccexpiryyear")
	WebElement exp_year_field;

	@FindBy(id = "cccvvfield")
	WebElement cvv_field;

	@FindBy(id = "namefield")
	WebElement cardholder_name_field;

	@FindBy(xpath = "//button[text()='Pay']")
	WebElement pay_btn;

	@FindBy(id = "id_swipe_card")
	WebElement swipe_card_btn;

	@FindBy(id = "swipe_card")
	WebElement select_card;

	@FindBy(id = "pos_tnx_no")
	WebElement pos_tnx_no_field;

	@FindBy(xpath = "//*[@id='swipe-card-modal']/div/div/div[3]/button[1]")
	WebElement swipecard_pay_btn;

	@FindBy(id = "pos_cancel_payment")
	WebElement cancle_payment_btn;

	@FindBy(xpath = "//*[@id='credit_card_option']")
	WebElement creditcard_radio_btn;

	@FindBy(xpath = "//label[contains(text(), 'Cash')]")
	WebElement cash_radio_btn;

	@FindBy(xpath = "//label[contains(text(),'Cheque')]")
	WebElement cheque_radio_btn;

	@FindBy(xpath = "//label[contains(text(), 'EFT Transfer')]")
	WebElement EFT_radio_btn;

	@FindBy(xpath = "//div[@id='myCreditCardModal']/div/div/div[3]/button[1]")
	WebElement other_pay_btn;

	public PosPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// implement methods

	public void Time_wait(WebElement element) {
		FluentWait<WebDriver> fluent = new FluentWait<>(driver);
		fluent.withTimeout(Duration.ofSeconds(40));
		fluent.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);

		fluent.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void elementClickableTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickPOS() throws InterruptedException {
		Time_wait(pos_button);
		pos_button.click();
		Thread.sleep(800);
	}

	public void searchCustomer(String FirstName) throws InterruptedException {
		Time_wait(searchbar);
		searchbar.click();

		Time_wait(searchbar);
		searchbar.sendKeys(FirstName);
		Thread.sleep(500);

		Time_wait(customerSugession);
		customerSugession.sendKeys(Keys.RETURN);

	}

	public void searchProduct(String product) throws InterruptedException {

		elementClickableTime(searchBox);
		searchBox.click();

		Time_wait(searchBox);
		searchBox.sendKeys(product);
		Thread.sleep(800);

		elementClickableTime(productOption);
		productOption.click();

	}

	public void buyNow() {

		elementClickableTime(buyNow_btn);
		buyNow_btn.sendKeys(Keys.RETURN);

	}

	public void continueCheckOut() {
		elementClickableTime(continue_checkout_btn);
		continue_checkout_btn.sendKeys(Keys.RETURN);
	}

	public void orderSummary() {
		Time_wait(order_summary_continue);
		order_summary_continue.sendKeys(Keys.RETURN);
	}

	public void deliveryAddPresent() throws InterruptedException {

		Time_wait(addressRadioBtn);
		addressRadioBtn.click();

		Time_wait(delivery_add_continue);
		delivery_add_continue.click();
		Thread.sleep(1000);

	}

	public void continuePickup() {

		Time_wait(pickup_continue);
		pickup_continue.sendKeys(Keys.RETURN);

	}

	public void continueCommunication() {

		Time_wait(communication_continue);
		communication_continue.sendKeys(Keys.RETURN);
	}

	public void creditcardRadioBtn() {
		Time_wait(creditcard_radio_btn);
		creditcard_radio_btn.click();

		Time_wait(continue_pay);
		continue_pay.click();
	}

	public void creditCard(String cardno, String expmonth, String expyear, String cvv, String cardholdername)
			throws InterruptedException {

		elementClickableTime(payment_btn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", payment_btn);

		Time_wait(token_frame);
		driver.switchTo().frame(token_frame);

		elementClickableTime(card_no);
		card_no.click();

		card_no.sendKeys(cardno);

		Select month = new Select(exp_month_field);
		month.selectByVisibleText(expmonth);

		Select year = new Select(exp_year_field);
		year.selectByVisibleText(expyear);

		Time_wait(cvv_field);
		cvv_field.sendKeys(cvv);
		driver.switchTo().defaultContent();

		Time_wait(cardholder_name_field);
		cardholder_name_field.sendKeys(cardholdername);
		Thread.sleep(4000);

		Time_wait(pay_btn);
		pay_btn.click();
		Thread.sleep(5000);

	}

}
