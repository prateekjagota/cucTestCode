@Sanity @NMenuItemNavigationTests
Feature: Test Menu Item Navigation Flow

  @Sanity @TC8
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
    
	@Sanity @TC9
  Scenario: Turn On Group Sharing
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Groups" menuItem
	  Then "D1" I enable Group Sharing
	  Then "D1" I wait for "2" seconds
	  Then "D1" I tap on BackArrow button
  
  @Sanity @TC10
  Scenario: Turn Off Group Sharing
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Groups" menuItem
	  Then "D1" I disable Group Sharing
	  Then "D1" I wait for "2" seconds
	  Then "D1" I tap on BackArrow button
  
  @Sanity @TC11
  Scenario: Get Loyalty points
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Loyalty points" menuItem
	  Then "D1" I wait for "2" seconds
	  Then "D1" Show "LoyalityPoints" text
	  Then "D1" I tap on BackArrow button
  
  @Sanity @TC12
  Scenario: Get Server URL with ScreenShot
	  Then "D1" I tap on LeftMenu button
	  Then "D1" I tap on "Settings" menuItem
	  Then "D1" I wait for "2" seconds
	  Then "D1" Show "ServerURL" text
	  Then "D1" Capture the ScreenShot
	  Then "D1" I tap on BackArrow button

	@Sanity @TC13
  Scenario: Change the Server URL from Settings
    Then "D1" I tap on LeftMenu button
    Then "D1" I tap on "Settings" menuItem
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "ServerURL" text
    Then "D1" I tap on "Custom" text
    Then "D1" I wait for "2" seconds
    Then "D1" I enter the "setServerURL"
    Then "D1" I tap on OK button
    Then "D1" I tap on signIn button
    Then "D1" I wait for "2" seconds
    Then "D1" I enter the "phoneLoginNumber"
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on login button

