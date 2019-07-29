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

public class RegisterPageSteps extends AbstractTest {
	WebDriver driver;
	public static String  userID, password;
	
	private RegisterPageObject registerPage;
	
	public RegisterPageSteps() {
		driver=Hooks.openAndQuitBrowser();
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
		userID=registerPage.getUserIDText();
	}

	@Then("^I get Password infor$")
	public void iGetPasswordInfor()   {
		password=registerPage.getPasswordText();
	}
	@Given("^I open Login page again$")
	public void iOpenLoginPageAgain()   {
		registerPage.openLoginPage(LoginPageSteps.loginPageUrl);
	     
	}


	
}
