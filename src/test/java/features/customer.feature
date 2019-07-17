@login
Feature: Register and login
  As a PO
  I want to login to application
  so that verify login funtion work well

 Scenario: Register to application
    Given I open appliction
    And I get Login page Url
    And I click to here link
    And I input to email textbox with data "autorandom"
    And I click to Submit button at register page
    Then I get UserID infor
    And I get Password infor
    When I open Login page again
    And I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed with message "Webcome To Manager's Page of Guru99 Bank"
    
    Scenario Outline: Create New Customer
    Given I open Customer page
    When Input to New Customer form with data
    |  Name | Gender |  DataOfBirth  |   Address |   City |  State  |  Pin  |  Phone  |  Email  |  Password  |
    | <name>| m      | <DataOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to Submit button at New Customer page
    Then Verify message displayed with data "Message"
    And I verify all above infomation created success
    |  Name | Gender    |  DataOfBirth  |   Address |   City |  State  |  Pin  |  Phone  |  Email  |
    | <name>| male      | <DataOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
    When I get Customer ID at New Customer page
    
     Examples: New Customer info
    |  Name |  DataOfBirth  |   Address |   City      |  State  |  Pin  |  Phone      |   Email  |  Password  | Message |
    | Auto Test| 1999-01-09 |123 Le Loi | Ho Chi Minh | Thu Duc |123456 | 094821455522| autotest | 123456     | Customer Registered Successfull!!! |
    
    Scenario Outline: Edit Customer
    Given I open Edit Customer page
    And Input Customer ID to textbox
    And I click to Submit button at Edit Customer page
    And Input to Edit Customer form with data
   |   Address |   City |  State  |  Pin  |  Phone  |  Email  |
   | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
   And I click to Submit button at Edit Customer page
   Then Verify message displayed with data "Customer details updated Successfully!!!"
   And I veify all above infomation edited success
   |   Address |   City |  State  |  Pin  |  Phone  |  Email  |
   | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
    
     Examples: Edit Customer info
   |   Address      |   City |  State   |  Pin   |  Phone    |  Email  |
   |123 Edit Le Loi | Ha Noi | Van Phuc | 654321 | editemail |
    
    
    
    
    
    
    
    