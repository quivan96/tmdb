package com.example.tmdb.presentation.di.core

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdb.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdb.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdb.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdb.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(tmdbService, apiKey)

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(tmdbService, apiKey)

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource =
        TvShowRemoteDataSourceImpl(tmdbService, apiKey)
}