package com.example.tmdb.data.repository.tvShow.dataSource

import com.example.tmdb.data.model.tvShow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsFromDB(movies: List<TvShow>)

    suspend fun clearAll()

}