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
    Then Verify Home page displayed with messge "Webcome To Manager's Page of Guru99 Bank"
