load("@rules_maven//:defs.bzl", "artifact")
load("//:versions.bzl", "versions")

TARGET_SDK_VERSIONS = [
    19,
    21,
    22,
    23,
    24,
    25,
    26,
    27,
    28,
]

[android_local_test(
    name = "main_activity_test_api_%s" % targetSdkVersion,
    srcs = ["java/burrows/apps/example/template/activity/MainActivityTest.java"],
    manifest = "AndroidManifest.xml",
    manifest_values = {
        "targetSdkVersion": str(targetSdkVersion),
    },
    test_class = "burrows.apps.example.template.activity.MainActivityTest",
    deps = [
        "//bazel/robolectric:robolectric_and_android_all",
        "//src/main:template_app_lib",
        artifact("androidx.test.ext:junit:" + versions["androidx.test"]["ext"]["junit"]),
        artifact("org.assertj:assertj-core:" + versions["assertj"]),
        artifact("org.robolectric.shadows:framework:" + versions["robolectric"]),
    ],
) for targetSdkVersion in TARGET_SDK_VERSIONS]

[android_local_test(
    name = "ads_util_test_api_%s" % targetSdkVersion,
    srcs = ["java/burrows/apps/example/template/util/AdUtilsTest.java"],
    manifest = "AndroidManifest.xml",
    manifest_values = {
        "targetSdkVersion": str(targetSdkVersion),
    },
    test_class = "burrows.apps.example.template.util.AdUtilsTest",
    deps = [
        "//bazel/robolectric:robolectric_and_android_all",
        "//src/main:template_app_lib",
        artifact("org.hamcrest:hamcrest-library:1.3"),
        artifact("com.google.android.gms:play-services-ads-lite:" + versions["gps"]),
    ],
) for targetSdkVersion in TARGET_SDK_VERSIONS]

[android_local_test(
    name = "play_services_utils_test_api_%s" % targetSdkVersion,
    srcs = ["java/burrows/apps/example/template/util/PlayServicesUtilsTest.java"],
    manifest = "AndroidManifest.xml",
    manifest_values = {
        "targetSdkVersion": str(targetSdkVersion),
    },
    test_class = "burrows.apps.example.template.util.PlayServicesUtilsTest",
    deps = [
        "//bazel/robolectric:robolectric_and_android_all",
        "//src/main:template_app_lib",
        artifact("androidx.annotation:annotation:" + versions["annotation"]),
        artifact("org.hamcrest:hamcrest-library:1.3"),
        artifact("org.easymock:easymock:" + versions["easymock"]),
        artifact("com.google.android.gms:play-services-basement:" + versions["gps"]),
        artifact("com.google.android.gms:play-services-base:" + versions["gps"]),
        artifact("org.powermock:powermock-api-easymock:" + versions["powermock"]),
        artifact("org.powermock:powermock-api-support:" + versions["powermock"]),
        artifact("org.powermock:powermock-core:" + versions["powermock"]),
        artifact("org.powermock:powermock-module-junit4:" + versions["powermock"]),
    ],
) for targetSdkVersion in TARGET_SDK_VERSIONS]
