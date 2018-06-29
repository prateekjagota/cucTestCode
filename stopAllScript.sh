#!/bin/bash
$ANDROID_HOME/platform-tools/adb emu kill
pkill -f emulator
xcrun simctl shutdown DA6FAEF6-AE46-4793-8E48-C88F9013C3DE
pkill -f Simulator.app
pkill -f appium
