package com.example.tmdb.data.repository.artist.dataSourceImpl

import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdb.data.repository.movie.dataSource.MovieCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

    override suspend fun getArtistsFromCache(): List<Artist> = artistList



}