@Sanity @NavigationTest
Feature: Test Navigation Flow

  @Sanity @TCB21
  Scenario: Login for Market
    Given "D3" I launch the application
    Given "D3" I click on web-"login" element
    Given "D3" I enter text "Raj19" on web-"username" element
    Given "D3" I enter text "qqqqqqqq" on web-"password" element
    Given "D3" I enter text "447884443279" on web-"accessNum" element
    Given "D3" I click on web-"login" element
    
  @Sanity @TCB22
  Scenario: Activate services
   Given "D3" I web-wait for "2" seconds
   Given "D3" I click on web-"label_catalog" element
   Then "D3" I scroll to web-"SA_SIM_ACTIVATE" text
   Given "D3" I click on web-"SA_SIM_ACTIVATE" text
   Given "D3" I click on web-"purchaseOffer" element
   Then "D3" I web-wait for "1" seconds
   Then "D3" I click on web-"okButton" element
   Then "D3" I click on web-"label_home" element
   
  
 @Sanity @TCB23
 Scenario: Add prepaid balance
  Given "D3" I click on web-"label_wallet" element
  Then "D3" I click on web-"balName_1" element
  Then "D3" I click on web-"recharge" element
  Then "D3" I web-wait for "1" seconds
  Then "D3" I add web-amount as "50"
  Then "D3" I web-wait for "1" seconds  
  Then "D3" I click on web-"rechargeButton" element
  Then "D3" I click on web-"label_home" element


  @Sanity @TCB24
  Scenario: Activate services
   Given "D3" I web-wait for "2" seconds
   Given "D3" I click on web-"label_catalog" element
   Then "D3" I scroll to web-"UPAB_D_1DFB" text
   Given "D3" I click on web-"UPAB_D_1DFB" text
   Given "D3" I click on web-"purchaseOffer" element
   Then "D3" I web-wait for "1" seconds
   Then "D3" I click on web-"okButton" element
   Then "D3" I click on web-"label_home" element


   @Sanity @TCB25
  Scenario: Activate services
   Given "D3" I web-wait for "2" seconds
   Given "D3" I click on web-"label_catalog" element
   Then "D3" I scroll to web-"UPAB_D_1DINST" text
   Given "D3" I click on web-"UPAB_D_1DINST" text
   Given "D3" I click on web-"purchaseOffer" element
   Then "D3" I web-wait for "1" seconds
   Then "D3" I click on web-"okButton" element
   Then "D3" I click on web-"label_home" element

 
 @Sanity @TCB26
  Scenario: De-Activate services
   Given "D3" I click on web-"label_home" element
   Then "D3" I scroll to web-"UPAB_D_1DFB" text
   Then "D3" I web-wait for "1" seconds
   Then "D3" I click on web-"UPAB_D_1DFB" text
   Then "D3" I click on web-"deactivateOffer" element
   Then "D3" I click on web-"okButton" element
  