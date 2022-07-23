package com.example.tmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb.data.db.ArtistDAO
import com.example.tmdb.data.db.MovieDAO
import com.example.tmdb.data.db.TMDBDatabase
import com.example.tmdb.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase =
        Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO = tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDAO = tmdbDatabase.artistDao()

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDAO = tmdbDatabase.tvShowDao()
}