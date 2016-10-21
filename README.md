# Android Gradle Java App Template 

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![TravisCI OSX Build](https://img.shields.io/travis/jaredsburrows/android-gradle-java-app-template/master.svg?label=OSX%20Build)](https://travis-ci.org/jaredsburrows/android-gradle-java-app-template)
[![CircleCI Linux Build](https://img.shields.io/circleci/project/jaredsburrows/android-gradle-java-app-template/master.svg?label=Linux%20Build)](https://circleci.com/gh/jaredsburrows/android-gradle-java-app-template)
[![AppVeyor Windows Build](https://img.shields.io/appveyor/ci/jaredsburrows/android-gradle-java-app-template/master.svg?label=Windows%20Build)](https://ci.appveyor.com/project/jaredsburrows/android-gradle-java-app-template/branch/master)
[![Coveralls Code Coverage](https://img.shields.io/coveralls/jaredsburrows/android-gradle-java-app-template/master.svg?label=Code%20Coverage)](https://coveralls.io/github/jaredsburrows/android-gradle-java-app-template?branch=master)
[![Twitter Follow](https://img.shields.io/twitter/follow/jaredsburrows.svg?style=social)](https://twitter.com/jaredsburrows)

Gradle + Android Studio + Robolectric + Espresso + Mockito + EasyMock/PowerMock + JaCoCo

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

####Testing Frameworks:
|Name|Description|
|---|---|
| [Espresso](https://google.github.io/android-testing-support-library/) | Instrumentation Framework |
| [Robolectric](https://github.com/robolectric/robolectric) | Unit Testing Framework |

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

## Building and Running


This project builds with [Gradle](www.gradle.org) and the Android Build [tools](http://tools.android.com/tech-docs/new-build-system).


**Build the APK:**

    $ gradlew assembleDebug

**Install the APK:**

    $ gradlew installDebug

**Run the App:**

    $ gradlew runDebug

## Testing


**Running the Unit Tests:**


The [Junit](http://junit.org/junit4/) and [Robolectric](https://github.com/robolectric/robolectric) tests run on the JVM, no need for emulators or real devices.


    $ gradlew testDebug
    
**Run a single unit test in the `debug flavor`:**

    $ gradlew testDebug --tests="*MainActivityTest*"

    
**Running the Instrumentation Tests:**


The [Espresso](https://developer.android.com/training/testing/ui-testing/espresso-testing.html) instrumentation tests run on the device.

    $ gradlew connectedDebugAndroidTest
    

## Reports


**Generate Lint Reports:**


The [Lint](http://developer.android.com/tools/help/lint.html) plugin generates reports based off the source code.


    $ gradlew lintDebug


**Generate Jacoco Test Coverage:**


The [Jacoco](http://www.eclemma.org/jacoco/) plugin generates coverage reports based off the unit tests.


    $ gradlew jacocoDebugReport
