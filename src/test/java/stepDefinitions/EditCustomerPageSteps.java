package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pageObjects.EditCustomerPageObject;
import pageObjects.PageFactoryManager;

public class EditCustomerPageSteps extends AbstractTest {
	WebDriver driver;
	private EditCustomerPageObject editCustomerPage;
	public EditCustomerPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		editCustomerPage=PageFactoryManager.getEditCustomerPage(driver);
	}

	@Given("^I open Edit Customer page$")
	public void iOpenEditCustomerPage()  {
		editCustomerPage.openDynamicPage(driver, "Edit Customer");
	}


	@Given("^Input Customer ID to textbox$")
	public void inputCustomerIDToTextbox()  {
		editCustomerPage.inputCustomerIDText(ShareContextData.CUSTOMER_ID);
	    
	}

	@Given("^I click to Submit button at Edit Customer form$")
	public void iClickToSubmitButtonAtEditCustomerForm()  {
		editCustomerPage.clickCustomerIDSubmit();
	    
	}

	@Given("^Input to Edit Customer form with data$")
	public void inputToEditCustomerFormWithData(DataTable editCustomerTable)  {
		List<Map<String, String>> customer=editCustomerTable.asMaps(String.class, String.class);

		editCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "addr", customer.get(0).get("EditAddress"));
		editCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "city", customer.get(0).get("EditCity"));
		editCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "state", customer.get(0).get("EditState"));
		editCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "pinno", customer.get(0).get("EditPin"));
		editCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "telephoneno", customer.get(0).get("EditPhone"));
		editCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "emailid", customer.get(0).get("Email")+ShareContextData.EMAIL_ShareContext);
	}

	@Given("^I click to Submit button at Edit Customer page$")
	public void iClickToSubmitButtonAtEditCustomerPage()  {
		editCustomerPage.clickCustomerIDSubmit();
	    
	}

	@Then("^Verify message displayed with data edit$")
	public void verifyMessageDisplayedWithDataEdit()  {
		editCustomerPage.isEditCustomerSuccessfullyPageDisplayed();
	    
	}

	@Then("^I veify all above infomation edited success$")
	public void iVeifyAllAboveInfomationEditedSuccess(DataTable customerTable)  {
		List<Map<String, String>> customerT=customerTable.asMaps(String.class, String.class);
		
		Assert.assertEquals(editCustomerPage.getDynamicTextDisplayed(driver, "Address"),customerT.get(0).get("EditAddress"));
		Assert.assertEquals(editCustomerPage.getDynamicTextDisplayed(driver, "City"),customerT.get(0).get("EditCity"));
		Assert.assertEquals(editCustomerPage.getDynamicTextDisplayed(driver, "State"),customerT.get(0).get("EditState"));
		Assert.assertEquals(editCustomerPage.getDynamicTextDisplayed(driver, "Pin"),customerT.get(0).get("EditPin"));
		Assert.assertEquals(editCustomerPage.getDynamicTextDisplayed(driver, "Mobile No."),customerT.get(0).get("EditPhone"));
		Assert.assertEquals(editCustomerPage.getDynamicTextDisplayed(driver, "Email"),customerT.get(0).get("Email")+ShareContextData.EMAIL_ShareContext);
	    
	}


	
}
