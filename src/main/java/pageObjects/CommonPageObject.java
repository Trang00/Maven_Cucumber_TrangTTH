package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CommonPageUI;

public class CommonPageObject extends AbstractPage{
	WebDriver driver;
	public CommonPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public void openDynamicPage(String pageName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_LINK,pageName);
		clickToElement(driver, CommonPageUI.DYNAMIC_LINK,pageName);
	}
	public void inputDynamicTextboxOrTextAreaOrButtonOrChecbox(String dynamicValue,String values ) {
		waitForControlVisible(driver,CommonPageUI.DYNAMIC_TEXTBOX_TEXTAREA_BUTTON_CHECKBOX, dynamicValue);
		senkeyToElement(driver,CommonPageUI.DYNAMIC_TEXTBOX_TEXTAREA_BUTTON_CHECKBOX, values , dynamicValue);
	}
	public void clickDynamicRadio( String radioValue) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_RADIO, radioValue);
		clickToElement(driver, CommonPageUI.DYNAMIC_RADIO, radioValue);
	}
	public void clickDynamicSubmit(String dynamicValue) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_SUBMIT, dynamicValue);
		clickToElement(driver, CommonPageUI.DYNAMIC_SUBMIT, dynamicValue);
	}
		
	public void inputDynamicText1(String values, String dynamicValue) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_TEXTAREA_BUTTON_CHECKBOX, dynamicValue);
		if(driver.toString().contains("chrome")) {
			removeAttributeInDOM(driver, CommonPageUI.DYNAMIC_TEXTBOX_TEXTAREA_BUTTON_CHECKBOX, "type", values);
		}
		senkeyToElement(driver, values, CommonPageUI.DYNAMIC_TEXTBOX_TEXTAREA_BUTTON_CHECKBOX, dynamicValue);
	}
	
	public void DynamicPressTab(String dynamicValue) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_TEXTAREA_BUTTON_CHECKBOX, dynamicValue);
		sendKeyDynamicboardToElement(driver, Keys.TAB, CommonPageUI.DYNAMIC_TEXTBOX_TEXTAREA_BUTTON_CHECKBOX, dynamicValue);
	}
	public String getDynamicText(String dynamicValue ) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_TEXT, dynamicValue);
		return getTextDynamicInElement(driver, CommonPageUI.DYNAMIC_TEXT, dynamicValue);
	}
	public String getDynamicTextDisplayed(String dynamicValue ) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_GET_TEXT_DISPLAYED, dynamicValue);
		return getTextDynamicInElement(driver, CommonPageUI.DYNAMIC_GET_TEXT_DISPLAYED, dynamicValue);
	}

	public boolean isDynamicSuccessfullyPageDisplayed(String dynamicMessage) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_TEXT_DISPLAYED, dynamicMessage);
		return isControlDisplayed(driver,CommonPageUI.DYNAMIC_TEXT_DISPLAYED, dynamicMessage);
	}
	public String getDynamicTextH2(String dynamicValue ) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_H2_TEXT, dynamicValue);
		return getTextDynamicInElement(driver, CommonPageUI.DYNAMIC_H2_TEXT, dynamicValue);
	}
	public void inputDynamicDropdown(String valueInDropdown,String dynamicValue) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROPDOWN, dynamicValue);
		selectItemInHtmlDropdownDynamic(driver, valueInDropdown, CommonPageUI.DYNAMIC_DROPDOWN, dynamicValue);
	}
	public String getLabelDynamicText(String dynamicValue ) {
		waitForControlVisible(driver,CommonPageUI.DYNAMIC_LABEL_TEXT);
		return getTextDynamicInElement(driver, CommonPageUI.DYNAMIC_LABEL_TEXT, dynamicValue);
	}
	public boolean isDynamicAlertDisplayed(String alertMessage ) {
		waitForAlertPresence(driver);
		return isAlertDisplayedWithMessage(driver, alertMessage);
	}
	public void AccepAlertwait() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	
	public String getAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
