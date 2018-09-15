@Sanity @NavigationTest
Feature: Test Navigation Flow

  @Sanity @TC1
  Scenario: Installation
    Given "D1" I install and launch the application

  @Sanity @TC1001
  Scenario: Installation
    Given "D2" I install and launch the application


  @Sanity @TC2
  Scenario: Sign Up Flow
  Given "D1" I launch the application
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on REGISTER button
    Then "D1" I enter the "userName"
    Then "D1" I enter the "userSurName"
    Then "D1" I enter the "userEmail"
    Then "D1" I enter the "imsi"
    Then "D1" I enter the "phoneSignUpNumber"
    Then "D1" I enter the "billCycle"
    Then "D1" I enter the "accessUserName"
    Then "D1" I enter the "accessPassword"
    Then "D1" I tap on ACTIVATE SUBSCRIBER button

  @Sanity @TC1002
  Scenario: Sign Up Flow
  Given "D2" I launch the application
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "Register" text
    Then "D2" I enter the "userName"
    Then "D2" I enter the "userSurName"
    Then "D2" I enter the "userEmail"
    Then "D2" I enter the "imsi"
    Then "D2" I enter the "iOSphoneSignUpNumber"
    Then "D2" I enter the "billCycle"
    Then "D2" I enter the "accessUserName"
    Then "D2" I tap on "Phone number:" text
    Then "D2" I enter the "accessPassword"
    Then "D2" I tap on "Phone number:" text
    Then "D2" I tap on "Activate Subscriber" text
    

  @Sanity @TC3
  Scenario: Logout without Reprovisioning
    Given "D1" I launch the application
    Then "D1" I wait for "5" seconds
    #Then "D1" I tap on "HOME" text
    Then "D1" I tap on RightMenu button
    Then "D1" I tap on "Logout" text
    

  @Sanity @TC1003
  Scenario: Logout without Reprovisioning
    Given "D2" I launch the application
    Then "D2" I wait for "5" seconds
    Then "D2" I tap on "Settings" text
    Then "D2" I tap on "Logout" text
    Then "D2" I wait for "3" seconds
    Then "D2" I tap on popUpLogout button
  

  @Sanity @TC4
  Scenario: Sign In Flow
  	Given "D1" I launch the application
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on login button
    Then "D1" I enter the "accessUserName"
    Then "D1" I enter the "accessPassword"
    Then "D1" I enter the "phoneSignUpNumber"
    Then "D1" I tap on LOGIN SUBSCRIBER button


    
	@Sanity @TC1004
  Scenario: Sign In Flow
  	Given "D2" I launch the application
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "Login" text
    Then "D2" I enter the "accessUserName"
    Then "D2" I enter the "accessPassword"
    Then "D2" I enter the "iOSphoneSignUpNumber"
    Then "D2" I tap on LOGIN SUBSCRIBER button


  @Sanity @TC1005  
  Scenario: Logout with re-provisioning
    Given "D2" I launch the application
    Then "D2" I wait for "5" seconds
    Then "D2" I tap on "Settings" text
    Then "D2" I tap on "Delete Subscriber" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "Delete" text
    
