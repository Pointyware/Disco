package org.pointyware.disco.shared.di

import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.pointyware.disco.data.defaultHttpClient
import org.pointyware.disco.data.di.dataModule
import org.pointyware.disco.interactors.di.interactorsModule
import org.pointyware.disco.training.di.trainingModule
import org.pointyware.disco.viewmodels.di.viewModelModule

/**
 */
val appQualifier = named("application")

expect fun platformSharedModule(): Module

fun sharedModule() = module {

    includes(
        platformSharedModule(),

        dataModule(),
        sharedDataModule(),
        viewModelModule(),
        sharedViewModelModule(),
        interactorsModule(),
        sharedInteractorsModule(),

        trainingModule(),
    )

    single<HttpClient> { defaultHttpClient(baseUrl = "") }
}

fun sharedViewModelModule() = module {
}

fun sharedInteractorsModule() = module {
}

fun sharedDataModule() = module {
}
