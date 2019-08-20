package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RegisterAndLoginSteps extends AbstractTest {
	/*	WebDriver driver;
	String loginPageUrl,email, userID, password,CustomerID;
	int Random=randomValue();
	
	
	@Given("^I open appliction$")
	public void iOpenAppliction()   {
	     driver= new FirefoxDriver();
	     driver.get("http://demo.guru99.com/v4");
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);    
	}

	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl()   {
	     loginPageUrl=driver.getCurrentUrl();	 
	}

	@Given("^I click to here link$")
	public void iClickToHereLink()   {
	     driver.findElement(By.xpath("//a[text()='here']")).click();
	}
	
	@Given("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String emailValue)   {
	     email=emailValue+randomValue()+"@gmail.com";
	     driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	}

	@Given("^I click to Submit button at register page$")
	public void iClickToSubmitButtonAtRegisterPage()   {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();;
	}

	@Then("^I get UserID infor$")
	public void iGetUserIDInfor()   {
	     userID=driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
	}

	@Then("^I get Password infor$")
	public void iGetPasswordInfor()   {
	     password=driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();
	}

	@When("^I open Login page again$")
	public void iOpenLoginPageAgain()   {
	   driver.get(loginPageUrl);
	     
	}

	@Given("^I input to Username textbox$")
	public void iInputToUsernameTextbox()   {
		 driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	}

	@Given("^I input to Password textbox$")
	public void iInputToPasswordTextbox()   {
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@Given("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage()   {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}
	

	@Then("^Verify Home page displayed with message \"([^\"]*)\"$")
	public void verifyHomePageDisplayedWithMessage(String webcomeMes)  {
		 Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\""+webcomeMes+"\"]")).isDisplayed());
	}
	

	@When("^Input to New Customer form with data$")
	public void inputToNewCustomerFormWithData(DataTable newCustomerTable){
		List<Map<String, String>> customer=newCustomerTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(customer.get(0).get("DataOfBirth"));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("Email")+Random+"@hotmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Password"));
	}

	@When("^I click to Submit button at New Customer page$")
	public void iClickToSubmitButtonAtNewCustomerPage(){
		driver.findElement(By.xpath("//input[@name='sub']")).click();
	}

	@Then("^Verify message displayed with data \"([^\"]*)\"$")
	public void verifyMessageDisplayedWithData(String NewCustomer){
		 Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+NewCustomer+"']")).isDisplayed());	
	}

	@Then("^I verify all above infomation created success$")
	public void iVerifyAllAboveInfomationCreatedSuccess(DataTable customerTable){
		List<Map<String, String>> customerT=customerTable.asMaps(String.class, String.class);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),customerT.get(0).get("Name") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),customerT.get(0).get("Address") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),customerT.get(0).get("City") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),customerT.get(0).get("State") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(),customerT.get(0).get("Pin") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),customerT.get(0).get("Phone") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),customerT.get(0).get("Email")+Random+"@hotmail.com");
	}

	@Given("^I get Customer ID at New Customer page$")
	public void iGetCustomerIDAtNewCustomerPage(){
		CustomerID=driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	}


	@Given("^I open Edit Customer page$")
	public void iOpenEditCustomerPage(){
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	}

	@Given("^Input Customer ID to textbox$")
	public void inputCustomerIDToTextbox(){
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
	}

	@Given("^I click to Submit button at Edit Customer form$")
	public void iClickToSubmitButtonAtEditCustomerForm(){
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
	}

	@Given("^Input to Edit Customer form with data$")
	public void inputToEditCustomerFormWithData(DataTable editCustomerTable){
		List<Map<String, String>> customer=editCustomerTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//textarea[@name='addr']")).clear();
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("EditAddress"));
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("EditCity"));
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("EditState"));
		driver.findElement(By.xpath("//input[@name='pinno']")).clear();
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("EditPin"));
		driver.findElement(By.xpath("//input[@name='telephoneno']")).clear();
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("EditPhone"));
		driver.findElement(By.xpath("//input[@name='emailid']")).clear();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("Email")+Random+"@hotmail.com");
	}
	@Given("^I click to Submit button at Edit Customer page$")
	public void iClickToSubmitButtonAtEditCustomerPage(){
		driver.findElement(By.xpath("//input[@name='sub']")).click();
	}
	@Then("^Verify message displayed with data edit \"([^\"]*)\"$")
	public void verifyMessageDisplayedWithDataEdit(String EditCustomer){
		 Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+EditCustomer+"']")).isDisplayed());		
	}

	@Then("^I veify all above infomation edited success$")
	public void iVeifyAllAboveInfomationEditedSuccess(DataTable customerTable){
		List<Map<String, String>> customerT=customerTable.asMaps(String.class, String.class);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),customerT.get(0).get("EditAddress") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),customerT.get(0).get("EditCity") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),customerT.get(0).get("EditState") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-siblin g::td")).getText(),customerT.get(0).get("EditPin") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),customerT.get(0).get("EditPhone") );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),customerT.get(0).get("Email")+Random+"@hotmail.com");
	}
	@Then("^I close browser$")
	public void iCloseBrowser() throws Throwable {
		driver.close();
	}
	protected int randomValue() {
		Random random = new Random();
		int number = random.nextInt(999);
		return number;
	}
*/
}
