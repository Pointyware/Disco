/*
 * Copyright (c) 2024-2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license.
 */

plugins {
    alias(libs.plugins.kotlinJvm)
    application
}

kotlin {
    jvmToolchain(21)
}

dependencies {

    implementation(libs.kotlinx.dateTime)
    implementation(libs.kotlinx.coroutinesCore)
    implementation(libs.koin.core)

    implementation(libs.kotlinx.html.jvm)

    testImplementation(libs.kotlin.test)
}

application {
    mainClass = "org.pointyware.disco.site.MainKt"
}
