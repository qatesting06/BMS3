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

public class Companies {

	WebDriver driver;

	public Companies(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Navigation Links
	@FindBy(xpath = "//*[@id='root']/div/div[2]/nav/ul/li[2]/div/a")
	WebElement companiesLink;

	@FindBy(xpath = "//*[@id='root']/div/div[3]/main/div/div[1]/button")
	WebElement addCompany;

	// ---------------- Basic Information ----------------
	@FindBy(id = "name")
	WebElement companyName;

	@FindBy(id = "type")
	WebElement companyType;

	@FindBy(id = "status")
	WebElement companyStatus;

	// ---------------- Contact Person ----------------
	@FindBy(id = "contactPerson.name")
	WebElement contactName;

	@FindBy(id = "contactPerson.email")
	WebElement contactEmail;

	@FindBy(id = "contactPerson.phone")
	WebElement contactPhone;

	@FindBy(id = "contactPerson.designation")
	WebElement contactDesignation;

	@FindBy(id = "contactPerson.alternatePhone")
	WebElement contactAltPhone;

	// ---------------- Business Details ----------------
	@FindBy(id = "businessDetails.gstNumber")
	WebElement gstNumber;

	@FindBy(id = "businessDetails.panNumber")
	WebElement panNumber;

	@FindBy(id = "businessDetails.cinNumber")
	WebElement cinNumber;

	@FindBy(id = "businessDetails.tdsNumber")
	WebElement tdsNumber;

	@FindBy(id = "businessDetails.registrationDate")
	WebElement registrationDate;

	// ---------------- Legal Details ----------------
	@FindBy(id = "legalDetails.registeredName")
	WebElement legalName;

	@FindBy(id = "legalDetails.registeredOffice.address")
	WebElement legalAddress;

	@FindBy(id = "legalDetails.registeredOffice.city")
	WebElement legalCity;

	@FindBy(id = "legalDetails.registeredOffice.state")
	WebElement legalState;

	@FindBy(id = "legalDetails.registeredOffice.country")
	WebElement legalCountry;

	@FindBy(id = "legalDetails.registeredOffice.pincode")
	WebElement legalPincode;

	// ---------------- Company Address ----------------
	@FindBy(id = "address.street")
	WebElement addressStreet;

	@FindBy(id = "address.city")
	WebElement addressCity;

	@FindBy(id = "address.state")
	WebElement addressState;

	@FindBy(id = "address.country")
	WebElement addressCountry;

	@FindBy(id = "address.pincode")
	WebElement addressPincode;

	@FindBy(id = "address.landmark")
	WebElement addressLandmark;

	// ---------------- Bank Details ----------------
	@FindBy(xpath = "//*[@id='root']/div/div[3]/main/div/div[3]/div/form/div[6]/div[2]/div/div/button")
	WebElement bankRemoveBtn;

	// ---------------- Submit ----------------
	@FindBy(xpath = "//*[@id='root']/div/div[3]/main/div/div[3]/div/form/div[9]/button[2]")
	WebElement submitCompanyBtn;

	public void addCompanyDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Handle overlay if it exists
		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		// Open Company section and click Add
		wait.until(ExpectedConditions.elementToBeClickable(companiesLink)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addCompany)).click();

		// Fill Basic Info
		wait.until(ExpectedConditions.visibilityOf(companyName)).sendKeys("Vasu Interprices Pvt Ltd.");
		new Select(companyType).selectByVisibleText("Client");
		new Select(companyStatus).selectByVisibleText("Active");

		// Fill Contact Person
		contactName.sendKeys("Vasu Chaurasiya");
		contactEmail.sendKeys("Vasu@gmail.com");
		contactPhone.sendKeys("5735354534");
		contactDesignation.sendKeys("Project Manager");
		contactAltPhone.sendKeys("2342422344");

		// Fill Business Details
		gstNumber.sendKeys("26UBPBL5193A8Z1");
		panNumber.sendKeys("ABCDE4543R");
		cinNumber.sendKeys("U74995MH2011PTC123456");
		tdsNumber.sendKeys("MUMT12645A");
		registrationDate.sendKeys("02/04/2025");

		// Fill Legal Details
		legalName.sendKeys("Vasu Interprices Pvt Ltd.");
		legalAddress.sendKeys("Ithum tower 2nd flor noida");
		legalCity.sendKeys("Noida");
		legalState.sendKeys("Uttar Pradesh");
		legalCountry.sendKeys("India");
		legalPincode.sendKeys("201311");

		// Fill Address
		addressStreet.sendKeys("Ithum tower 2nd flor noida");
		addressCity.sendKeys("Noida");
		addressState.sendKeys("Uttar Pradesh");
		addressCountry.sendKeys("India");
		addressPincode.sendKeys("201320");
		addressLandmark.sendKeys("Ithum tower");

		// Remove Bank Account if exists
		wait.until(ExpectedConditions.elementToBeClickable(bankRemoveBtn)).click();

		// Submit the form
		wait.until(ExpectedConditions.elementToBeClickable(submitCompanyBtn)).click();
	}
}
