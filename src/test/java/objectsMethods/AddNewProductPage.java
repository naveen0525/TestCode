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

public class AddNewProductPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/management/product/link/']")
	private WebElement inventory_Link;

	@FindBy(xpath = "//a[@href='/management/category/']")
	private WebElement inventory_CategoryLink;

	@FindBy(xpath = "(//i[@title=' Product List'])[1]")
	private WebElement inventory_selectCategory;

	@FindBy(xpath = "//a[contains(text(), 'Add New Product')]")
	private WebElement inventory_clickAddNewProductBtn;

	@FindBy(xpath = "//input[@class='textinput textInput form-control changed_fields product_name']")
	private WebElement inventory_enterNewProductName;

	@FindBy(xpath = "//textarea[@class='minimal textarea form-control changed_fields']")
	private WebElement inventory_enterNewProductDescription;

	@FindBy(xpath = "//input[@class='minimal textarea form-control changed_fields']")
	private WebElement inventory_enterNewProductPriority;

	@FindBy(name = "unit_weight")
	private WebElement inventory_enterNewProductUnitWeight;

	@FindBy(id = "change_tab_button")
	private WebElement inventory_clickNextBtn;

	@FindBy(xpath = "(//input[@class='minimal numberinput form-control positive changed_fields'])[1]")
	private WebElement inventory_enterNewProductCurrentInv;

	@FindBy(name = "current_inventory_cost_per_unit")
	private WebElement inventory_enterCostPerUnit;

	@FindBy(xpath = "(//input[@class='minimal form-control positive changed_fields'])[3]")
	private WebElement inventory_enterNewProductTotalMarkUp;

	@FindBy(xpath = "(//input[@class='minimal numberinput form-control positive changed_fields'])[3]")
	private WebElement inventory_MinInventory;

	@FindBy(xpath = "(//input[@class='minimal numberinput form-control positive changed_fields'])[4]")
	private WebElement inventory_MaxInventory;

	@FindBy(xpath = "//input[@name='order_when_inventory_at']")
	private WebElement inventory_WhenInventoryAt;

	@FindBy(name = "product_base_price_percent[]")
	private WebElement inventory_ProductPrice;

	@FindBy(id = "change_tab_button")
	private WebElement inventory_NextTab;

	@FindBy(name = "vendor_price[]")
	private WebElement inventory_NewProductVendorPrice;

	@FindBy(xpath = "//button[@class='btn btn-success save-button product_save_next_button']")
	private WebElement inventory_SaveButton;

	public AddNewProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Time_wait(WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(500));
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementClickableTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickInventoryLinkDashboard() {
		Time_wait(inventory_Link);
		inventory_Link.click();

	}

	public void clickCategoryLink() {

		Time_wait(inventory_CategoryLink);
		inventory_CategoryLink.click();

	}

	public void clickSelectCategory() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		inventory_selectCategory.click();

	}

	public void clickAddNewProductButton() {

		Time_wait(inventory_clickAddNewProductBtn);
		inventory_clickAddNewProductBtn.sendKeys(Keys.RETURN);
	}

	public void generalInfo_action(String ProductName, String ProductDescription, String ProductPriority,
			String ProductUnitWeight) throws Exception {

		Time_wait(inventory_enterNewProductName);
		inventory_enterNewProductName.sendKeys(ProductName);
		TimeUnit.MILLISECONDS.sleep(500);

		Time_wait(inventory_enterNewProductDescription);
		inventory_enterNewProductDescription.sendKeys(ProductDescription);
		TimeUnit.MILLISECONDS.sleep(500);

		Time_wait(inventory_enterNewProductPriority);
		inventory_enterNewProductPriority.sendKeys(ProductPriority);

		Time_wait(inventory_enterNewProductUnitWeight);
		inventory_enterNewProductUnitWeight.sendKeys(ProductUnitWeight);
		TimeUnit.MILLISECONDS.sleep(500);

	}

	public void clickNextButtonOne() throws InterruptedException {

		Time_wait(inventory_clickNextBtn);
		inventory_clickNextBtn.click();
		TimeUnit.MILLISECONDS.sleep(800);

	}

	public void inventoryInfo_action(String CurrentInventory, String CostPerUnit, String TotalMarkUp,
			String MinInventory, String MaxInventory, String WhenInventoryAt, String ProductPrice, String VendorPrice)
			throws InterruptedException {

		Time_wait(inventory_enterNewProductCurrentInv);
		inventory_enterNewProductCurrentInv.clear();
		TimeUnit.MILLISECONDS.sleep(500);

		Time_wait(inventory_enterNewProductCurrentInv);
		inventory_enterNewProductCurrentInv.sendKeys(CurrentInventory);

		Time_wait(inventory_enterCostPerUnit);
		inventory_enterCostPerUnit.clear();
		TimeUnit.MILLISECONDS.sleep(500);

		Time_wait(inventory_enterCostPerUnit);
		inventory_enterCostPerUnit.sendKeys(CostPerUnit);

		Time_wait(inventory_enterNewProductTotalMarkUp);
		inventory_enterNewProductTotalMarkUp.clear();
		TimeUnit.MILLISECONDS.sleep(500);

		Time_wait(inventory_enterNewProductTotalMarkUp);
		inventory_enterNewProductTotalMarkUp.sendKeys(TotalMarkUp);

		inventory_MinInventory.clear();
		Time_wait(inventory_MinInventory);
		inventory_MinInventory.sendKeys(MinInventory);
		TimeUnit.MILLISECONDS.sleep(500);

		inventory_MaxInventory.clear();
		Time_wait(inventory_MaxInventory);
		inventory_MaxInventory.sendKeys(MaxInventory);

		inventory_WhenInventoryAt.clear();
		Time_wait(inventory_WhenInventoryAt);
		inventory_WhenInventoryAt.sendKeys(WhenInventoryAt);
		TimeUnit.MILLISECONDS.sleep(500);

		inventory_ProductPrice.clear();
		Time_wait(inventory_ProductPrice);
		inventory_ProductPrice.sendKeys(ProductPrice);

		Time_wait(inventory_NextTab);
		inventory_NextTab.click();
		TimeUnit.MILLISECONDS.sleep(1000);

		Time_wait(inventory_NewProductVendorPrice);
		inventory_NewProductVendorPrice.click();
		TimeUnit.MILLISECONDS.sleep(500);

		Time_wait(inventory_NewProductVendorPrice);
		inventory_NewProductVendorPrice.sendKeys(VendorPrice);
		TimeUnit.MILLISECONDS.sleep(500);

	}

	public void saveButton() throws InterruptedException {

		inventory_clickNextBtn.click();

	}

}
