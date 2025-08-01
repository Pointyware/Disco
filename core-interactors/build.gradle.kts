/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

import com.android.build.gradle.internal.ide.kmp.KotlinAndroidSourceSetMarker.Companion.android

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxKover)
}

kotlin {
    jvmToolchain(21)
    jvm("desktop")
    androidTarget() {

    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.coreEntities)
                implementation(projects.coreData)

                implementation(libs.kotlinx.coroutinesCore)

                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)
            }
        }

        val androidMain by getting {
            dependencies {
            }
        }
    }
}

android {
    namespace = "org.pointyware.disco.interactors"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }
}
