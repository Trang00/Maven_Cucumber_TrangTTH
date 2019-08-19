package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.CommonPageObject;
import pageObjects.PageFactoryManager;

public class commonSteps extends AbstractTest {
	private WebDriver driver;
	private CommonPageObject commonPage;
	
	public commonSteps() {
		driver=Hooks.openAndQuitBrowser();
		commonPage=PageFactoryManager.getCommonPage(driver);
	}
	@When("^I open \"([^\"]*)\" page$")
	public void iOpenDynamicPageLink(String pageName){
		commonPage.openDynamicPage(pageName);
	}

	@When("^I input to \"([^\"]*)\" textbox or textarea with \"([^\"]*)\" data \"([^\"]*)\"$")
	public void iInputToDynamicTextBoxOrTextAreaWithRandomData(String textboxNameID, String randomValue, String dataValue){
		if(randomValue.equalsIgnoreCase("random")) {
			if(dataValue.endsWith("@gmail.com")) {
				String[]subString=dataValue.split("@");
				dataValue=subString[0]+randomNumber()+"@"+subString[1];
			}else {
				dataValue=dataValue+randomNumber();
			}
		}
		commonPage.inputDynamicTextboxOrTextAreaOrButtonOrChecbox(textboxNameID, dataValue);
	}
	@When("^I select \"([^\"]*)\" radio button$")
	public void iSelectToDynamicRadioButton(String radioValue){
		commonPage.clickDynamicRadio(radioValue);
	}
	@When("^click to \"([^\"]*)\" dropdown with value \"([^\"]*)\"$")
	public void clickToDynamicDropdownWithValue(String dropdownNameID, String valueItem){
		commonPage.inputDynamicDropdown(dropdownNameID, valueItem);
	}
	@When("^I click to \"([^\"]*)\" button$")
	public void iClickToDynamicButton(String buttonNameID){
		commonPage.clickDynamicSubmit(buttonNameID);
	}
	@When("^Verify message \"([^\"]*)\" displayed success$")
	public void VerifyDynamicMessageDisplayed(String dynamicMessage){
		verifyTrue(commonPage.isDynamicSuccessfullyPageDisplayed(dynamicMessage));
	}

	@When("^Verify alert meaasge \"([^\"]*)\" displayed and accept$")
	public void verifyDynamicAlertMessageDisplayedAndAccept(String dynamicMessage){
		verifyTrue(commonPage.isDynamicAlertDisplayed(dynamicMessage));
	}
	
	@When("^Wait for some (minutes|seconds) \"([^\"]*)\"$")
	public void waitForSomeMinuteOrSecond(String timevalue, String timeUnit){
		int time=Integer.parseInt(timeUnit);
		if(timevalue.equals("seconds")) {
			commonPage.sleepInSecond(time);
		}else {
			commonPage.sleepInSecond(time*60);
		}
	}
	@When("^I get text to \"([^\"]*)\" displayed$")
	public void iGetTextToDynamicDisplayed(String dynamicMessage){
		commonPage.getDynamicTextDisplayed(dynamicMessage);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
