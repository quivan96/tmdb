package com.example.tmdb.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.domain.useCase.GetArtistsUseCase
import com.example.tmdb.domain.useCase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists(): LiveData<List<Artist>?> = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists(): LiveData<List<Artist>?> = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}