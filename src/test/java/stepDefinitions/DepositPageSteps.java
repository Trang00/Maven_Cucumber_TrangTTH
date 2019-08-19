package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import commons.Constansts;
import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.PageFactoryManager;

public class DepositPageSteps extends AbstractPage {
	WebDriver driver;
	private DepositPageObject depositPage;
	public DepositPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		depositPage=PageFactoryManager.getDepositPage(driver);
	}

	@Given("^I input to Account ID textbox in Deposit$")
	public void iInputToAccountIDTextboxInDeposit(){
		depositPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(driver, "accountno", NewAccountPageSteps.AccountID);
	}
	@Given("^Verify message Transaction Successfully displayed success$")
	public void VerifyMessageTransactionSuccessfullyDisplayedSuccess(){
		Assert.assertTrue(depositPage.isDynamicSuccessfullyPageDisplayed(driver,"Transaction details of Deposit for Account "+NewAccountPageSteps.AccountID+""));
	}
	@Given("^Verify current Amount \"([^\"]*)\"$")
	public void VerifyCurrentAmount(String CurrentBalance){
		Assert.assertEquals(depositPage.getDynamicTextDisplayed(driver, "Current Balance"), CurrentBalance);
	}
	
	
}
