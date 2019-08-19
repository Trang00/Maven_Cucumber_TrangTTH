package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import pageObjects.EditCustomerPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.PageFactoryManager;

public class NewAccountPageSteps {
	WebDriver driver;
	public static String AccountID;
	private NewAccountPageObject newAccountPage;
	public NewAccountPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		newAccountPage=PageFactoryManager.getNewAccountPage(driver);
	}
	@Given("^I get Account ID at New Account page$")
	public void iGetAccountIDAtNewAccountPage(){
		AccountID=newAccountPage.getDynamicTextDisplayed(driver, "Account ID");
	}

	
	
}
