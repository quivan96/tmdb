package com.example.tmdb.data.repository.movie.dataSourceImpl

import com.example.tmdb.data.db.MovieDAO
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> = movieDAO.getMovies()

    override suspend fun saveMoviesFromDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}