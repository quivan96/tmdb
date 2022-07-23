package com.example.tmdb.data.db

import androidx.room.*
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.model.tvShow.TvShow
import retrofit2.http.DELETE
import retrofit2.http.GET


@Dao
interface TvShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow: List<TvShow>)

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShows(): List<TvShow>

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAlTvShows()


}