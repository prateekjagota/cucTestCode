@Sanity @NavigationTest
Feature: Test Navigation Flow

  @Sanity @TC14
  Scenario: Add items from MarketPlace
    Given "D1" I launch the application
    Then "D1" I tap on "MARKETPLACE" text
    Then "D1" I swipe the Screen for "Unlimited Facebook 1 Day Pass" offer
    Then "D1" I tap on BuyCart button
    Then "D1" I tap on OK button
    Then "D1" I tap on DONE button

  @Sanity @TC15
  Scenario: Validate Offer on My Home Screen
    Then "D1" I tap on "MY PAGE" text
    Then "D1" I scroll down the screen for "Unlimited Facebook 1 Day Pass" text
    Then "D1" Verify "Unlimited Facebook 1 Day Pass" OfferStatus as "Active"
    
	@Sanity @TC16
  Scenario: Validate Offer purchase on Activity Screen
    Then "D1" I tap on "ACTIVITY" text
    Then "D1" Verify "Unlimited Facebook 1 Day Pass" ActivityStatus as "Purchased"