import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composePlugin)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.kotlinxKover)
    alias(libs.plugins.publishMultiplatform)
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
                implementation(projects.coreCommon)
                implementation(projects.coreEntities)
                implementation(projects.coreViewmodels)
                implementation(projects.coreUi)

                api(compose.ui)
                api(compose.foundation)
                api(compose.material3)
                api(compose.components.resources)
                api(libs.compose.navigation)

                implementation(compose.material3AdaptiveNavigationSuite)

                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)

                implementation(libs.kotlinx.serialization.json)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutinesTest)

                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.uiTest)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.uiToolingPreview)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

android {
    namespace = "org.pointyware.disco.training"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    debugImplementation(libs.androidx.uiTooling)
}

compose.resources {
    publicResClass = true
    packageOfResClass = "org.pointyware.disco.training"
    generateResClass = always
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates("org.pointyware.disco", "training", libs.versions.project.get())

    pom {
        name = "Disco Training"
        description = "Disco Training Module"
        inceptionYear = "2024"
        url = "http://github.com/Pointyware/Disco"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "TSampley"
                name = "Taush Sampley"
                email = "tsampley@pointyware.org"
            }
        }
        scm {
            val repo = "github.com/Pointyware/Disco"
            connection = "scm:git:git://$repo.git"
            developerConnection = "scm:git:ssh://$repo.git"
            url = "http://$repo/"
        }
    }
}
