package com.example.tmdb.data.repository.tvShow.dataSource

import com.example.tmdb.data.model.tvShow.TvShow

interface TvShowCacheDataSource {

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)

    suspend fun getTvShowsFromCache(): List<TvShow>
}