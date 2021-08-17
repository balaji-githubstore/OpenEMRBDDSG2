Feature: Login Feature
In order to maintain the health records 
As a openemr users
I want to login to the portal


Scenario: Invalid Credential
Given I have browser with openemr page
When I enter username as "admin123"
And I enter password as "pass"
And I select language as "English (Indian)"
And I click on login
Then I should get the error message as "Invalid username or password"





