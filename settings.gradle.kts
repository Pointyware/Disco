/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

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
//    ":core-all"
)

include(
    ":feature-evolution",
    ":feature-simulation",
    ":feature-training",
)

include(":website")
