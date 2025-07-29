enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Disco"
include(
    ":app-android",
    ":app-desktop",
//    ":app-ios",
    ":app-shared"
)

include(
    ":core-common",
    ":core-data",
    ":core-ui",
    ":core-interactors",
    ":core-viewmodels",
    ":core-entities",
    ":core-all"
)

include(
    ":feature-evolution",
    ":feature-simulation",
    ":feature-training",
)
