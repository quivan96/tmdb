package com.example.tmdb.presentation.di.tvShow

import com.example.tmdb.domain.useCase.*
import com.example.tmdb.presentation.artist.ArtistViewModelFactory
import com.example.tmdb.presentation.movie.MovieViewModelFactory
import com.example.tmdb.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideArtistViewModelFactory(
        getTvShowUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowsUseCase)

    }
}