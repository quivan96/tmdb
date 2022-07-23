package com.example.tmdb.data.api

import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.model.movie.MovieList
import com.example.tmdb.data.model.tvShow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  This is where we get the data from the web api and save it to the local room data base
 * */

interface TMDBService {

    @GET("/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("/person/popular")
    suspend fun geArtists(@Query("api_key") apiKey: String): Response<ArtistList>

    @GET("/tv/popular")
    suspend fun getTvShows(@Query("api_key") apiKey: String): Response<TvShowList>
}