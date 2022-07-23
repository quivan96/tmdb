package com.example.tmdb.presentation.di.movie

import android.text.Editable
import com.example.tmdb.presentation.artist.ArtistActivity
import com.example.tmdb.presentation.di.artist.ArtistModule
import com.example.tmdb.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}