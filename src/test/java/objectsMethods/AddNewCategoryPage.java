package objectsMethods;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCategoryPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/management/product/link/']")
	private WebElement inventory_link;

	@FindBy(xpath = "//a[@href='/management/category/']")
	private WebElement clickCategoryTab;

	@FindBy(xpath = "//a[@href='/management/category/create']")
	private WebElement addNewCategoryBtn;

	@FindBy(xpath = "//input[@class='minimal textinput textInput form-control']")
	private WebElement categoryNameField;

	@FindBy(xpath = "//textarea[@class='minimal textarea form-control']")
	private WebElement descriptionField;

	@FindBy(xpath = "//input[@class='minimal form-control']")
	private WebElement priorityField;

	@FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
	private WebElement selectUOM_dropDown;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
	private WebElement searchUOM;

	@FindBy(xpath = "//input[@placeholder='Select Size']")
	private WebElement selectSize_dropDown;

	@FindBy(xpath = "//input[@class='btn btn-primary btn custom_button category-save']")
	private WebElement clickSaveBtn;

	public AddNewCategoryPage(WebDriver driver) {
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

	public void clickInventoryDashBoard() {

		Time_wait(inventory_link);
		inventory_link.click();

	}

	public void clickOnCategoryTab() {

		elementClickableTime(clickCategoryTab);
		clickCategoryTab.click();
	}

	public void clickOnaddNewCatoryButton() {

		addNewCategoryBtn.click();

	}

	public void addNewCategory_action(String categoryName, String categoryDescription, String categoryPriority,
			String categoryUOM, String categorySize) throws InterruptedException {

		this.Time_wait(categoryNameField);
		categoryNameField.sendKeys(categoryName);

		descriptionField.sendKeys(categoryDescription);
		TimeUnit.MILLISECONDS.sleep(500);

		priorityField.sendKeys(categoryPriority);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		selectUOM_dropDown.sendKeys(Keys.RETURN);

		this.Time_wait(searchUOM);
		searchUOM.sendKeys(categoryUOM);
		searchUOM.sendKeys(Keys.ENTER);
		TimeUnit.MILLISECONDS.sleep(500);

		this.elementClickableTime(selectSize_dropDown);
		selectSize_dropDown.sendKeys(Keys.ENTER);

		selectSize_dropDown.sendKeys(categorySize);
		selectSize_dropDown.sendKeys(Keys.ENTER);

	}

	public void saveButton() {

		Time_wait(clickSaveBtn);
		clickSaveBtn.click();
	}

}
