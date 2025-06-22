package org.pointyware.artes.shared.di

import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.pointyware.artes.agents.viewmodels.AgentEditorViewModel
import org.pointyware.artes.data.di.dataModule
import org.pointyware.artes.data.di.dataQualifier
import org.pointyware.artes.data.hosts.HostDao
import org.pointyware.artes.data.hosts.ServiceRepository
import org.pointyware.artes.data.hosts.SqlDelightHostDao
import org.pointyware.artes.hosts.interactors.CreateHostUseCase
import org.pointyware.artes.hosts.viewmodels.HostViewModel
import org.pointyware.artes.interactors.di.interactorsModule
import org.pointyware.artes.services.ServiceRepositoryImpl
import org.pointyware.artes.services.openai.network.di.openAiModule
import org.pointyware.artes.services.openai.network.openAiHttpClient
import org.pointyware.artes.text.completion.CompletionViewModel
import org.pointyware.artes.viewmodels.DefaultAgentInfoViewModel
import org.pointyware.artes.viewmodels.di.viewModelModule

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

        openAiModule()
    )

    single<HttpClient> { openAiHttpClient() }
}

fun sharedViewModelModule() = module {
    single<CompletionViewModel> {
        CompletionViewModel(
            get(),
            get(qualifier = dataQualifier),
            get(qualifier = dataQualifier)
        )
    }

    single<HostViewModel> {
        HostViewModel(
            get(),
        )
    }

    factory<AgentEditorViewModel> {
        AgentEditorViewModel(
            get(),
            get(),
            get(),
            get()
        )
    }

    factory<DefaultAgentInfoViewModel> {
        DefaultAgentInfoViewModel(
            get(),
            get(),
            get(qualifier = dataQualifier)
        )
    }
}

fun sharedInteractorsModule() = module {
    factoryOf(::CreateHostUseCase)
    factoryOf(::CreateAgentUseCase)
    factoryOf(::GetServiceModelsUseCase)

    factoryOf(::BeginEditingAgentUseCase)
    factoryOf(::RemoveAgentUseCase)
}

fun sharedDataModule() = module {
    single<HostDao> {
        SqlDelightHostDao(
            get()
        )
    }

    single<ServiceRepository> {
        ServiceRepositoryImpl(
            hostDao = get(),
            openAiModelFetcher = get(),
            ioDispatcher = get(qualifier = dataQualifier),
            ioScope = get(qualifier = dataQualifier)
        )
    }
}
