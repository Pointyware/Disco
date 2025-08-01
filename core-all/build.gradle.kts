/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
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
                api(projects.coreCommon)
                api(projects.coreEntities)
                api(projects.coreData)
                api(projects.coreInteractors)
                api(projects.coreViewmodels)
                api(projects.coreUi)
            }
        }
    }
}

android {
    namespace = "org.pointyware.disco.core"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates("org.pointyware.disco", "core", libs.versions.project.get())

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
