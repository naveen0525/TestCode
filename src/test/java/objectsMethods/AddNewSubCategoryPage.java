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

public class AddNewSubCategoryPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/management/product/link/']")
	private WebElement inventory_link;

	@FindBy(xpath = "//a[@href='/management/category/']")
	private WebElement clickCategoryTab;

	@FindBy(xpath = "//*[@id='wrap']/div[1]/div/div[1]/div[4]/a[4]")
	private WebElement selectCategory;

	@FindBy(xpath = "/html/body/div[2]/div[1]/section[3]/div/div/div/div[1]/a[1]")
	private WebElement clickAddNewSubCategoryBtn;

	@FindBy(xpath = "//input[@class='minimal textinput textInput form-control']")
	private WebElement subCategoryNameField;

	@FindBy(xpath = "//textarea[@class='minimal textarea form-control']")
	private WebElement subCategoryDescription;

	@FindBy(xpath = "//input[@class='minimal form-control']")
	private WebElement subCategoryPriority;

	@FindBy(id = "submit-id-save")
	private WebElement clickSaveBtn;

	public AddNewSubCategoryPage(WebDriver driver) {
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void clickInventoryModule() {

		Time_wait(inventory_link);
		inventory_link.sendKeys(Keys.RETURN);

	}

	public void categoryTab() {

		Time_wait(clickCategoryTab);
		clickCategoryTab.click();
	}

	public void selectCategoryFromList() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		selectCategory.sendKeys(Keys.RETURN);

		Time_wait(clickAddNewSubCategoryBtn);
		clickAddNewSubCategoryBtn.click();
	}

	public void addNewSubCategory_action(String subCategoryName, String subCatDescription, String subCatPriority)
			throws InterruptedException {

		Time_wait(subCategoryNameField);
		subCategoryNameField.sendKeys(subCategoryName);
		TimeUnit.MILLISECONDS.sleep(500);

		Time_wait(subCategoryDescription);
		subCategoryDescription.sendKeys(subCatDescription);
		TimeUnit.MILLISECONDS.sleep(500);

		subCategoryPriority.sendKeys(subCatPriority);
	}

	public void saveButton() {

		Time_wait(clickSaveBtn);
		clickSaveBtn.click();
	}
}
