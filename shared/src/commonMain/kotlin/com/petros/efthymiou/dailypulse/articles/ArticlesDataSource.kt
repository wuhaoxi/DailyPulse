package com.petros.efthymiou.dailypulse.articles

import petros.efthymiou.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val dateBase: DailyPulseDatabase) {

    fun getAllArticles(): List<ArticleRaw> = dateBase.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        dateBase.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() = dateBase.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        dateBase.dailyPulseDatabaseQueries.insertArticle(
            articleRaw.title.orEmpty(),
            articleRaw.desc,
            articleRaw.date.orEmpty(),
            articleRaw.imageUrl,
        )
    }


    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?,
    ): ArticleRaw = ArticleRaw(
        title,
        desc,
        date,
        url
    )
}