package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.articles.di.articlesModule

val shareKoinModules = listOf(
    articlesModule,
    networkModule
)