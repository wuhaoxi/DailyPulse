package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.ArticleService
import com.petros.efthymiou.dailypulse.articles.ArticlesDataSource
import com.petros.efthymiou.dailypulse.articles.ArticlesRepository
import com.petros.efthymiou.dailypulse.articles.application.ArticlesUseCase
import com.petros.efthymiou.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}