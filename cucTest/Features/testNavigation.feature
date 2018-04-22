@Sanity @NavigationTest
Feature: Test Navigation Flow

	@Sanity @TC1
  Scenario: Installation
  Given "D1" I install and launch the application
  Then "D1" I tap on agreement checkBox
  Then "D1" I tap on agree continue button
  
  @Sanity @TC2
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
   	Then "D1" I select "VOUCHER" text
   	Then "D1" I tap on TopUp button
   	Then "D1" I enter the "voucherNumber"
   	Then "D1" I tap on VoucherTopUp button
   	Then "D1" I tap on PayAndActivate button
		Then "D1" I tap on GoToMyPage button
    
  
  @Sanity @TC3
  Scenario: Logout without Reprovisioning
  	Then "D1" I tap on LeftMenu button
  	Then "D1" I tap on "Logout" menuItem
  	Then "D1" I tap on LOGOUT button
  
  
  @Sanity @TC4
  Scenario: Sign In Flow
    Then "D1" I tap on signIn button
    Then "D1" I wait for "2" seconds
    Then "D1" I enter the "phoneLoginNumber"
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on login button
    
    
  @Sanity @TC5
  Scenario: Logout with Reprovisioning
  	Then "D1" I tap on LeftMenu button
  	Then "D1" I tap on "Logout" menuItem
  	Then "D1" I tap on reProvision checkBox
  	Then "D1" I tap on LOGOUT button