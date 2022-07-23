package com.example.tmdb.domain.useCase

import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}