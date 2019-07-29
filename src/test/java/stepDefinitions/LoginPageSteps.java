package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class LoginPageSteps {
	WebDriver driver;
	private LoginPageObject loginPage;
	public static String loginPageUrl;
	
	public LoginPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		loginPage=PageFactoryManager.getLoginPage(driver);
	}
	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl()   {
		loginPageUrl=loginPage.getCurrenUrl(driver);
	}

	@Given("^I click to here link$")
	public void iClickToHereLink()   {
	     driver.findElement(By.xpath("//a[text()='here']")).click();
	}

	@Given("^I input to Username textbox$")
	public void iInputToUsernameTextbox()   {
		 loginPage.inputToUserIDTextbox(RegisterPageSteps.userID);
	}

	@Given("^I input to Password textbox$")
	public void iInputToPasswordTextbox()   {
		loginPage.inputToPasswordTextbox(RegisterPageSteps.password);
	}

	@Given("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage()   {
		loginPage.clickToLoginButton();
	}

	
}
