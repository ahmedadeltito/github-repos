fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android assemble_build
```
fastlane android assemble_build
```
Assemble Build
### android assemble_test_application
```
fastlane android assemble_test_application
```
Assemble Test Application
### android assemble
```
fastlane android assemble
```
Assemble Build and Test Application
### android unit_tests
```
fastlane android unit_tests
```
Run unit tests
### android instrumentation_tests
```
fastlane android instrumentation_tests
```
Run instrumentation tests
### android deploy_to_crashlytics
```
fastlane android deploy_to_crashlytics
```
Submit a new Beta Build to Crashlytics
### android slack_message
```
fastlane android slack_message
```
Create a Slack Message
### android deploy_to_play_store
```
fastlane android deploy_to_play_store
```
Deploy a new version to the Google Play

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
