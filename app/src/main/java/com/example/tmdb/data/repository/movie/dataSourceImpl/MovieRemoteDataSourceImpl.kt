package com.example.tmdb.data.repository.movie.dataSourceImpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.movie.MovieList
import com.example.tmdb.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getMovies(apiKey)
    }

    /* shorthand
      override suspend fun getMovies(): Response<MovieList> = tmdbService.getMovies(apiKey)
     */
}