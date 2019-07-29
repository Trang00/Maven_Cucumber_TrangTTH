package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;

public class NewCustomerPageSteps extends AbstractTest{
	WebDriver driver;
	String email=+randomNumber()+"@gmail.com";
	public static String CustomerID;
	
	private NewCustomerPageObject newCustomerPage;
	public NewCustomerPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		newCustomerPage=PageFactoryManager.getNewCustomerPage(driver);
	}

	@When("^Input to New Customer form with data$")
	public void inputToNewCustomerFormWithData(DataTable newCustomerTable){
		List<Map<String, String>> customer=newCustomerTable.asMaps(String.class, String.class);
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "name", customer.get(0).get("Name"));
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "dob", customer.get(0).get("DataOfBirth"));
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "addr", customer.get(0).get("Address"));
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "city", customer.get(0).get("City"));
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "state", customer.get(0).get("State"));
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "pinno", customer.get(0).get("Pin"));
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "telephoneno", customer.get(0).get("Phone"));
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "emailid", customer.get(0).get("Email")+email);
		newCustomerPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "password", customer.get(0).get("Password"));
	}

	@When("^I click to Submit button at New Customer page$")
	public void iClickToSubmitButtonAtNewCustomerPage(){
		newCustomerPage.clickDynamicSubmit(driver, "sub");
	}

	@Then("^Verify message displayed with data$")
	public void verifyMessageDisplayedWithData(){
		 newCustomerPage.isNewCustomerSuccessfullyPageDisplayed();
	}

	@Then("^I verify all above infomation created success$")
	public void iVerifyAllAboveInfomationCreatedSuccess(DataTable customerTable){
		List<Map<String, String>> customerT=customerTable.asMaps(String.class, String.class);
		Assert.assertEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Customer Name"),customerT.get(0).get("Name"));
		Assert.assertEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Address"),customerT.get(0).get("Address"));
		Assert.assertEquals(newCustomerPage.getDynamicTextDisplayed(driver, "City"),customerT.get(0).get("City"));
		Assert.assertEquals(newCustomerPage.getDynamicTextDisplayed(driver, "State"),customerT.get(0).get("State"));
		Assert.assertEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Pin"),customerT.get(0).get("Pin"));
		Assert.assertEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Mobile No."),customerT.get(0).get("Phone"));
		Assert.assertEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Email"),customerT.get(0).get("Email")+email);
	}

	@Given("^I get Customer ID at New Customer page$")
	public void iGetCustomerIDAtNewCustomerPage(){
		CustomerID=newCustomerPage.getDynamicTextDisplayed(driver, "Customer ID");
	}
}
