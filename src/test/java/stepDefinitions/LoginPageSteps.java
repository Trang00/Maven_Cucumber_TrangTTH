package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import commons.AbstractTest;
import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import shareContext.ContextVariable;
import shareContext.TestContext;


public class LoginPageSteps extends AbstractTest {
	WebDriver driver;
	private LoginPageObject loginPage;
	//public static String loginPageUrl;
/*	
	TestContext testContext;
	
	public LoginPageSteps(TestContext context) {
		driver=Hooks.openAndQuitBrowser();
		testContext=context;
		loginPage=PageFactoryManager.getLoginPage(driver);
	}
	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl()   {
		//loginPageUrl=loginPage.getCurrenUrl(driver);
		//ShareContextData.LOGIN_PAGE_URL=loginPage.getCurrenUrl(driver);//Cách 1- Static variable
		testContext.getScenarioContext().setContext(ContextVariable.LOGIN_PAGE_URL, loginPage.getCurrenUrl(driver));// Cách 2 picoContainer
	}

	@Given("^I click to here link$")
	public void iClickToHereLink()   {
	     driver.findElement(By.xpath("//a[text()='here']")).click();
	}

	@Given("^I input to Username textbox$")
	public void iInputToUsernameTextbox()   {
		// loginPage.inputToUserIDTextbox(RegisterPageSteps.userID);
		//loginPage.inputToUserIDTextbox(ShareContextData.USER_ID);
		testContext.getScenarioContext().setContext(ContextVariable.USER_ID, RegisterPageSteps.userID);
		
	}

	@Given("^I input to Password textbox$")
	public void iInputToPasswordTextbox()   {
		//loginPage.inputToPasswordTextbox(RegisterPageSteps.password);
		//loginPage.inputToPasswordTextbox(ShareContextData.PASSWORD);
		testContext.getScenarioContext().setContext(ContextVariable.PASSWORD, RegisterPageSteps.password);
	}

	@Given("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage()   {
		loginPage.clickToLoginButton();
	}
*/

	
	public LoginPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		loginPage=PageFactoryManager.getLoginPage(driver);
	}
	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl()   {
		//loginPageUrl=loginPage.getCurrenUrl(driver);
		ShareContextData.LOGIN_PAGE_URL=loginPage.getCurrenUrl(driver);//Cách 1- Static variable

	}

	@Given("^I click to here link$")
	public void iClickToHereLink()   {
	     driver.findElement(By.xpath("//a[text()='here']")).click();
	}

	@Given("^I input to Username textbox$")
	public void iInputToUsernameTextbox()   {
		// loginPage.inputToUserIDTextbox(RegisterPageSteps.userID);
		loginPage.inputToUserIDTextbox(ShareContextData.USER_ID);
		
	}

	@Given("^I input to Password textbox$")
	public void iInputToPasswordTextbox()   {
		//loginPage.inputToPasswordTextbox(RegisterPageSteps.password);
		loginPage.inputToPasswordTextbox(ShareContextData.PASSWORD);
		
	}

	@Given("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage()   {
		loginPage.clickToLoginButton();
	}
	
}
