android_sdk_repository(
    name = "androidsdk",
    path = "/usr/local/google/home/jingwen/sdk",
)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_MAVEN_COMMIT = "0.0.4"

http_archive(
    name = "rules_maven",
    strip_prefix = "rules_maven-%s" % RULES_MAVEN_COMMIT,
    url = "https://github.com/jin/rules_maven/archive/%s.zip" % RULES_MAVEN_COMMIT,
)

load("@rules_maven//:defs.bzl", "maven_install")
load("//bazel/robolectric:android_all.bzl", "ROBOLECTRIC_ANDROID_ALL_JARS")
load("//:versions.bzl", "versions")

TEST_DEPS = [
    "org.robolectric:robolectric:" + versions["robolectric"],
    "androidx.test.ext:junit:" + versions["androidx.test"]["ext"]["junit"],
    "org.assertj:assertj-core:" + versions["assertj"],
    "junit:junit:" + versions["junit"],
    "androidx.test:runner:" + versions["androidx.test"]["runner"],
    "androidx.test:rules:" + versions["androidx.test"]["rules"],
    "org.easymock:easymock:" + versions["easymock"],
    "org.powermock:powermock-core:" + versions["powermock"],
    "org.powermock:powermock-module-junit4:" + versions["powermock"],
    "org.powermock:powermock-api-easymock:" + versions["powermock"],
] + ROBOLECTRIC_ANDROID_ALL_JARS.values()

maven_install(
    artifacts = [
        "com.google.android.material:material:" + versions["material"],
        "androidx.cardview:cardview:" + versions["cardview"],
        "com.google.android.gms:play-services-ads:" + versions["gps"],
        "com.google.android.gms:play-services-basement:" + versions["gps"],
        "com.google.android.gms:play-services-base:" + versions["gps"],
        "androidx.annotation:annotation:" + versions["annotation"],
    ] + TEST_DEPS,
    repositories = [
        "https://bintray.com/bintray/jcenter",
        "https://maven.google.com",
    ],
)
