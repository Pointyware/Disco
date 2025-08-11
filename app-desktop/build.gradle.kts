/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composePlugin)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxKover)
}

kotlin {
    jvmToolchain(21)
    jvm("desktop") {
//        @OptIn(ExperimentalKotlinGradlePluginApi::class)
//        mainRun {
//            mainClass = "org.pointyware.disco.MainKt"
//        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.appShared)

                implementation(compose.ui)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(libs.compose.navigation)
                implementation(libs.compose.backhandler)

                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose {
    desktop {
        application {
            mainClass = "org.pointyware.disco.ApplicationKt"
        }
    }
}
