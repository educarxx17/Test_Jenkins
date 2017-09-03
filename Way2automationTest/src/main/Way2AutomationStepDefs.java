package main;

import java.util.List;
import java.util.concurrent.TimeUnit;

import PageObjects.LoginData;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.DemoHomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Way2AutomationStepDefs {
	private WebDriver driver;

	@Before
	public void beforeScenario() {
		// this will run before the actual scenario
		driver = new DriverFactory().getDriver();
	}

	@After
	public void afterScenario() throws InterruptedException {
		// this will run after scenario is finished, even if it failed
		new DriverFactory().destroyDriver();

	}

	@Given("^I am on home page$")
	public void setUp() throws Throwable {
		driver = new DriverFactory().getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com");
		Thread.sleep(1000);
	}

	@When("^I select test demo site link$")
	public void goes_to_services_page() throws Throwable {
		HomePage homePage = new HomePage(driver);
		//homePage.clickDemoSiteLink();
		homePage.clickTestDemoSiteLink();
		Thread.sleep(1000);
	}

	@Then("^I can see demo site$")
	public void he_can_see_services_on_offer() throws Throwable {
		DemoHomePage demoHomePage = new DemoHomePage(driver);
		demoHomePage.verifyDemoSitePage();
		demoHomePage.verifyDemoSiteTitle();
	}

	@Given("^I select member login button$")
	public void i_select_member_login_button() throws Throwable {
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		HomePage homePage = new HomePage(driver);
		homePage.clickMemberLoginButton();
        // Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
	}

	@When("^I tried to login with no details$")
	public void i_tried_to_login_with_no_details() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
	}

	@Then("^I can see why my login failed$")
	public void i_can_see_why_my_login_failed() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyValidationText();
	}

    @When("^I enter my details$")
    public void i_enter_my_details(List<LoginData> loginData) throws Throwable {    // Write code here that turns the phrase above into concrete actions
        LoginPage loginPage = new LoginPage(driver);
        for (LoginData data : loginData) {
            loginPage.setEmailText(data.email);
            loginPage.setPasswordText(data.password);
             // i=i+1;
            Thread.sleep(500);
        }

    }

    @Then("^I select login button$")
    public void i_select_login_button() throws Throwable {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

}