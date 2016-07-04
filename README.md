# Android Gradle Java App Template 

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![TravisCI OSX Build](https://img.shields.io/travis/jaredsburrows/android-gradle-java-app-template/master.svg?label=OSX%20Build)](https://travis-ci.org/jaredsburrows/android-gradle-java-app-template)
[![CircleCI Linux Build](https://img.shields.io/circleci/project/jaredsburrows/android-gradle-java-app-template/master.svg?label=Linux%20Build)](https://circleci.com/gh/jaredsburrows/android-gradle-java-app-template)
[![AppVeyor Windows Build](https://img.shields.io/appveyor/ci/jaredsburrows/android-gradle-java-app-template/master.svg?label=Windows%20Build)](https://ci.appveyor.com/project/jaredsburrows/android-gradle-java-app-template/branch/master)
[![Coveralls Code Coverage](https://img.shields.io/coveralls/jaredsburrows/android-gradle-java-app-template/master.svg?label=Code%20Coverage)](https://coveralls.io/github/jaredsburrows/android-gradle-java-app-template?branch=master)

Gradle + Android Studio + Robolectric + Espresso + Mockito + EasyMock/PowerMock + JaCoCo

##### Works with the following Configurations:
 - Multiple Modules
 - Multiple Flavors
 - Android Libraries

## Technologies used:
#### Build Tools:
|Name|Description|
|---|---|
| [Gradle](http://gradle.org/docs/current/release-notes) | Gradle build system |
| [Android Gradle Build Tools](http://tools.android.com/tech-docs/new-build-system) | Official Gradle Plugin |
| [Android SDK](http://developer.android.com/tools/revisions/platforms.html#5.1) | Official SDK |
| [Android SDK Build Tools](http://developer.android.com/tools/revisions/build-tools.html) | Official Build Tools |
| [Android Studio](http://tools.android.com/recent) or | Official IDE |
| [Intellij](https://www.jetbrains.com/idea/download/) | Intellij IDE |

####Android Libraries:
|Name|Description|
|---|---|
| [Android Support-v4 ](http://developer.android.com/tools/support-library/features.html#v4) | Support Library API 4+|
| [Android AppCompat-v7](http://developer.android.com/tools/support-library/features.html#v7-appcompat) | Support Library API 7+|
| [Android Google Play Services](https://developer.android.com/google/play-services/index.html) | Admob, Analytics, etc

####Testing Frameworks:
|Name|Description|
|---|---|
| [JUnit](https://github.com/junit-team/junit) | Java Unit Testing Framework |
| [AssertJ](http://joel-costigliola.github.io/assertj/) | Matchers for Unit Tests |
| [Espresso](https://google.github.io/android-testing-support-library/) | Google's *New* Instrumentation Framework |
| [Robolectric](https://github.com/robolectric/robolectric) | Unit Testing Framework |
| [Mockito](https://github.com/mockito/mockito) | Mocking Framework |
| [EasyMock](https://github.com/easymock/easymock) | Mocking Framework |
| [PowerMock](https://github.com/jayway/powermock) | Mocking Framework(static method support) |

####Reporting Plugins:
|Name|Description|
|---|---|
| [JaCoCo](http://www.eclemma.org/jacoco/) | JaCoCo Test Coverage |
| [Coveralls](https://coveralls.io/) | Hosts test reports published from TravisCI |

####Continuous Integration:
|Name|Description|
|---|---|
| [TravisCI](http://docs.travis-ci.com/user/languages/android/) | Build Server(Builds, Tests, Publishes reports to Coveralls) |

####Publishing to Google Play:
|Name|Description|
|---|---|
| [Gradle-play-publisher](https://github.com/Triple-T/gradle-play-publisher) | Publishes your app to Google Play |

# Getting Started:

## `Android Studio` or `Intellij` Support(Simple):
 - **Import/Open this project with Android Studio/Intellij(click on `build.gradle`)**

 - **Instrumentation Tests:**
  - Change the Build Variant Test Artifact to `Instrumentation Tests` 
  - Right click an instrumentation test located in `src/main/androidTest` and click test

 - **Unit Tests:**
  - Change the Build Variant Test Artifact to `Unit Tests`
  - Right click a unit test located in `src/main/test` and click test

## Comand Line(Advanced):
##### Clone with `Git`:
 - `git clone https://github.com/jaredsburrows/android-gradle-java-app-template.git`
 - `cd AndroidGradleTemplate`

##### Installing/Running with `Gradle`:
 - **Install the `debug flavor` on your Android Device:**
   - `gradlew installDebug`
 - **Install and Run the `debug flavor` on your Android Device:**
   - `gradlew runDebug` 

##### Running Instrumentation/Espresso Tests with `Gradle`:
 - **Run all instrumentation tests in all `flavors`:**
   - `gradlew connectedAndroidTest`
 - **Run all instrumentation `debug flavor` tests:**
   - `gradlew connectedDebugAndroidTest`
 
##### Running Unit Tests with `Gradle`:
 - **Run all unit tests in all `flavors`:**
   - `gradlew test`
 - **Run a single unit test in all `flavors`:**
   - `gradlew test --tests="*MainActivityTest*"`
 - **Run all unit `debug flavor` tests:**
   - `gradlew testDebug`
 - **Run a single unit test in the `debug flavor`:**
   - `gradlew testDebug --tests="*MainActivityTest*"`
 - **Run a single unit test in the `debug flavor` with `Jacoco` test reports:**
   - `gradlew testDebug --tests="*MainActivityTest*" jacocoDebugReport`
