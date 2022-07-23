package com.example.tmdb.data.repository.tvShow.dataSourceImpl

import com.example.tmdb.data.model.tvShow.TvShow
import com.example.tmdb.data.model.tvShow.TvShowList
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

}