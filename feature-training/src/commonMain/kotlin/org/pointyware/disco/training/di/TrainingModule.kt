/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.pointyware.disco.training.data.ExerciseRepository
import org.pointyware.disco.training.data.ExerciseRepositoryImpl
import org.pointyware.disco.training.interactors.TrainingController
import org.pointyware.disco.training.interactors.TrainingControllerImpl
import org.pointyware.disco.training.viewmodels.TrainingViewModel

val trainingQualifier = named("training")

fun trainingModule() = module {

    single<CoroutineScope>(qualifier = trainingQualifier) {
        CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }

    includes(
        trainingDataModule(),
        trainingInteractorsModule(),
        trainingViewModelModule(),
    )
}

fun trainingDataModule() = module {
    factory<ExerciseRepository> {
        ExerciseRepositoryImpl()
    }
}

fun trainingInteractorsModule() = module {
    factory<TrainingController> {
        TrainingControllerImpl(
            get(),
            trainingScope = get(qualifier = trainingQualifier)
        )
    }
}

fun trainingViewModelModule() = module {
    // Define your ViewModel bindings here
    // viewModel { YourViewModel(get()) }
    factoryOf(::TrainingViewModel)
}
