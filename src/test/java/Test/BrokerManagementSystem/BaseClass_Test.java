package Test.BrokerManagementSystem;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Logic.BrokerManagementSystem.Advances;
import Logic.BrokerManagementSystem.BankAccounts;
import Logic.BrokerManagementSystem.Brokers;
import Logic.BrokerManagementSystem.Companies;
import Logic.BrokerManagementSystem.Dashboard;
import Logic.BrokerManagementSystem.Deals;
import Logic.BrokerManagementSystem.Expenses;
import Logic.BrokerManagementSystem.Login_page;
import Logic.BrokerManagementSystem.Slab;
import utils.ReadConfigFile;

public class BaseClass_Test {

	private WebDriver driver;
	ReadConfigFile config;
	// Page Object References
	private Companies companies;
	private Deals deals;
	private BankAccounts bankAccounts;
	private Brokers brokers;
	private Expenses expenses;
	private Advances advances;
	private Slab slab;
	private Dashboard dashboard;
	private Login_page loginPage;


@BeforeClass
public void setUp() throws IOException {
    ChromeOptions options = new ChromeOptions();

    // 🔐 Prevent user profile conflict in CI
    String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome-profile-" + UUID.randomUUID();
    options.addArguments(
        "--headless=new",                  // For CI environments
        "--disable-dev-shm-usage",         // Avoid memory issues
        "--no-sandbox",                    // Required in containers
        "--window-size=1920,1080",         // Full HD view
        "--user-data-dir=" + userDataDir   // ✅ Prevent Chrome profile conflict
    );

    driver = new ChromeDriver(options);

    // Correct: use the driver you've just created
    config = new ReadConfigFile(driver);

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(config.getURL());

    // Initialize Page Objects
    loginPage = new Login_page(driver);
    companies = new Companies(driver);
    deals = new Deals(driver);
    bankAccounts = new BankAccounts(driver);
    brokers = new Brokers(driver);
    expenses = new Expenses(driver);
    advances = new Advances(driver);
    slab = new Slab(driver);
    dashboard = new Dashboard(driver);
}

	@Test(priority = 1)
	public void testLoginPage() throws IOException {
		loginPage.Login_pag();
	}

	@Test(priority = 2)
	public void testCreateCompany() {
		companies.addCompanyDetails();
	}

	@Test(priority = 3)
	public void testCreateDeals() {
		deals.deals();
	}

	@Test(priority = 4)
	public void testCreateBankAccounts() {
		bankAccounts.bankAccounts();
	}

	@Test(priority = 5)
	public void testCreateBrokers() {
		brokers.addBrokerDetails();
	}

	@Test(priority = 6)
	public void testCreateExpenses() {
		expenses.expensesDetails();
	}

	@Test(priority = 7)
	public void testCreateAdvances() throws InterruptedException {
		advances.advancesDetails();
	}

	@Test(priority = 8)
	public void testCreateSlab() {
		slab.slabDetails();
	}

	@Test(priority = 9)
	public void testViewDashboard() {
		dashboard.dashboardDetails();
	}

}
