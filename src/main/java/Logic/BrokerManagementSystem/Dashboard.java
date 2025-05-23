package Logic.BrokerManagementSystem;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/nav/ul/li[1]/a")
	WebElement dashboardLink;

	public void dashboardDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Handle overlay if it exists
		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		wait.until(ExpectedConditions.elementToBeClickable(dashboardLink));
		dashboardLink.click();
	}
}
