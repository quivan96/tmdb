package com.example.tmdb.data.repository.tvShow.dataSourceImpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.tvShow.TvShowList
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String): TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getTvShows(apiKey)


}