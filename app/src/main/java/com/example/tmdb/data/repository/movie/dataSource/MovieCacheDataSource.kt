package com.example.tmdb.data.repository.movie.dataSource

import com.example.tmdb.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun saveMoviesToCache(movies: List<Movie>)

    suspend fun getMoviesFromCache(): List<Movie>

}