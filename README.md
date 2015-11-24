AndroidGradleTemplate [![Status](https://travis-ci.org/jaredsburrows/AndroidGradleTemplate.svg?branch=master)](https://travis-ci.org/jaredsburrows/AndroidGradleTemplate) [![Coverage Status](https://coveralls.io/repos/jaredsburrows/AndroidGradleTemplate/badge.svg?branch=master)](https://coveralls.io/r/jaredsburrows/AndroidGradleTemplate?branch=master)
=========
Gradle + Android Studio + Robolectric + Espresso + Mockito + EasyMock/PowerMock + JaCoCo

##### Works with the following Configurations:
 - Multiple Modules
 - Multiple Flavors
 - Android Libraries

<img src="images/test_and_dependencies.png" />

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
| [Hamcrest](https://github.com/hamcrest/JavaHamcrest) | Matchers for Unit Tests |
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
 - `git clone https://github.com/jaredsburrows/AndroidGradleTemplate.git`
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
   - `gradlew testDebug --tests="*MainActivityTest*" jacocoTestReport`

License
=========

    Copyright (C) 2015 AndroidGradleTemplate by Jared Burrows
   
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
