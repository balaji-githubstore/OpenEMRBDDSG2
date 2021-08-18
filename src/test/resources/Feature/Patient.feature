Feature: Patient
  In order to maintain the patient records
  As a admin
  I want to create,edit,delete patient records

  Scenario: Add Patient
    Given I have browser with openemr page
    When I enter username as "admin"
    And I enter password as "pass"
    And I select language as "English (Indian)"
    And I click on login
    And I mouseover on patient-client
    And I click on patients
    And I click on add new patients
    And I fill the patient details
      | firstname | lastname | dob        | gender |
      | John      | Paul     | 2021-08-18 | Male   |
    And I click on create new patient
    And I click on confirm create new patient
    And I handle the alert
    And I close the happy birthday popup
    Then I should get the alert message as "Assessment: Tobacco"
    And I should get the added patient detail as "Medical Record Dashboard - John Paul"
