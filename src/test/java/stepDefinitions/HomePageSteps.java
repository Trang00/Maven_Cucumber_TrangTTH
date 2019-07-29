package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pageObjects.HomePageObject;
import pageObjects.PageFactoryManager;

public class HomePageSteps {
	WebDriver driver;
	private HomePageObject homePage;
	public HomePageSteps() {
		driver=Hooks.openAndQuitBrowser();
		homePage=PageFactoryManager.getHomePage(driver);
	}
	@Then("^Verify Home page displayed$")
	public void verifyHomePageDisplayedWithMessage()  {
		 Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	@Given("^I open Customer page$")
	public void iOpenCustomerPage(){
		homePage.openNewCustomerPage(driver);
	}

}
