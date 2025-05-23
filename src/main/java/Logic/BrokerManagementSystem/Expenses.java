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

public class Expenses {

	WebDriver driver;

	public Expenses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.nav-link[href='/expenses']")
	WebElement expensesClick;

	@FindBy(xpath = "//button[text()='Add Expense']")
	WebElement addExpenseBtn;

	@FindBy(css = "input.shadow-sm[name='title']")
	WebElement expensesTitle;

	@FindBy(css = "input#amount[name='amount']")
	WebElement expensesAmount;

	@FindBy(css = "input#date[name='date']")
	WebElement expensesDate;

	@FindBy(css = "select#category[name='category']")
	WebElement expensesCategoryDropdown;

	@FindBy(css = "select#company[name='company']")
	WebElement expensesCompanyDropdown;

	@FindBy(css = "select#status[name='status']")
	WebElement statusDropdown;

	@FindBy(css = "textarea#description[name='description']")
	WebElement expensesDescription;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/main/div/div[3]/div/form/div[3]/button[2]")
	WebElement doneExpenseBtn;

	public void expensesDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By overlay = By.cssSelector("div.fixed.inset-0.bg-gray-600");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

		wait.until(ExpectedConditions.elementToBeClickable(expensesClick));
		expensesClick.click();

		wait.until(ExpectedConditions.elementToBeClickable(expensesClick));
		addExpenseBtn.click();

		expensesTitle.sendKeys("Travel");
		expensesAmount.sendKeys("4000");
		expensesDate.sendKeys("05/05/2025");

		Select categorySelect = new Select(expensesCategoryDropdown);
		categorySelect.selectByVisibleText("Travel");

		Select companySelect = new Select(expensesCompanyDropdown);
		companySelect.selectByVisibleText("Brightwave Technologies Pvt. Ltd.");

		Select statusSelect = new Select(statusDropdown);
		statusSelect.selectByVisibleText("Approved");

		expensesDescription.sendKeys("Expenses on travel include costs like transportation, accommodation,"
				+ " meals, and other related charges incurred during business"
				+ " or personal trips. These are usually documented for reimbursement " + "or budgeting purposes");

		wait.until(ExpectedConditions.elementToBeClickable(doneExpenseBtn));
		doneExpenseBtn.click();

	}

}
