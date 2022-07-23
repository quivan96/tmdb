package com.example.tmdb.data.repository.artist.dataSourceImpl

import com.example.tmdb.data.db.ArtistDAO
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.repository.artist.dataSource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistsDAO: ArtistDAO) : ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> = artistsDAO.getArtists()

    override suspend fun saveArtistsFromDB(artists: List<Artist>) {
        CoroutineScope(IO).launch {
            artistsDAO.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            artistsDAO.deleteAllArtists()
        }
    }

}