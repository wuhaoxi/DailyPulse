package com.petros.efthymiou.dailypulse.sources.data

import petros.efthymiou.dailypulse.db.DailyPulseDatabase

class SourcesDataSource(private val db: DailyPulseDatabase) {

    fun getAllSources(): List<SourceRaw> = db.dailyPulseDatabaseQueries.selectAllSources(::mapSource).executeAsList()

    fun clearSources() = db.dailyPulseDatabaseQueries.removeAllArticles()

    internal fun createSource(sources: List<SourceRaw>) {
        db.dailyPulseDatabaseQueries.transaction {
            sources.forEach { source ->
                insertSource(source)
            }
        }
    }

    private fun insertSource(source: SourceRaw) {
        db.dailyPulseDatabaseQueries.insertSource(
            source.id,
            source.name,
            source.desc,
            source.language,
            source.country
        )
    }


    private fun mapSource(
        id: String,
        name: String,
        desc: String,
        language: String,
        country: String,
    ): SourceRaw {
        return SourceRaw(
            id,
            name,
            desc,
            language,
            country
        )
    }
}