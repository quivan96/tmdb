package com.example.tmdb.data.repository.movie

import android.util.Log
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.model.movie.MovieList
import com.example.tmdb.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdb.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) :
    MovieRepository {

    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.i("mytag", "This is the ERROR: ${e.message.toString()}")
        }

        return movieList
    }

    suspend fun getMoviesFromDb(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.i("mytag", e.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.i("mytag", e.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDb()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }

}