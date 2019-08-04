@Sanity @NavigationTest
Feature: Test Navigation Flow

  @Sanity @TC1
  Scenario: Installation
    Given "D1" I install and launch the application
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on agreement checkBox
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on agree continue button

@Sanity @TC1Provision
  Scenario: Installation and Provisioning
    Given "D1" I install and launch the application
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on iSettings button
    Then "D1" I tap on "User provision" text
    Then "D1" I enter-"ProVisionUserFirstName" as "Raj"
    Then "D1" I enter-"ProVisionUserLastName" as "Bazar"
    Then "D1" I enter-"ProVisionUserPhoneNumber" as "447884443373"
    Then "D1" I enter-"ProVisionUserEmail" as "raj.bazar@matrixx.com"
    Then "D1" I tap on "TimeZone" spinner
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "America" CheckedText
    Then "D1" I tap on "BillCycle" spinner
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "300" CheckedText
    Then "D1" I tap on "SelectOffer" spinner
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "SA_SIM_ACTIVATE" CheckedText
    Then "D1" I tap on "PaymentType" spinner
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "CREDIT" CheckedText
    Then "D1" I enter-"ProVisionUserAccessNumber" as "447884443373" 
    Then "D1" I scroll down the screen for "IMSI" text
    Then "D1" I enter-"ProVisionUserImsi" as "447884443373" 
    Then "D1" I tap on BigTick button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on PROVISION button

 @Sanity @TC1Deprovision
  Scenario: Installation and De-Provisioning
    Given "D1" I install and launch the application
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on iSettings button
    Then "D1" I tap on "De-provision a user" text
    Then "D1" I enter-"DeProvisionNumber" as "447884443373"
    Then "D1" I tap on BigTick button
    Then "D1" I tap on DEPROVISION button

 @Sanity @TC1001
  Scenario: Installation
    Given "D2" I install and launch the application
    Then "D2" I tap on agreement checkBox
    Then "D2" I tap on agree continue button
    
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
    Then "D1" I wait for "2" seconds
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
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "VOUCHER" text
    Then "D1" I tap on TopUp button
    Then "D1" I enter the "voucherNumber"
    Then "D1" I tap on VoucherTopUp button
    Then "D1" I tap on PayAndActivate button
    Then "D1" I tap on GoToMyPage button 
    Then "D1" I wait for "5" seconds 

@Sanity @TC3a
  Scenario: Sign Up Flow with adding BaseTarrif and Offer
    Then "D1" I tap on signUp button
    Then "D1" I swipe the Screens
    Then "D1" I tap on GetStarted button
    Then "D1" I wait for "2" seconds
    Then "D1" I set "DATA" tarrif on signUp as "2GB"
    Then "D1" I set "VOICE" tarrif on signUp as "300"
    Then "D1" I set "SMS" tarrif on signUp as "500"
    Then "D1" I tap on BigTick button
    Then "D1" I tap on tellUsMore button
    Then "D1" I tap on signUpYes button
    Then "D1" I tap on signUpNo button
    Then "D1" I tap on signUpYes button
    Then "D1" I wait for "2" seconds
    Then "D1" I swipe the PromoScreen for "Crystal clear voice quality." offer  
    Then "D1" I tap on addOffer button
    Then "D1" I tap on ContinueActivation button
    Then "D1" I enter the "phoneSignUpNumber"
    Then "D1" I tap on Next button
    Then "D1" I enter the "validationCode"
    Then "D1" I tap on Next button
    Then "D1" I enter the "userName"
    Then "D1" I enter the "userPassword"
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on ConFirm button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "VOUCHER" text
    Then "D1" I tap on TopUp button
    Then "D1" I enter the "voucherNumber"
    Then "D1" I tap on VoucherTopUp button
    Then "D1" I tap on PayAndActivate button
    Then "D1" I tap on GoToMyPage button 
    Then "D1" I wait for "5" seconds 

@Sanity @TC1003
  Scenario: Sign Up Flow
    Then "D2" I tap on signUp button
    Then "D2" I swipe the Screens
    Then "D2" I tap on GetStarted button
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "CONTINUE" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "JUMP TO ACTIVATION" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "ACTIVATE YOUR ACCOUNT" text
    Then "D2" I wait for "2" seconds
    Then "D2" I enter the "userName"
    Then "D2" I enter the "userPassword"
    Then "D2" I wait for "2" seconds
    Then "D2" I enter the "iOSphoneSignUpNumber"
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "SEND" text
    Then "D2" I wait for "2" seconds
    Then "D2" I enter the "iOSOTP"
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "CONTINUE" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "VOUCHER" option
    Then "D2" I tap on "topup" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on VoucherArrow button
    Then "D2" I enter the "voucherNumber"
    Then "D2" I tap on "done" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "topup" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "goToMyPage" text
    Then "D2" I wait for "2" seconds

