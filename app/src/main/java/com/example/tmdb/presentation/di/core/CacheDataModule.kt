package com.example.tmdb.presentation.di.core

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdb.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdb.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.example.tmdb.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdb.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdb.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.example.tmdb.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdb.data.repository.tvShow.dataSourceImpl.TvShowCacheDataSourceImpl
import com.example.tmdb.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule() {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource =
        MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource =
        ArtistCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource =
        TvShowCacheDataSourceImpl()
}