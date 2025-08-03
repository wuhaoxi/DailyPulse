package com.petros.efthymiou.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "e231e6a2653e4d6d863b4ec837087ddd"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body<ArticlesResponse>()
        return response.articles
    }
}