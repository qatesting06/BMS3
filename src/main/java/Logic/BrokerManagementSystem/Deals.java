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

public class Deals {

	WebDriver driver;

	public Deals(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.nav-link[href='/tasks']")
	WebElement dealsLink;

	@FindBy(xpath = "//button[normalize-space()='Add Deal']")
	WebElement clickDeals;

	@FindBy(xpath = "/html/body/div/div/div[3]/main/div/div[3]/div/form/div[1]/div/div[1]/input")
	WebElement dealsTittle;

	@FindBy(id = "description")
	WebElement dealsDescription;

	@FindBy(id = "taskDate")
	WebElement dealsDate;

	@FindBy(id = "clientCompany")
	WebElement clientCompanyDropdown;

	@FindBy(id = "providerCompany")
	WebElement providerCompanyDropdown;

	@FindBy(id = "helperBroker.broker")
	WebElement helperBrokerDropdown;

	@FindBy(id = "helperBroker.commission")
	WebElement helperBrokerCommission;

	@FindBy(id = "helperBroker.status")
	WebElement brokerStatus;

	@FindBy(id = "helperBroker.paymentDate")
	WebElement helperBrokerPaymentDate;

	@FindBy(id = "payment.amount")
	WebElement paymentamount;

	@FindBy(xpath = "//button[text()='Add Task']")
	WebElement submitTaskBtn;

	public void deals() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		wait.until(ExpectedConditions.elementToBeClickable(dealsLink));
		dealsLink.click();
		wait.until(ExpectedConditions.elementToBeClickable(clickDeals));
		clickDeals.click();

		wait.until(ExpectedConditions.visibilityOf(dealsTittle));
		dealsTittle.click();

		dealsTittle.sendKeys("Dashboard");
		dealsDescription.sendKeys("Create Dashboard Functionality");
		dealsDate.sendKeys("02/05/2025");

		Select clintCompanySelect = new Select(clientCompanyDropdown);
		clintCompanySelect.selectByVisibleText("Computer Interprise pvt ltd");

		Select providerCompanySelect = new Select(providerCompanyDropdown);
		providerCompanySelect.selectByVisibleText("Shaswat Interprise pvt ltd");

		Select helperBrokerSelect = new Select(helperBrokerDropdown);
		helperBrokerSelect.selectByVisibleText("Sachin");

		helperBrokerCommission.sendKeys("5");

		Select brokerStatusSelect = new Select(brokerStatus);
		brokerStatusSelect.selectByVisibleText("Paid");

		helperBrokerPaymentDate.sendKeys("02/05/2025");
		paymentamount.sendKeys("10000");

		wait.until(ExpectedConditions.elementToBeClickable(submitTaskBtn));
		submitTaskBtn.click();

	}

}
