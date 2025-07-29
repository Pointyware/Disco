plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxKover)
}

kotlin {
    jvmToolchain(21)
    jvm("desktop")
    androidTarget {
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "org.pointyware.disco.entities"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }
}
