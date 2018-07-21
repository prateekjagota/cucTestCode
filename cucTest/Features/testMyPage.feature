@Sanity @MyPageTest
Feature: Test MyPage Scenarios

  @Sanity @TC31
  Scenario: Adjust Base Tariff Data
    Given "D1" I launch the application
    Then "D1" I wait for "5" seconds
    Then "D1" I tap on "MY PAGE" text
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Adjust" text
    Then "D1" I wait for "2" seconds
    Then "D1" I set "DATA" tarrif as "2048"
    Then "D1" I tap on Tick button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on ADJUST button
    Then "D1" I wait for "5" seconds


@Sanity @TC32
  Scenario: Adjust Base Tariff Voice
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Adjust" text
    Then "D1" I wait for "2" seconds
    Then "D1" I set "VOICE" tarrif as "500"
    Then "D1" I tap on Tick button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on ADJUST button
    Then "D1" I wait for "5" seconds


@Sanity @TC33
  Scenario: Adjust Base Tariff SMS
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Adjust" text
    Then "D1" I wait for "2" seconds
    Then "D1" I set "SMS" tarrif as "300"
    Then "D1" I tap on Tick button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on ADJUST button
    Then "D1" I wait for "5" seconds


@Sanity @TC34
  Scenario: Top Up for Data
    Given "D1" I launch the application
    Then "D1" I wait for "3" seconds
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Top Up" text
    Then "D1" I wait for "2" seconds
    Then "D1" I set "DATA" topUp as "100"
    Then "D1" I tap on Tick button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on TOPUP button
    Then "D1" I wait for "5" seconds

@Sanity @TC35
  Scenario: Top Up for Voice
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Top Up" text
    Then "D1" I wait for "2" seconds
    Then "D1" I set "VOICE" topUp as "100"
    Then "D1" I tap on Tick button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on TOPUP button
    Then "D1" I wait for "5" seconds


@Sanity @TC36
  Scenario: Top Up for SMS
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Top Up" text
    Then "D1" I wait for "2" seconds
    Then "D1" I set "SMS" topUp as "100"
    Then "D1" I tap on Tick button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on TOPUP button
    Then "D1" I wait for "5" seconds
    

@Sanity @TC37
  Scenario: Set Data Usage Alert
    Given "D1" I launch the application
    Then "D1" I wait for "5" seconds
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Notifications" text
    Then "D1" I wait for "2" seconds
    Then "D1" I scroll down Activity screen for "SMS used" text
    Then "D1" I set "DATA" usageAlert as "35"
    Then "D1" I scroll down Activity screen for "Customize your Notifications" text
    Then "D1" I tap on BackArrow button
    Then "D1" I wait for "5" seconds

@Sanity @TC38
  Scenario: Set Voice Usage Alert
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Notifications" text
    Then "D1" I wait for "2" seconds
    Then "D1" I scroll down Activity screen for "SMS used" text
    Then "D1" I set "VOICE" usageAlert as "55"
    Then "D1" I scroll down Activity screen for "Customize your Notifications" text
    Then "D1" I tap on BackArrow button
    Then "D1" I wait for "5" seconds


@Sanity @TC39
  Scenario: Set SMS Usage Alert
    Then "D1" I tap on 3Dots button
    Then "D1" I wait for "2" seconds
    Then "D1" I tap on "Notifications" text
    Then "D1" I wait for "2" seconds
    Then "D1" I scroll down Activity screen for "SMS used" text
    Then "D1" I set "SMS" usageAlert as "75"
    Then "D1" I scroll down Activity screen for "Customize your Notifications" text
    Then "D1" I tap on BackArrow button
    Then "D1" I wait for "5" seconds