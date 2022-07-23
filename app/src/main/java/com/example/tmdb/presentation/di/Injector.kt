package com.example.tmdb.presentation.di

import com.example.tmdb.presentation.di.artist.ArtistSubComponent
import com.example.tmdb.presentation.di.movie.MovieSubComponent
import com.example.tmdb.presentation.di.tvShow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}