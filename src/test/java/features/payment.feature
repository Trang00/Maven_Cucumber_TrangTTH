@Payment
Feature: Payment

  @registerApplication
  Scenario: register/ Login to application and Create New Customer
    Given I get Login page Url
    And I click to here link
    And I input to "emailid" textbox or textarea with "random" data "XAnh@gmail.com"
    And I click to "btnLogin" button
    Then I get UserID infor
    And I get Password infor


  @loginApplication
  Scenario: Login to application
    Given I open Login page again
    And I input to Username textbox
    And I input to Password textbox
    And I click to "btnLogin" button
    Then Verify Home page displayed

  @TC01_NewCustomer
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
    And I click to "sub" button
    And Wait for some seconds "3"
    And Verify message "Customer Registered Successfully!!!" displayed success
    And I get Customer ID at New Customer page

    Examples: New Customer info
      | Name      | DataOfBirth | Address    | City        | State   | Pin    | Phone        | Email          | Password | Message                            |
      | Auto Test | 1999-01-09  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 094821455522 | auto@gmail.com |   123456 | Customer Registered Successfull!!! |

  @TC02_EditCustomer
  Scenario Outline: Edit Customer
    Given I open "Edit Customer" page
    And I input to Customer ID textbox
    And I click to "AccSubmit" button
    And I input to "addr" textbox or textarea with "notrandom" data "<Address>"
    And I input to "city" textbox or textarea with "notrandom" data "<City>"
    And I input to "state" textbox or textarea with "notrandom" data "<State>"
    And I input to "pinno" textbox or textarea with "notrandom" data "<Pin>"
    And I input to "telephoneno" textbox or textarea with "notrandom" data "<Phone>"
    And I input to "emailid" textbox or textarea with "random" data "<Email>"
    And I click to "sub" button
    And Wait for some seconds "3"
    And Verify message "Customer details updated Successfully!!!" displayed success

    Examples: Edit Customer info
      | Address         | City   | State    | Pin    | Phone       | Email               |
      | 123 Edit Le Loi | Ha Noi | Van Phuc | 654321 | 09888888888 | editemail@gmail.com |

  @TC03_NewAccount
  Scenario Outline: New Account
    Given I open "New Account" page
		And I input to Customer ID textbox
    And click to "Current" dropdown with value "selaccount"
    And I input to "inideposit" textbox or textarea with "notrandom" data "<Inideposit>"
    And I click to "button2" button
    And Verify message "Account Generated Successfully!!!" displayed success
    And I get Account ID at New Account page
    And I get text to "Current Amount" displayed

    Examples: New Account info
      | Inideposit |
      |      50000 |

 @TC04_EditAccount
  Scenario Outline: Edit Account
    Given I open "Edit Account" page
    And I input to Account ID textbox
    And I click to "button2" button
    And Verify message "Account Generated Successfully!!!" displayed success
    
 @TC05_TransferAndCheck_Deposit
  Scenario Outline: Deposit
    Given I open "Deposit" page
    And I input to Account ID textbox in Deposit
    And I input to "ammount" textbox or textarea with "notrandom" data "<Ammount>"
    And I input to "desc" textbox or textarea with "notrandom" data "<Discription>"
    And I click to "AccSubmit" button
    And Verify message Transaction Successfully displayed success
    And Verify current Amount "<CurrentBalance>"
     Examples: New Account info
      | Ammount | Discription |CurrentBalance|
      |    5000 |    Deposit  |55000|
      
  @TC_06_WithdrawalAndCheck
  Scenario Outline: Withdrawal
    Given I open "Withdrawal" page
    And I input to "accountno" textbox or textarea with "notrandom" data "<NewAccountPageSteps.AccountID>"
    And I input to "ammount" textbox or textarea with "notrandom" data "<Ammount>"
    And I input to "desc" textbox or textarea with "notrandom" data "<Discription>"
    And I click to "AccSubmit" button
   
    And Verify message Transaction Withdrawal Successfully displayed success
    And Verify current Amount "<CurrentBalance>"
     Examples: New Account info
      | Ammount | Discription |CurrentBalance|
      |    15000 |    Withdrawal  |40000|
      