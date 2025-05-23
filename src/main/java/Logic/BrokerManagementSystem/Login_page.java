package Logic.BrokerManagementSystem;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ReadConfigFile;

public class Login_page {

	WebDriver driver;

	public Login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(id = "password")
	WebElement userNamePassword;

	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signInBtn;

	public void Login_pag() throws IOException {
		ReadConfigFile config = new ReadConfigFile(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		userName.sendKeys(config.getUserName());
		userNamePassword.sendKeys(config.getPassword());

		wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
		signInBtn.click();
	}
}
