import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

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

tasks.dokkaHtmlMultiModule {
    moduleName.set("Disco")
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

    dokkaPlugin(projects.appShared)
    dokkaPlugin(projects.appAndroid)
    dokkaPlugin(projects.appDesktop)

    dokkaPlugin(projects.featureTraining)
    dokkaPlugin(projects.featureEvolution)
    dokkaPlugin(projects.featureSimulation)

    dokkaPlugin(projects.coreCommon)
    dokkaPlugin(projects.coreEntities)
    dokkaPlugin(projects.coreData)
    dokkaPlugin(projects.coreInteractors)
    dokkaPlugin(projects.coreViewmodels)
    dokkaPlugin(projects.coreUi)
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")

    tasks.withType<DokkaTask>().configureEach {

        dokkaSourceSets.configureEach {

            sourceLink {
                localDirectory.set(projectDir.resolve("src"))
                remoteUrl.set(URL("https://github.com/Pointyware/XYZ/tree/main/src"))
                remoteLineSuffix.set("#L")
            }
        }
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
