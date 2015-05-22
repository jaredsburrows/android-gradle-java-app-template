AndroidGradleTemplate [![Status](https://travis-ci.org/jaredsburrows/AndroidGradleTemplate.svg?branch=master)](https://travis-ci.org/jaredsburrows/AndroidGradleTemplate) [![Coverage Status](https://coveralls.io/repos/jaredsburrows/AndroidGradleTemplate/badge.svg?branch=master)](https://coveralls.io/r/jaredsburrows/AndroidGradleTemplate?branch=master)
=========
Gradle + Android Studio + Robolectric + Espresso + Mockito + EasyMock/PowerMock + JaCoCo

#### Technologies used:
- **Building:**
   - [Gradle v2.4](http://gradle.org/docs/current/release-notes)
   - [Android Studio v1.2+](http://tools.android.com/recent)
   - [Android Gradle Build Tools v1.2.3](http://tools.android.com/tech-docs/new-build-system) or [Intellij v14.1.3+](https://www.jetbrains.com/idea/download/)
   - [Android SDK Build Tools v22.0.1](http://developer.android.com/tools/revisions/build-tools.html)
- **Libraries:**
   - [Android SDK v22](http://developer.android.com/tools/revisions/platforms.html#5.1)
   - [Android Support-v4 v22.0.1](http://developer.android.com/tools/support-library/features.html#v4)
   - [Android AppCompat-v7 v22.0.1](http://developer.android.com/tools/support-library/features.html#v7-appcompat)
   - [Android Google Play Services v7.3.0](https://developer.android.com/google/play-services/index.html)
- **Testing:**
   - [JUnit v4.12](https://github.com/junit-team/junit)
   - [Hamcrest Matchers v1.3](https://github.com/hamcrest/JavaHamcrest)
   - [Espresso v2.1](https://code.google.com/p/android-test-kit/wiki/Espresso)
   - [Robolectric v3.0-RC2](https://github.com/robolectric/robolectric)
   - [Mockito v1.10.19](https://github.com/mockito/mockito)
   - [EasyMock v3.3.1](https://github.com/easymock/easymock)
   - [PowerMock v1.6.2](https://github.com/jayway/powermock)
- **Reporting:**
   - [JaCoCo Test Coverage](http://www.eclemma.org/jacoco/)
   - [Coveralls](https://coveralls.io/)
- **Continuous Integration:**
   - [TravisCI](http://docs.travis-ci.com/user/languages/android/)

##### Works with the following Configurations:
 - Multiple Modules
 - Multiple Flavors
 - Android Libraries

# Getting Started:
 - [View JUnit and Hamcrest Tests](src/test/java/burrows/apps/example/template/util/AdUtilsTest.java)
 - [View Robolectric Activity Tests](src/test/java/burrows/apps/example/template/activity/MainActivityTest.java)
 - [View Robolectric Fragment Tests](src/test/java/burrows/apps/example/template/fragment/PlaceHolderFragmentTest.java)
 - [View EasyMock/PowerMock Tests](src/test/java/burrows/apps/example/template/util/PlayServicesUtilsTest.java)

## `Android Studio` or `Intellij` Support(Simple):
1. Import/Open this project with Android Studio/Intellij(click on `build.gradle`)
2. Change the Build Variant Test Artifact to `Unit Tests` instead of `Instrumentation Tests`
3. Right click a unit test located in `src/main/test` and click test

## Comand Line(Advanced):
##### Clone with `Git`:
 - `git clone https://github.com/jaredsburrows/AndroidGradleTemplate.git`
 - `cd AndroidGradleTemplate`

##### Installing/Running with `Gradle`:
 - **Install the `debug flavor` on your Android Device:**
   - `gradlew installDebug`
 - **Install and Run the `debug flavor` on your Android Device:**
   - `gradlew runDebug` 

##### Testing with `Gradle`:
 - **Run all tests in all `flavors`:**
   - `gradlew test`
 - **Run single test in all `flavors`:**
   - `gradlew test --tests="*MainActivityTest*"`
 - **Run all the `debug flavor` tests:**
   - `gradlew testDebug`
 - **Run single test in the `debug flavor`:**
   - `gradlew testDebug --tests="*MainActivityTest*"`
 - **Run single test in the `debug flavor` with `Jacoco` test reports:**
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
