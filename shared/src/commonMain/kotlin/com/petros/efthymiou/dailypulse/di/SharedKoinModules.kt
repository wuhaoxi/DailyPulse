package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.articles.di.articlesModule
import com.petros.efthymiou.dailypulse.sources.di.sourcesModule

val shareKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule
)