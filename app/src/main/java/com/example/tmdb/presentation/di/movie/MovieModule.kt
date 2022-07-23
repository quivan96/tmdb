package com.example.tmdb.presentation.di.movie

import com.example.tmdb.domain.useCase.GetArtistsUseCase
import com.example.tmdb.domain.useCase.GetMoviesUseCase
import com.example.tmdb.domain.useCase.UpdateArtistsUseCase
import com.example.tmdb.domain.useCase.UpdateMoviesUseCase
import com.example.tmdb.presentation.artist.ArtistViewModelFactory
import com.example.tmdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideArtistViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}