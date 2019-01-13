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
   Given "D3" I enter text "rajbazar18@gmail.com" on web-"email" element
   Given "D3" I enter text "447884443278" on web-"imsi" element
   Given "D3" I enter text "447884443278" on web-"accessNum" element
   Given "D3" I select the web-"billingCycle"
   Then "D3" I web-wait for "2" seconds
   Given "D3" I enter text "Raj18" on web-"username" element
   Given "D3" I enter text "qqqqqqqq" on web-"password" element
   Given "D3" I click on web-"activate" element
   Then "D3" I web-wait for "2" seconds
   Given "D3" I close the browser
   

  @Sanity @TCB3 @Login
  Scenario: Login Test Case
    Given "D3" I click on web-"login" element
    Given "D3" I enter text "Raj18" on web-"username" element
    Given "D3" I enter text "qqqqqqqq" on web-"password" element
    Given "D3" I enter text "447884443278" on web-"accessNum" element
    Given "D3" I click on web-"login" element


  @Sanity @TCB4 @Logout
  Scenario: Logout Test Case
    Given "D3" I click on web-"showSettings" element
    Given "D3" I click on web-"logout" element
    Then "D3" I web-wait for "1" seconds
    Given "D3" I click on web-"okButton" element


   @CloseBrowser
   Scenario: Close Browser
      Then "D3" I web-wait for "2" seconds
      Given "D3" I close the browser
   
   
   
   