@Sanity @TC1003a
  Scenario: Sign Up Flow with banking information
    Then "D2" I tap on signUp button
    Then "D2" I swipe the Screens
    Then "D2" I tap on GetStarted button
    Then "D2" I wait for "2" seconds
    Then "D2" I select all unlimited options
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "CONTINUE" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "JUMP TO ACTIVATION" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "ACTIVATE YOUR ACCOUNT" text
    Then "D2" I wait for "2" seconds
    Then "D2" I enter the "userName"
    Then "D2" I enter the "userPassword"
    Then "D2" I wait for "2" seconds
    Then "D2" I enter the "iOSphoneSignUpNumber"
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "SEND" text
    Then "D2" I wait for "2" seconds
    Then "D2" I enter the "iOSOTP"
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "CONTINUE" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "BANK ACCOUNT" option
    Then "D2" I enter-"bFirstName" as "Raj"
    Then "D2" I enter-"bLastName" as "Bazar"
    Then "D2" I enter-"bBankName" as "Barclays-012345"
    Then "D2" I enter-"bBankNumber" as "4455667788"
    Then "D2" I enter-"bAccountNumber" as "012345678912"
    Then "D2" I enter-"bDOB" as "01 01 2001"
    Then "D2" I tap on "Done" text
    Then "D2" I wait for "2" seconds
    Then "D2" I scroll down the screen for "SAVE" text
    Then "D2" I tap on "SAVE" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "BILLS TO MY ACCOUNT" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "goToMyPage" text
    Then "D2" I wait for "4" seconds

  @Sanity @TC4
  Scenario: Logout without Reprovisioning
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Logout" menuItem
    Then "D1" I tap on LOGOUT button
    
  @Sanity @TC1004
  Scenario: Logout without Reprovisioning
  	Then "D2" I wait for "2" seconds
    Then "D2" I tap on MoreMenu button
    Then "D2" I tap on LOGOUT button
    Then "D2" I wait for "2" seconds 
  

  @Sanity @TC5
  Scenario: Sign In Flow
   Given "D1" I launch the application
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on signIn button   
    Then "D1" I wait for "2" seconds
    Then "D1" I enter the "phoneLoginNumber"
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on login button
    Then "D1" I wait for "10" seconds
    Then "D1" I tap on "MY PAGE" text

  @Sanity @TC88
  Scenario: Logout without Reprovisioning
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Logout" menuItem
    Then "D1" I tap on LOGOUT button
    
	@Sanity @TC1005
  Scenario: Sign In Flow
  	Given "D2" I launch the application
    Then "D2" I tap on "signin" text
    Then "D2" I tap on "signinWPhone" text
    Then "D2" I wait for "2" seconds
    Then "D2" I enter the "iOSloginMobileNumber"
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "positiveButton" text
    Then "D2" I wait for "20" seconds
    Then "D2" I tap on "OK" text
    
 @Sanity @TC6
  Scenario: Add balance from card
  	Then "D1" I tap on "WALLET" text
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Pre-paid balance" text
    Then "D1" I tap on CreditTopUp button
    Then "D1" I tap on "CREDIT CARD" text
  	Then "D1" I enter the "creditCardNumber"
  	Then "D1" I enter the "creditCardExpMM"
  	Then "D1" I enter the "creditCardExpYY"
  	Then "D1" I enter the "creditCardCVV"
  	Then "D1" I tap on SaveTopUp button
  	Then "D1" I Navigate back
    Then "D1" I wait for "2" seconds
  	Then "D1" I tap on "MY PAGE" text
  	
 @Sanity @TC1006
  Scenario: Add balance from card
  	Given "D2" I launch the application
  	Then "D2" I wait for "2" seconds
  	Then "D2" I tap on "WALLET" text
  	Then "D2" I wait for "2" seconds
  	Then "D2" I tap on CreditArrow1 button
  	Then "D2" I wait for "2" seconds
    Then "D2" I tap on "TOP UP" text
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on CreditArrow2 button
    Then "D2" I enter the "creditCardNumber"
  	Then "D2" I enter the "creditCardExpMM"
  	Then "D2" I enter the "creditCardExpYY"
  	Then "D2" I enter the "creditCardCVV"
  	Then "D2" I tap on CreditArrow2 button
  	Then "D2" I wait for "2" seconds
  	Then "D2" I tap on CreditArrow2 button
  	Then "D2" I wait for "2" seconds
  	Then "D2" I tap on "amountButton" text
  	Then "D2" I wait for "2" seconds
  	Then "D2" I enter the "addAmount"
  	Then "D2" I tap on "TOP UP" text
  	Then "D2" I wait for "5" seconds
  	Then "D2" I tap on "MY PAGE" text
  	
    
  	
  @Sanity @TC7
  Scenario: Logout with Reprovisioning  
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Logout" menuItem
    Then "D1" I tap on reProvision checkBox
    Then "D1" I tap on LOGOUT button
    
  @Sanity @TC1007
  Scenario: Logout with Reprovisioning
  	Then "D2" I wait for "2" seconds
    Then "D2" I tap on MoreMenu button
    Then "D2" I tap on ReprovisionUser button
    Then "D2" I wait for "3" seconds 

