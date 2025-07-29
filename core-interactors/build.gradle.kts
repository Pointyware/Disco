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
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }
}
