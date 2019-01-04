load("@rules_maven//:defs.bzl", "artifact")
load("//bazel/robolectric:android_all.bzl", "ROBOLECTRIC_ANDROID_ALL_JARS")

ANDROID_ALL_JARS = [
    artifact(x)
    for x in ROBOLECTRIC_ANDROID_ALL_JARS.values()
]

java_library(
    name = "robolectric_and_android_all",
    data = [":robolectric-deps.properties"],
    exports = [
        artifact("org.robolectric:robolectric:4.0"),
    ] + ANDROID_ALL_JARS,
    visibility = ["//src/test:__subpackages__"],
)

filegroup(
    name = "android_all_jars",
    srcs = ANDROID_ALL_JARS,
)

genrule(
    name = "gen_properties",
    srcs = [":android_all_jars"],
    outs = ["robolectric-deps.properties"],
    cmd = "$(location :gen_deps) $(locations :android_all_jars) > $@",
    tools = [":gen_deps"],
)

py_binary(
    name = "gen_deps",
    srcs = ["gen_deps.py"],
)
