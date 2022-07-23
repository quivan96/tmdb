package com.example.tmdb.data.db

import androidx.room.*
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.model.movie.Movie
import retrofit2.http.DELETE
import retrofit2.http.GET


@Dao
interface ArtistDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artist: List<Artist>)

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()


}