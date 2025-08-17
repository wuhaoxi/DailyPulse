package com.petros.efthymiou.dailypulse.sources.data

class SourcesRepository(
    private val dataSource: SourcesDataSource,
    private val service: SourcesService
) {

    suspend fun getAllSources(): List<SourceRaw> {
        val sourceDb = dataSource.getAllSources()
        if (sourceDb.isEmpty()) {
            dataSource.clearSources()
            val fetchedSources = service.fetchSources()
            dataSource.createSource(fetchedSources)
            return fetchedSources
        }
        return sourceDb
    }
}