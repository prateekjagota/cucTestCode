@Sanity @NMenuItemNavigationTests
Feature: Test Menu Item Navigation Flow

  @Sanity @TC7
  Scenario: Clicking Menu Items
    Given "D1" I launch the application
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Groups" menuItem
    Then "D1" I tap on BackArrow button
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Loyalty points" menuItem
    Then "D1" I tap on BackArrow button
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Settings" menuItem
    Then "D1" I tap on BackArrow button
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Hybrid component WebView" menuItem
    Then "D1" I tap on BackArrow button
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Logout" menuItem
    Then "D1" I Navigate back
    
	@Sanity @TC8
  Scenario: Turn On Group Sharing
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Groups" menuItem
	  Then "D1" I enable Group Sharing
	  Then "D1" I wait for "2" seconds
	  Then "D1" I tap on BackArrow button
  
  @Sanity @TC9
  Scenario: Turn Off Group Sharing
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Groups" menuItem
	  Then "D1" I disable Group Sharing
	  Then "D1" I wait for "2" seconds
	  Then "D1" I tap on BackArrow button
  
  @Sanity @TC10
  Scenario: Get Loyalty points
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Loyalty points" menuItem
	  Then "D1" I wait for "2" seconds
	  Then "D1" Show "LoyalityPoints" text
	  Then "D1" I tap on BackArrow button
  
  @Sanity @TC11
  Scenario: Get Server URL with ScreenShot
	  Given "D1" I launch the application
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Settings" menuItem
	  Then "D1" I wait for "2" seconds
	  Then "D1" Show "ServerURL" text
	  Then "D1" Capture the ScreenShot
	  Then "D1" I tap on BackArrow button