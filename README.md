> This is a fork of https://github.com/jaredsburrows/android-gradle-java-app-template with Bazel as the build system, instead of Gradle.

> This is a WIP: many features are not yet ported over.

# Android Bazel Java App Template 

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Twitter Follow](https://img.shields.io/twitter/follow/jaredsburrows.svg?style=social)](https://twitter.com/jaredsburrows)

## Technologies used:
#### Build Tools:
| Name                                                                                     | Description          |
|------------------------------------------------------------------------------------------|----------------------|
| [Bazel](https://bazel.build)                                                             | Bazel build system   |
| [Android SDK](http://developer.android.com/tools/revisions/platforms.html#5.1)           | Official SDK         |
| [Android SDK Build Tools](http://developer.android.com/tools/revisions/build-tools.html) | Official Build Tools |
| [Android Studio](http://tools.android.com/recent) or                                     | Official IDE         |
| [Intellij](https://www.jetbrains.com/idea/download/)                                     | Intellij IDE         |

#### Android Libraries:
| Name                                                                                                  | Description            |
|-------------------------------------------------------------------------------------------------------|------------------------|
| [Android Support-v4](http://developer.android.com/tools/support-library/features.html#v4)             | Support Library API 4+ |
| [Android AppCompat-v7](http://developer.android.com/tools/support-library/features.html#v7-appcompat) | Support Library API 7+ |

#### Testing Frameworks:
| Name                                                                  | Description               |
|-----------------------------------------------------------------------|---------------------------|
| [Espresso](https://google.github.io/android-testing-support-library/) | Instrumentation Framework |
| [Robolectric](https://github.com/robolectric/robolectric)             | Unit Testing Framework    |

#### Reporting Plugins:
| Name                                     | Description                                |
|------------------------------------------|--------------------------------------------|
| [JaCoCo](http://www.eclemma.org/jacoco/) | JaCoCo Test Coverage                       |
| [Coveralls](https://coveralls.io/)       | Hosts test reports published from TravisCI |

#### Continuous Integration:
| Name                                                          | Description                                                 |
|---------------------------------------------------------------|-------------------------------------------------------------|
| [TravisCI](http://docs.travis-ci.com/user/languages/android/) | Build Server(Builds, Tests, Publishes reports to Coveralls) |

#### Publishing to Google Play:
| Name | Description |
|------|-------------|
| WIP  | WIP         |

# Getting Started:
## `Android Studio` or `Intellij` Support (Simple):
- **Import/Open this project with Android Studio/Intellij**
  - WIP

- **Instrumentation Tests:**
  - WIP

- **Unit Tests:**
  - WIP

## Building and Running


This project builds with [Bazel](https://bazel.build) and the Android Build [tools](http://tools.android.com/tech-docs/new-build-system).


**Build the APK:**

    $ bazel build //src/main:template_app

**Install the APK:**

    $ bazel mobile-install //src/main:template_app
    
or:

    $ bazel build //src/main:template_app && adb install bazel-bin/src/main/template_app.apk

**Run the App:**

    $ bazel mobile-install //src/main:template_app --start_app

## Testing

**Running the Unit Tests:**


The [Junit](http://junit.org/junit4/) and [Robolectric](https://github.com/robolectric/robolectric) tests run on the JVM, no need for emulators or real devices.

    $ WIP
    
**Run a single unit test in the `debug flavor`:**

    $ WIP

    
**Running the Instrumentation Tests:**


The [Espresso](https://developer.android.com/training/testing/ui-testing/espresso-testing.html) instrumentation tests run on the device.

    $ WIP
    

## Reports


**Generate Lint Reports:**


The [Lint](http://developer.android.com/tools/help/lint.html) plugin generates reports based off the source code.


    $ WIP


**Generate Jacoco Test Coverage:**


The [Jacoco](http://www.eclemma.org/jacoco/) plugin generates coverage reports based off the unit tests.


    $ WIP
