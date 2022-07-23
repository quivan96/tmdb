package com.example.tmdb.data.repository.artist.dataSourceImpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.db.ArtistDAO
import com.example.tmdb.data.db.TMDBDatabase
import com.example.tmdb.data.db.TMDBDatabase_Impl
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdb.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdb.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieCacheDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.geArtists(apiKey)
    }

}