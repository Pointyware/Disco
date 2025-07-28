plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    jvmToolchain(21)
    androidTarget() {
    }

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(projects.appShared)

                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)
                implementation(libs.koin.android)
            }
        }
    }
}

android {
    namespace = "org.pointyware.disco"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        targetSdk = 35

        versionCode = 1
        versionName = "0.1.0"
        versionNameSuffix = "alpha"
    }
    buildTypes {
        debug {

        }
        release {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activityCompose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.uiToolingPreview)
    implementation(libs.androidx.material3)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.uiTooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
