#!/bin/bash
/$ANDROID_HOME/emulator/emulator -avd Nexus_5X_API_28 &
node ~/node_modules/appium/ &
node ~/node_modules/appium/ -p 4724 &
xcrun simctl boot DA6FAEF6-AE46-4793-8E48-C88F9013C3DE
open /Applications/Xcode.app/Contents/Developer/Applications/Simulator.app/ &
echo "Please wait for Android Emulator and iOS Simulator to boot up....."
SLEEP 300
