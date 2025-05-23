package Logic.BrokerManagementSystem;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Advances {

	WebDriver driver;

	public Advances(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/nav/ul/li[7]/a")
	WebElement advancesLink;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/div/button[1]")
	WebElement addNewBtn;

	@FindBy(xpath = "//*[@id=\":rc:\"]")
	WebElement advancesTitle;

	@FindBy(xpath = "//*[@id=\":rd:\"]")
	WebElement advancesDescription;

	@FindBy(xpath = "//*[@id=\":re:\"]")
	WebElement advancesAmount;

	@FindBy(xpath = "//div[@role='combobox'][text()='Given']")
	WebElement typeDropdown;

	@FindBy(xpath = "//li[text()='Given']")
	WebElement selectgiven;

//           @FindBy(xpath = "//li[normalize-space()='Received']")
//           WebElement receivedOption;

//           @FindBy(xpath = "//div[label[contains(text(),'Counterparty Type')]]//div[contains(@class,'MuiSelect-root')]")
//           WebElement counterpartyTypeDropdown;

//           @FindBy(xpath = "//input[@type='text' and contains(@class, 'MuiInputBase-input')]")
//           WebElement counterpartyInput;

	@FindBy(xpath = "//button[@type='button'][@title='Open']")
	WebElement companytype;

	@FindBy(xpath = "//button[text()='Create'][@type='submit']")
	WebElement doneExpenseBtn;

	public void advancesDetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Handle overlay if it exists
		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		wait.until(ExpectedConditions.elementToBeClickable(advancesLink));
		advancesLink.click();

		wait.until(ExpectedConditions.elementToBeClickable(addNewBtn));
		addNewBtn.click();

		advancesTitle.sendKeys("Login Page");
		advancesDescription.sendKeys("Create login page with usreName , userPassword , loginButton");
		advancesAmount.sendKeys("10000");

		wait.until(ExpectedConditions.elementToBeClickable(typeDropdown));
		typeDropdown.click();

		WebElement option = wait.until(ExpectedConditions.visibilityOf(selectgiven));
		option.click();

//        	   wait.until(ExpectedConditions.elementToBeClickable(counterpartyTypeDropdown));
//        	   counterpartyTypeDropdown.click();
//        	   
//        	   WebElement broker = wait.until(ExpectedConditions.visibilityOfElementLocated(brokerOption));
//               broker.click();
//               
		wait.until(ExpectedConditions.elementToBeClickable(companytype));
		companytype.click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(doneExpenseBtn));
		doneExpenseBtn.click();
	}
}
