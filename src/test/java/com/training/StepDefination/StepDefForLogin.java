package com.training.StepDefination;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.training.Pages.CheckYourEmailPage;
import com.training.Pages.ForgetPasswordPage;
import com.training.Pages.HomePage;
import com.training.Pages.LoginPage;
import com.training.Utilities.Log4j2Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefForLogin {
	Logger mylogger=Log4j2Utility.getLogger(StepDefForLogin.class);
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ForgetPasswordPage forgetpage;
	CheckYourEmailPage check;
	
	public void launchBrowser(String browserName){
		switch(browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Log4j2Utility.logInfo("The Chrome Browser is launched.");
			driver.manage().window().maximize();
			Log4j2Utility.logInfo("Window has been maximized.");
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			Log4j2Utility.logInfo("The Edge Browser is launched.");
			driver.manage().window().maximize();
			Log4j2Utility.logInfo("Window has been maximized.");
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Log4j2Utility.logInfo("The FireFox Browser is launched.");
			driver.manage().window().maximize();
			Log4j2Utility.logInfo("Window has been maximized.");
			break;
			
		default:
			Log4j2Utility.logError("The unknown browser is launched.");
		}
	}
	
	public void getUrl(String url){
		driver.get(url);
		Log4j2Utility.logInfo("The application url has been entered.");
	}
	
	public void closeBrowser() {
		driver.close();
		Log4j2Utility.logInfo("All the testCases are passed so browser is closed.");
	}
	
	public void closeAllTheBrowsers() {
		driver.quit();
		Log4j2Utility.logInfo("All the testCases are passed so browser is closed.");
	}
	
	@Before
	public void beforeEveryScenario() {
		launchBrowser("chrome");
	}
	
	@After
	public void tearDown() {
		closeBrowser();
	}
	
	
	@Given("the URL {string}")
	public void the_url(String url) {
	   getUrl(url);
	   }
	
	@When("i entered in {string}")
	public void i_entered_in(String pageName) {
	   if(pageName.equalsIgnoreCase("LoginPage")) {
		   loginpage=new LoginPage(driver);
	   }
	   else if(pageName.equalsIgnoreCase("HomePage")) {
		   homepage=new HomePage(driver);
	   }
	   else if(pageName.equalsIgnoreCase("ForgetPasswordPage")) {
		   forgetpage=new ForgetPasswordPage(driver);
	   }
	   else if(pageName.equalsIgnoreCase("CheckYourEmailPage")){
		   check=new CheckYourEmailPage(driver);
	   }
	}

	@When("i entered username as {string}")
	public void i_entered_username_as(String userName) {
	loginpage.usernameData(userName);
	}

	@When("i entered password as {string}")
	public void i_entered_password_as(String Password) {
		loginpage.passwordData(Password);
	}

	@When("i click on the login button")
	public void i_click_on_the_login_button() {
		driver=loginpage.clickButtonToLogin();
		
	}

	@Then("i should get an error message as {string}")
	public void i_should_get_an_error_message_as(String expectedText) {
		loginpage.getTheDisplayedErrorMessageOnScreen(expectedText);
	}

	@Then("i should see homepage")
	public void i_should_see_homepage() {
	    homepage.getHomepageTitle();
	}
	
	@When("i click on the remember me check Box")
	public void i_click_on_the_remember_me_check_box() {
		loginpage.clickOnRememberMeCheckBox();
	}
	
	@When("i click on login button")
	public void i_click_on_login_button() {
		driver=loginpage.clickButtonToLogin();
	}
	
	@When("i see the homepage")
	public void i_see_the_homepage() {
		 homepage.getHomepageTitle();
	}
	
	@When("i click on usermenudropdown")
	public void i_click_on_usermenudropdown() {
		homepage.clickOnUserMenuInHomePage();
	}
	
	@When("i click on logout")
	public void i_click_on_logout() {
		driver=homepage.clickOnLogoutInUserMenu();
	}
	
	@When("i entered the {string}")
	public void i_entered_the(String loginPage) {
	    loginpage.getThePageTitle();
	}
	
	@Then("i should see username displayed as {string}")
	public void i_should_see_username_displayed_as(String expectedData) {
		loginpage.checkUserNameIsDisplayed(expectedData);
	}
	
	@Then("i should also see the remember me checkbox is checked")
	public void i_should_also_see_the_remember_me_checkbox_is_checked() {
		loginpage.verifyTheCheckedElementInLoginPageIsSelected();
	}
	
	@When("i click on forget password link")
	public void i_click_on_forget_password_link() {
		driver=loginpage.clickOnForgetPasswordLink();
	}
	
	@When("i entered the username as {string}")
	public void i_entered_the_username_as(String UserName) {
		forgetpage.getForgetPageTitle();
		forgetpage.userNameField(UserName);
	}
	
	@When("i click on continue button")
	public void i_click_on_continue_button() {
		driver=forgetpage.clickOnContinue();
	}
	
	@Then("i should see the message displayed as {string}")
	public void i_should_see_the_message_displayed_as(String expectedData) {
		check.getCheckEmailPageTitle();
		check.getTheMessageDisplayOnScreen(expectedData);
	}
}
