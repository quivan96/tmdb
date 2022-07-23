package com.example.tmdb.presentation

import android.app.Application
import com.example.tmdb.BuildConfig
import com.example.tmdb.presentation.di.Injector
import com.example.tmdb.presentation.di.artist.ArtistSubComponent
import com.example.tmdb.presentation.di.core.*
import com.example.tmdb.presentation.di.movie.MovieSubComponent
import com.example.tmdb.presentation.di.tvShow.TvShowSubComponent
import okhttp3.internal.applyConnectionSpec
import okhttp3.internal.notify

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent = appComponent.movieSubComponent().create()

    override fun createArtistSubComponent(): ArtistSubComponent = appComponent.artistSubComponent().create()

    override fun createTvShowSubComponent(): TvShowSubComponent = appComponent.tvShowSubComponent().create()
}