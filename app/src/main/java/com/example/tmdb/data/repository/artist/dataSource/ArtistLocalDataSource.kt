package com.example.tmdb.data.repository.artist.dataSource

import com.example.tmdb.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsFromDB(artists: List<Artist>)

    suspend fun clearAll()
}