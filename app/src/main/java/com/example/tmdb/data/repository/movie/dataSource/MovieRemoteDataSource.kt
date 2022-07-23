package com.example.tmdb.data.repository.movie.dataSource

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}