package com.example.tmdb.domain.repository

import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.model.movie.Movie

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}