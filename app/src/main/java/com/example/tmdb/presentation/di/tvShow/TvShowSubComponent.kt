package com.example.tmdb.presentation.di.tvShow

import com.example.tmdb.presentation.artist.ArtistActivity
import com.example.tmdb.presentation.di.artist.ArtistModule
import com.example.tmdb.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}