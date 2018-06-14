@Sanity @MarketPlaceTest
Feature: Test MarketPlace Scenarios

  @Sanity @TC14
  Scenario: Add items from MarketPlace
    Given "D1" I launch the application
    Then "D1" I tap on "MARKETPLACE" text
    Then "D1" I swipe the Screen for "Unlimited Facebook 1 Day Pass" offer
    Then "D1" I tap on BuyCart button
    Then "D1" I tap on OK button
    Then "D1" I tap on DONE button
    
  @Sanity @TC10014
  Scenario: Add items from MarketPlace
    Given "D2" I launch the application
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "MARKETPLACE" text
    Then "D2" I swipe the Screen for "Unlimited Facebook 1 Day Pass" offer
    Then "D2" I wait for "1" seconds
    Then "D2" I tap on "BUY NOW" text


  @Sanity @TC15
  Scenario: Validate Offer on My Home Screen
    Then "D1" I tap on "MY PAGE" text
    Then "D1" I scroll down the screen for "Unlimited Facebook 1 Day Pass" text
    Then "D1" Verify "Unlimited Facebook 1 Day Pass" OfferStatus as "Active"
    
 @Sanity @TC10015
  Scenario: Validate Offer on My Home Screen
  	Given "D2" I launch the application
    Then "D2" I wait for "2" seconds
    Then "D2" I tap on "MY PAGE" text
    Then "D2" I scroll down the screen for "Unlimited Facebook 1 Day Pass" text
    Then "D2" Verify "Unlimited Facebook 1 Day Pass" OfferStatus as "Active"
    
	@Sanity @TC16
  Scenario: Validate Offer purchase on Activity Screen
    Then "D1" I tap on "ACTIVITY" text
    Then "D1" Verify "Unlimited Facebook 1 Day Pass" ActivityStatus as "Purchased"
    
  @Sanity @TC17
   Scenario: Purchase products from marketplace
   Then "D1" I tap on "MARKETPLACE" text
   Then "D1" I tap on Search button
   Then "D1" I search and select product as "Powerbeats3 Wireless Earphones"
   Then "D1" I tap on BuyCart button
   Then "D1" I enter-"Contact FullName" as "Raj Bazar"
   Then "D1" I enter-"Contact Email" as "raj.bazar@matrixx.com"
   Then "D1" I enter-"Contact Number" as "447884443373"
   Then "D1" I enter-"Shipping FullName" as "Raj Bazar"
   Then "D1" I enter-"Shipping Address1" as "18809 Cox Ave"
   Then "D1" I enter-"Shipping Address2" as ""
   Then "D1" I scroll down the screen for "Phone Number" text
   Then "D1" I enter-"Shipping City" as "Saratoga"
   Then "D1" I enter-"Shipping Region" as "USA"
   Then "D1" I enter-"Shipping ZIP" as "CA 95070"
   Then "D1" I enter-"Shipping PhoneNumber" as "447884443373"
   Then "D1" I tap on Arrow button
   Then "D1" I tap on Arrow button
   Then "D1" I select DeliveryType as "UberRUSH"
   Then "D1" I tap on Tick button
   Then "D1" I tap on OK button
   