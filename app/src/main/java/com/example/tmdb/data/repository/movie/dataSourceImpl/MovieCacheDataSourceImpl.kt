package com.example.tmdb.data.repository.movie.dataSourceImpl

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.movie.dataSource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}