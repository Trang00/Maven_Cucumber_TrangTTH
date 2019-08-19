package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.PageFactoryManager;

public class EditAccountPageSteps extends AbstractPage {
	WebDriver driver;
	private EditAccountPageObject editAccountPage;
	public EditAccountPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		editAccountPage=PageFactoryManager.getEditAccountPage(driver);
	}

	@Given("^I input to Account ID textbox$")
	public void iInputToAccountIDTextbox(){
		editAccountPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "cusid", NewAccountPageSteps.AccountID);
	}
	
	
}
