@patient
Feature: Patient
  In order to maintain the patient records
  As a admin
  I want to create,edit,delete patient records

  Scenario Outline: Add Patient
    Given I have "<browser>" browser with openemr page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I select language as "<language>"
    And I click on login
    And I mouseover on patient-client
    And I click on patients
    And I click on add new patients
    And I fill the patient details
      | firstname   | lastname   | dob   | gender   | externalid   |
      | <firstname> | <lastname> | <dob> | <gender> | <externalid> |
    And I click on create new patient
    And I click on confirm create new patient
    And I handle the alert
    And I close the happy birthday popup
    Then I should get the alert message as "<expectedalert>"
    And I should get the added patient detail as "<expectedpatientname>"

    Examples: 
      | browser | username | password | language         | firstname | lastname | dob        | gender | externalid | expectedalert       | expectedpatientname                   |
      | ff      | admin    | pass     | English (Indian) | John      | Paul     | 2021-08-18 | Male   |        123 | Assessment: Tobacco | Medical Record Dashboard - John Paul  |
      | ch      | admin    | pass     | English (Indian) | Peter     | Hein     | 2021-08-15 | Male   |        245 | Assessment: Tobacco | Medical Record Dashboard - Peter Hein |
