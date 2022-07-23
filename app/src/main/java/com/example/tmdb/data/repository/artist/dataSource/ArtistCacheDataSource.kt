package com.example.tmdb.data.repository.artist.dataSource

import com.example.tmdb.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun saveArtistsToCache(artists: List<Artist>)

    suspend fun getArtistsFromCache(): List<Artist>

}