package com.example.tmdb.presentation.di.core

import com.example.tmdb.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdb.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdb.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdb.data.repository.artist.dataSource.ArtistRepositoryImpl
import com.example.tmdb.data.repository.movie.MovieRepositoryImpl
import com.example.tmdb.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdb.data.repository.tvShow.TvShowRepositoryImpl
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdb.domain.repository.ArtistRepository
import com.example.tmdb.domain.repository.MovieRepository
import com.example.tmdb.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}