/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

plugins {
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinAndroid) apply false

    alias(libs.plugins.kotlinxSerialization) apply false
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinCocoapods) apply false
    alias(libs.plugins.composePlugin) apply false
    alias(libs.plugins.composeCompiler) apply false

    // apply dokka now
    alias(libs.plugins.dokka)

    alias(libs.plugins.sqlDelight) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.publishMultiplatform) apply false

    alias(libs.plugins.kotlinxKover)
}

val projectVersion = libs.versions.project.toString()
subprojects {
    group = "org.pointyware.disco"
    version = projectVersion
}

dependencies {
    kover(projects.coreEntities)
    kover(projects.coreData)
    kover(projects.coreViewmodels)
    kover(projects.coreUi)
    kover(projects.coreData)

    kover(projects.appShared)

    kover(projects.appAndroid)
    kover(projects.appDesktop)

    dokka(projects.appShared)
    dokka(projects.appAndroid)
    dokka(projects.appDesktop)

    dokka(projects.featureTraining)
    dokka(projects.featureEvolution)
    dokka(projects.featureSimulation)

    dokka(projects.coreCommon)
    dokka(projects.coreEntities)
    dokka(projects.coreData)
    dokka(projects.coreInteractors)
    dokka(projects.coreViewmodels)
    dokka(projects.coreUi)
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

dokka {
    moduleName.set("Disco")
    dokkaPublications.html {
        suppressInheritedMembers = true
        failOnWarning = true
    }
//    dokkaSourceSets.configureEach {
//        includes.from("README.md")
//        sourceLink {
//            localDirectory.set(file("src/$name/kotlin"))
//            remoteUrl = uri("https://github.com/Pointyware/Disco/")
//            remoteLineSuffix.set("#L")
//        }
//        documentedVisibilities(VisibilityModifier.Public)
//    }
//    dokkaSourceSets["commonMain"].apply {
//        sourceLink {
//            localDirectory.set(projectDir.resolve("src/commonMain/kotlin"))
//        }
//    }
//    dokkaSourceSets["androidMain"].apply {
//        sourceLink {
//            localDirectory.set(projectDir.resolve("src/androidMain/kotlin"))
//        }
//    }
//    dokkaSourceSets["desktopMain"].apply {
//        sourceLink {
//            localDirectory.set(projectDir.resolve("src/desktopMain/kotlin"))
//        }
//    }
    pluginsConfiguration.html {
//        customStyleSheets.from("styles.css")
//        customAssets.from("logo.png")
        footerMessage.set("(c) Pointyware LLC")
    }
}

kover.reports {
    filters {
        excludes.classes("kotlinx.kover.examples.merged.utils.*", "kotlinx.kover.examples.merged.subproject.utils.*")
        includes.classes("kotlinx.kover.examples.merged.*")
    }

    verify {
        rule {
            bound {
                minValue.set(50)
                maxValue.set(75)
            }
        }
    }
}
