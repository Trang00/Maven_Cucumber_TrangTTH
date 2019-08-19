@CustomerNew
Feature: Customer
@register
 Scenario: register/ Login to application and Create New Customer
    Given I get Login page Url
    And I click to here link
    And I input to email textbox with data "autorandom"
    And I click to Submit button at register page
    Then I get UserID infor
    And I get Password infor
@loginApp
 Scenario: Login to application 
    Given I open Login page again
    And I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed
    
@newCustomer 
 Scenario Outline: Create new Customer
    Given I open Customer page
    When Input to New Customer form with data
    |  Name | Gender |  DataOfBirth  |   Address |   City |  State  |  Pin  |  Phone  |  Email  |  Password  |
    | <Name>| m      | <DataOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to Submit button at New Customer page
    Then Verify message displayed with data "Customer Registered Successfully!!!"
    And I verify all above infomation created success
    |  Name | Gender    |  DataOfBirth  |   Address |   City |  State  |  Pin  |  Phone  |  Email  |
    | <Name>| male      | <DataOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
   When I get Customer ID at New Customer page

     Examples: New Customer info
    |  Name |  DataOfBirth  |   Address |   City      |  State  |  Pin  |  Phone      |   Email  |  Password  | Message |
    | Auto Test| 1999-01-09 |123 Le Loi | Ho Chi Minh | Thu Duc |123456 | 094821455522| autotest | 123456     | Customer Registered Successfull!!! |
 
    
    
    
    
    
    
    
