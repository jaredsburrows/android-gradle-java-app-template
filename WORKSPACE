android_sdk_repository(
    name = "androidsdk",
)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_MAVEN_COMMIT = "0.0.4"

http_archive(
    name = "rules_maven",
    strip_prefix = "rules_maven-%s" % RULES_MAVEN_COMMIT,
    url = "https://github.com/jin/rules_maven/archive/%s.zip" % RULES_MAVEN_COMMIT,
)

load("@rules_maven//:defs.bzl", "maven_install")

GMS_VERSION = "15.0.0"

maven_install(
    artifacts = [
        "com.google.android.material:material:1.0.0",
        "androidx.cardview:cardview:1.0.0",
        "com.google.android.gms:play-services-ads:%s" % GMS_VERSION,
        "com.google.android.gms:play-services-basement:%s" % GMS_VERSION,
        "com.google.android.gms:play-services-base:%s" % GMS_VERSION,
        "androidx.annotation:annotation:1.0.0",
    ],
    repositories = [
        "https://bintray.com/bintray/jcenter",
        "https://maven.google.com",
    ],
)
