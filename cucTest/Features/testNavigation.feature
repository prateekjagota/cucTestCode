@Sanity @NavigationTest
Feature: Test Navigation Flow

  @Sanity @TC1
  Scenario: Installation
    Given "D1" I install and launch the application
    Then "D1" I tap on agreement checkBox
    Then "D1" I tap on agree continue button

	@Sanity @TC2
	Scenario: Change the Server URL
		Then "D1" I tap on iSettings button
		Then "D1" I wait for "2" seconds
    Then "D1" I tap on "ServerURL" text
    Then "D1" I tap on "Custom" text
    Then "D1" I wait for "2" seconds
    Then "D1" I enter the "setServerURL"
    Then "D1" I tap on OK button


  @Sanity @TC3
  Scenario: Sign Up Flow
    Then "D1" I tap on signUp button
    Then "D1" I swipe the Screens
    Then "D1" I tap on GetStarted button
    Then "D1" I tap on BigTick button
    Then "D1" I tap on ContinueActivation button
    Then "D1" I enter the "phoneSignUpNumber"
    Then "D1" I tap on Next button
    Then "D1" I enter the "validationCode"
    Then "D1" I tap on Next button
    Then "D1" I enter the "userName"
    Then "D1" I enter the "userPassword"
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on ConFirm button
    Then "D1" I tap on "VOUCHER" text
    Then "D1" I tap on TopUp button
    Then "D1" I enter the "voucherNumber"
    Then "D1" I tap on VoucherTopUp button
    Then "D1" I tap on PayAndActivate button
    Then "D1" I tap on GoToMyPage button  


  @Sanity @TC4
  Scenario: Logout without Reprovisioning
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Logout" menuItem
    Then "D1" I tap on LOGOUT button

  @Sanity @TC5
  Scenario: Sign In Flow
  	Given "D1" I launch the application
    Then "D1" I tap on signIn button
    Then "D1" I wait for "2" seconds
    Then "D1" I enter the "phoneLoginNumber"
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on login button
    
 @Sanity @TC6
  Scenario: Add balance from card
  	Then "D1" I tap on "WALLET" text
    Then "D1" I tap on "Pre-paid balance" text
    Then "D1" I tap on CreditTopUp button
    Then "D1" I tap on "CREDIT CARD" text
  	Then "D1" I enter the "creditCardNumber"
  	Then "D1" I enter the "creditCardExpMM"
  	Then "D1" I enter the "creditCardExpYY"
  	Then "D1" I enter the "creditCardCVV"
  	Then "D1" I tap on SaveTopUp button
  	Then "D1" I Navigate back
  	Then "D1" I Navigate back
  	Then "D1" I tap on "MY PAGE" text
  	
  	
  @Sanity @TC7
  Scenario: Logout with Reprovisioning  
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Logout" menuItem
    Then "D1" I tap on reProvision checkBox
    Then "D1" I tap on LOGOUT button


