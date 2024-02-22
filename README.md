# Android Gradle Java App Template

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![build](https://github.com/jaredsburrows/android-gradle-java-app-template/actions/workflows/android.yml/badge.svg)](https://github.com/jaredsburrows/android-gradle-java-app-template/actions/workflows/android.yml)
[![Twitter Follow](https://img.shields.io/twitter/follow/jaredsburrows.svg?style=social)](https://twitter.com/jaredsburrows)

Gradle + Android Studio + Robolectric + Espresso + Mockito + EasyMock/PowerMock

## Technologies used:
#### Build Tools:
|Name|Description|
|---|---|
| [Gradle](https://gradle.org/docs/current/release-notes) | Gradle build system |
| [Android Gradle Build Tools](https://tools.android.com/tech-docs/new-build-system) | Official Gradle Plugin |
| [Android SDK](https://developer.android.com/tools/revisions/platforms.html#5.1) | Official SDK |
| [Android SDK Build Tools](https://developer.android.com/tools/revisions/build-tools.html) | Official Build Tools |
| [Android Studio](https://tools.android.com/recent) or | Official IDE |
| [Intellij](https://www.jetbrains.com/idea/download/) | Intellij IDE |

#### Testing Frameworks:
|Name|Description|
|---|---|
| [Espresso](https://google.github.io/android-testing-support-library/) | Instrumentation Framework |
| [Robolectric](https://github.com/robolectric/robolectric) | Unit Testing Framework |

#### Publishing to Google Play:
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

This project builds with [Gradle](www.gradle.org) and the Android Build [tools](https://tools.android.com/tech-docs/new-build-system).


**Build the APK:**

```shell
gradlew assembleDebug
```

**Install the APK:**

```shell
gradlew installDebug
```


## Testing

**Running the Unit Tests:**


The [Junit](https://junit.org/junit4/) and [Robolectric](https://github.com/robolectric/robolectric) tests run on the JVM, no need for emulators or real devices.

```shell
gradlew testDebug
```

**Run a single unit test in the `debug flavor`:**

```shell
gradlew testDebug --tests="*MainActivityTest*"
```

**Running the Instrumentation Tests:**


The [Espresso](https://developer.android.com/training/testing/ui-testing/espresso-testing.html) instrumentation tests run on the device.

```shell
gradlew connectedDebugAndroidTest
```

## Reports


**Generate Lint Reports:**


The [Lint](https://developer.android.com/tools/help/lint.html) plugin generates reports based off the source code.

```shell
gradlew lintDebug
```

## License
```
Copyright (C) 2015 Jared Burrows

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
