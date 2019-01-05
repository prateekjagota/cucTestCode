@Sanity @NavigationTest
Feature: Test Navigation Flow

  @Sanity @TCB1
  Scenario: Initial Launch
    Given "D3" I launch the application
    
  @Sanity @TCB2
  Scenario: Registration
   Given "D3" I click on web-"register" element
   Given "D3" I enter text "Raj" on web-"firstName" element
   Given "D3" I enter text "Bazar" on web-"lastName" element
   Given "D3" I enter text "raj.bazar@matrixx.com" on web-"email" element
   Given "D3" I enter text "447500977574" on web-"imsi" element
   Given "D3" I enter text "447500977574" on web-"accessNum" element
   Given "D3" I select the web-"billingCycle"
   Given "D3" I enter text "Rajb" on web-"username" element
   Given "D3" I enter text "qqqqqq" on web-"password" element
   Given "D3" I click on web-"activate" element
   
   
   
   
   