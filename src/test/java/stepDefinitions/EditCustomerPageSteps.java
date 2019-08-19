package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import pageObjects.EditCustomerPageObject;
import pageObjects.PageFactoryManager;

public class EditCustomerPageSteps {
	WebDriver driver;
	private EditCustomerPageObject editCustomerPage;
	public EditCustomerPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		editCustomerPage=PageFactoryManager.getEditCustomerPage(driver);
	}

	@Given("^I input to Customer ID textbox$")
	public void iInputToCustomerIDTextbox(){
		System.out.println("Customer ID: "+NewCustomerPageSteps.CustomerID);
		editCustomerPage.inputCustomerIDText(NewCustomerPageSteps.CustomerID);
	}
	
	
}
