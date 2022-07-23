package com.example.tmdb.presentation.di.core

import androidx.room.Dao
import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.db.ArtistDAO
import com.example.tmdb.data.db.MovieDAO
import com.example.tmdb.data.db.TvShowDAO
import com.example.tmdb.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdb.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdb.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdb.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdb.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdb.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.tmdb.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdb.data.repository.tvShow.dataSourceImpl.TvShowLocalDataSourceImpl
import com.example.tmdb.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDAO)

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource =
        ArtistLocalDataSourceImpl(artistDAO)

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource =
        TvShowLocalDataSourceImpl(tvShowDAO)
}