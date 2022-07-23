package com.example.tmdb.data.repository.artist.dataSource

import com.example.tmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}