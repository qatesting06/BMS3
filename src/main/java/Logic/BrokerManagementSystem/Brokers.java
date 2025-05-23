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

public class Brokers {

	WebDriver driver;

	public Brokers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.nav-link[href='/brokers']")
	WebElement brokersLink;

	@FindBy(xpath = "//button[text()='Add Broker']")
	WebElement addBrokerBtn;

	@FindBy(id = "name")
	WebElement brokerName;

	@FindBy(id = "email")
	WebElement brokerEmail;

	@FindBy(id = "phone")
	WebElement brokerPhone;

	@FindBy(id = "company")
	WebElement companyDropdown;

	@FindBy(id = "gstNumber")
	WebElement brokerGstNumber;

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement removeBankAccount;

	@FindBy(id = "panNumber")
	WebElement brokerPanNumber;

	@FindBy(name = "address.street")
	WebElement brokerAddress;

	@FindBy(name = "address.city")
	WebElement brokerCity;

	@FindBy(name = "address.state")
	WebElement brokerState;

	@FindBy(name = "address.country")
	WebElement brokerCountry;

	@FindBy(name = "address.pincode")
	WebElement brokerPincode;

	@FindBy(id = "status")
	WebElement brokerStatus;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/main/div/div[3]/div/form/div[4]/button[2]")
	WebElement submitBrokerBtn;

	public void addBrokerDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		wait.until(ExpectedConditions.elementToBeClickable(brokersLink));
		brokersLink.click();

		wait.until(ExpectedConditions.elementToBeClickable(addBrokerBtn));
		addBrokerBtn.click();

		brokerName.sendKeys("Shumit");
		brokerEmail.sendKeys("Shumit@gmail.com");
		brokerPhone.sendKeys("9883453948");

		Select companySelect = new Select(companyDropdown);
		companySelect.selectByVisibleText("Computer Interprise pvt ltd");

		brokerGstNumber.sendKeys("26UBPBL5283A8Z1");
		removeBankAccount.click();
		brokerPanNumber.sendKeys("ABCDE9474R");
		brokerAddress.sendKeys("New Ashok Nagar");
		brokerCity.sendKeys("Delhi");
		brokerState.sendKeys("Delhi");
		brokerCountry.sendKeys("India");
		brokerPincode.sendKeys("110096");

		Select statusSelect = new Select(brokerStatus);
		statusSelect.selectByValue("active");

		wait.until(ExpectedConditions.elementToBeClickable(submitBrokerBtn));
		submitBrokerBtn.click();
	}
}
