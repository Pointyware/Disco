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
                implementation(projects.coreInteractors)

                implementation(libs.kotlinx.coroutinesCore)

                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)

                api(libs.compose.viewModels)
            }
        }

        val androidMain by getting {
            dependencies {
            }
        }
    }
}

android {
    namespace = "org.pointyware.disco.viewmodels"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
}
