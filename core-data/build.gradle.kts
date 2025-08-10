/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.kotlinxKover)
    alias(libs.plugins.publishMultiplatform)
}
version = libs.versions.project.get()

kotlin {
    jvmToolchain(21)
    jvm("desktop")
    androidTarget() {

    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.coreEntities)

                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)

                api(libs.ktor.clientCore)
                api(libs.ktor.clientLogging)
                api(libs.ktor.clientResources)
                api(libs.ktor.clientContentNegotiation)
                api(libs.ktor.serializationKotlinxJson)

                implementation(libs.sqlDelight.runtime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutinesTest)
                implementation(libs.truth)
            }
        }
        val desktopMain by getting {
            dependencies {
//                implementation(libs.ktor)
                api(libs.ktor.clientOkhttp)
                implementation(libs.sqlDelight.jvm)
            }
        }
        val androidMain by getting {
            dependencies {
//                implementation(libs.ktor.clientAndroid)
                api(libs.ktor.clientOkhttp)
                implementation(libs.sqlDelight.android)
            }
        }
        val iosMain by getting {
            dependencies {
                api(libs.ktor.clientDarwin)
                implementation(libs.sqlDelight.native)
            }
        }
    }
}

android {
    namespace = "org.pointyware.disco.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    databases {
        create("HostDb") {
            packageName = "org.pointyware.disco.data.hosts.db"
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates("org.pointyware.disco", "core-data", libs.versions.project.get())

    pom {
        name = "Disco Core"
        description = "All Disco Core Modules"
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
