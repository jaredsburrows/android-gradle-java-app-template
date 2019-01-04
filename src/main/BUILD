load("@rules_maven//:defs.bzl", "artifact")

android_binary(
    name = "template_app",
    custom_package = "burrows.apps.example.template",
    manifest = "AndroidManifest.xml",
    deps = ["//src/main:template_app_lib"],
)

android_library(
    name = "template_app_lib",
    srcs = glob(["java/**/*.java"]),
    custom_package = "burrows.apps.example.template",
    manifest = "java/AndroidManifest.xml",
    resource_files = glob(["res/**/*"]),
    visibility = ["//src/test:__subpackages__"],
    deps = [":external_deps"],
)

android_library(
    name = "external_deps",
    exports = [
        artifact("com.google.android.material:material:1.0.0"),
        artifact("com.google.android.gms:play-services-ads:15.0.0"),
        artifact("com.google.android.gms:play-services-basement:15.0.0"),
        artifact("com.google.android.gms:play-services-base:15.0.0"),
        artifact("androidx.annotation:annotation:1.0.0"),
        artifact("androidx.cardview:cardview:1.0.0"),
        artifact("androidx.appcompat:appcompat:1.0.0"),
        artifact("com.google.android.gms:play-services-ads-lite:15.0.0"),
        artifact("androidx.recyclerview:recyclerview:1.0.0"),
        artifact("androidx.fragment:fragment:1.0.0"),
    ],
)
