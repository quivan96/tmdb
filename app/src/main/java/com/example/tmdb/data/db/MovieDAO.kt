package com.example.tmdb.data.db

import androidx.room.*
import com.example.tmdb.data.model.movie.Movie
import retrofit2.http.DELETE
import retrofit2.http.GET


@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: List<Movie>)

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()


}