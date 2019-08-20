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

public class WithdrawalPageSteps extends AbstractPage {
	WebDriver driver;
	private DepositPageObject depositPage;
	public WithdrawalPageSteps() {
		driver=Hooks.openAndQuitBrowser();
		depositPage=PageFactoryManager.getDepositPage(driver);
	}


	
	
}
