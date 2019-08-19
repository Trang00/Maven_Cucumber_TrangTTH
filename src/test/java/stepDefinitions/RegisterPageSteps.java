package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;
import shareContext.ContextVariable;
import shareContext.TestContext;

public class RegisterPageSteps extends AbstractTest {
	WebDriver driver;
	public static String  userID, password;
	TestContext testContext;
	
	private RegisterPageObject registerPage;
	
	public RegisterPageSteps(TestContext context) {
		driver=Hooks.openAndQuitBrowser();
		testContext=context;
		registerPage=PageFactoryManager.getRegisterPage(driver);
	}

	@Given("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String emailvalue)   {
		String email=emailvalue+randomNumber()+"@gmail.com";
		registerPage.inputToEmailIDTextbox(email);
	}

	@Given("^I click to Submit button at register page$")
	public void iClickToSubmitButtonAtRegisterPage()   {
		registerPage.clickToSubmitButton();
	}

	@Then("^I get UserID infor$")
	public void iGetUserIDInfor()   {
		//userID=registerPage.getUserIDText();
		String ID=registerPage.getUserIDText();
		//ShareContextData.USER_ID=registerPage.getUserIDText();
		testContext.getScenarioContext().setContext(ContextVariable.USER_ID, ID);
	}

	@Then("^I get Password infor$")
	public void iGetPasswordInfor()   {
		//password=registerPage.getPasswordText();
		//ShareContextData.PASSWORD=registerPage.getPasswordText();
		testContext.getScenarioContext().setContext(ContextVariable.USER_ID, registerPage.getPasswordText());
	}
	@Given("^I open Login page again$")
	public void iOpenLoginPageAgain()   {
		//registerPage.openLoginPage(LoginPageSteps.loginPageUrl);
		registerPage.openLoginPage((String) testContext.getScenarioContext().getContext(ContextVariable.LOGIN_PAGE_URL));
	}


	
}
