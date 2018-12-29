load("@rules_maven//:defs.bzl", "artifact")

android_binary(
    name = "template_app",
    srcs = glob(["java/**/*.java"]),
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**/*"]),
    custom_package = "burrows.apps.example.template",
    deps = [
        artifact("com.google.android.material:material:1.0.0"),
        artifact("com.google.android.gms:play-services-ads:15.0.0"),
        artifact("com.google.android.gms:play-services-basement:15.0.0"),
        artifact("com.google.android.gms:play-services-base:15.0.0"),
        artifact("androidx.annotation:annotation:1.0.0"),
        artifact("androidx.cardview:cardview:1.0.0"),
        "@maven//:androidx_appcompat_appcompat_1_0_0",
        "@maven//:com_google_android_gms_play_services_ads_lite_15_0_0",
        "@maven//:androidx_recyclerview_recyclerview_1_0_0",
        "@maven//:androidx_fragment_fragment_1_0_0",
    ]
)
