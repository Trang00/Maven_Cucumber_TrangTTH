@common
Feature: Common steps for web elements

 Scenario: Common steps for textbox/ textarea/link/radio/dropdow/...
 	#Link
    Given I open "dynamic" page     
    
  #Textbox
  	And  I input to "dynamic" textbox or textarea with "random" data "<email>"
  	And  I input to "dynamic" textbox or textarea with "notrandom" data "<city>"
  	
  #Radio button
    When I select "dynamic" radio button
    
   #Button
    And I click to "dynamic" button
     
   #Verify dynamic message
   	And Verify message "dynamic" displayed success
   	
   	#Dropdown List
   	And click to "dynamic" dropdown with value "dynamic"
   	
   	#Verify JS alert displayed and accept
   	And Verify alert meaasge "dynamic" displayed and accept
   	
   	#Wait some minutes/seconds
   	And Wait for some minutes "dynamic"
   		And Wait for some seconds "dynamic"