@CustomerNewDynamic
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
    Given I open "New Customer" page
    When I input to "name" textbox or textarea with "notrandom" data "<Name>"
    And I select "m" radio button
    And I input to "dob" textbox or textarea with "notrandom" data "<DataOfBirth>"
    And I input to "addr" textbox or textarea with "notrandom" data "<Address>"
    And I input to "city" textbox or textarea with "notrandom" data "<City>"
    And I input to "state" textbox or textarea with "notrandom" data "<State>"
    And I input to "pinno" textbox or textarea with "notrandom" data "<Pin>"
    And I input to "telephoneno" textbox or textarea with "notrandom" data "<Phone>"
    And I input to "emailid" textbox or textarea with "random" data "<Email>"
    And I input to "password" textbox or textarea with "notrandom" data "<Password>"
    And I click to "Sub" button
    And Wait for some seconds "dynamic"
    And Verify message "Customer Registered Successfull!!!" displayed success
    And I get Customer ID at New Customer page
    And I open "Edit Customer" page
		And I open "Delete Customer" page
		And I open "Manager" page
		And I open "Deposit" page


     Examples: New Customer info
    |  Name |  DataOfBirth  |   Address |   City      |  State  |  Pin  |  Phone      |   Email  |  Password  | Message |
    | Auto Test| 1999-01-09 |123 Le Loi | Ho Chi Minh | Thu Duc |123456 | 094821455522| auto@gmail.com | 123456     | Customer Registered Successfull!!! |
 
    
    
    
    
    
    
    
