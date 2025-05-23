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

public class Slab {
	WebDriver driver;

	public Slab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/nav/ul/li[8]/a")
	WebElement slabLink;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/main/div/div[2]/select")
	WebElement slabDropdown;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/main/div/div[2]/div[2]/div[1]/div[1]/input")
	WebElement minAmount;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/main/div/div[2]/div[2]/div[1]/div[2]/input")
	WebElement maxAmount;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/main/div/div[2]/div[2]/div[1]/div[3]/input")
	WebElement slabCommision;

	@FindBy(xpath = "//button[text()='Add Slab']")
	WebElement addSlabBtn;

	public void slabDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Handle overlay if it exists
		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		wait.until(ExpectedConditions.elementToBeClickable(slabLink)).click();

		Select slabSelect = new Select(slabDropdown);
		slabSelect.selectByVisibleText("Client Slabs");

		minAmount.sendKeys("0");
		maxAmount.sendKeys("1000000");
		slabCommision.sendKeys("5");

		wait.until(ExpectedConditions.elementToBeClickable(addSlabBtn)).click();
	}
}
