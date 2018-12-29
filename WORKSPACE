android_sdk_repository(name = "androidsdk", path = "/Users/jin/code/android_sdk")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

BAZEL_JSON_COMMIT = "0d26dfd8d22c8d5476f1e49f6a9547e0f030fb8f"

# This causes the build to require `--incompatible_disallow_slash_operator=false`.
# See https://github.com/erickj/bazel_json/pull/1
# For convenience, add `build --incompatible_disallow_slash_operator=false` to your .bazelrc.
http_archive(
    name = "bazel_json",
    strip_prefix = "bazel_json-%s" % BAZEL_JSON_COMMIT,
    url = "https://github.com/erickj/bazel_json/archive/%s.zip" % BAZEL_JSON_COMMIT,
)

RULES_MAVEN_COMMIT = "a4b807ba8843983a6c8fc422e37c1552bfe89160"

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
