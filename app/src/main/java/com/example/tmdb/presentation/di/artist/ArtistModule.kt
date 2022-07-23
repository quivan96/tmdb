package com.example.tmdb.presentation.di.artist

import com.example.tmdb.domain.useCase.GetArtistsUseCase
import com.example.tmdb.domain.useCase.UpdateArtistsUseCase
import com.example.tmdb.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}