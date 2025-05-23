package Logic.BrokerManagementSystem;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankAccounts {

	WebDriver driver;

	public BankAccounts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/nav/ul/li[4]/a")
	WebElement bankAccountsClick;

	@FindBy(xpath = "//button[text()='Add Bank Account']")
	WebElement addBankAccountBtn;

	@FindBy(id = "accountHolderName")
	WebElement accHolderName;

	@FindBy(id = "accountHolderPan")
	WebElement accHolderPan;

	@FindBy(id = "accountHolderAadhar")
	WebElement accHolderAadhar;

	@FindBy(id = "accountNumber")
	WebElement accNumber;

	@FindBy(id = "ifscCode")
	WebElement accifscCode;

	@FindBy(id = "bankName")
	WebElement bankName;

	@FindBy(id = "branchName")
	WebElement branchName;

	@FindBy(id = "accountType")
	WebElement accountType;

	@FindBy(id = "isActive")
	WebElement isActiveClick;

	@FindBy(xpath = "//button[text()='Add Account']")
	WebElement addAccountClick;

	public void bankAccounts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Handle overlay if it exists
		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		wait.until(ExpectedConditions.elementToBeClickable(bankAccountsClick));
		bankAccountsClick.click();

		wait.until(ExpectedConditions.elementToBeClickable(addBankAccountBtn));
		addBankAccountBtn.click();

		wait.until(ExpectedConditions.visibilityOf(accHolderName));

		accHolderName.sendKeys("Shubham Singh");
		accHolderPan.sendKeys("ABCDE0348R");
		accHolderAadhar.sendKeys("837383838383");
		accNumber.sendKeys("454355454544");
		accifscCode.sendKeys("SBIN0084453");
		bankName.sendKeys("SBIN");
		branchName.sendKeys("NOIDA");

		Select s = new Select(accountType);
		s.selectByValue("savings");

		isActiveClick.click();
		addAccountClick.click();
	}
}
