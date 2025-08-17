package com.petros.efthymiou.dailypulse.sources.di

import com.petros.efthymiou.dailypulse.sources.application.SourcesUseCase
import com.petros.efthymiou.dailypulse.sources.data.SourcesDataSource
import com.petros.efthymiou.dailypulse.sources.data.SourcesRepository
import com.petros.efthymiou.dailypulse.sources.data.SourcesService
import com.petros.efthymiou.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single<SourcesService> { SourcesService(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
}