package com.example.tmdb.data.repository.artist.dataSource

import android.util.Log
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.model.tvShow.TvShow
import com.example.tmdb.data.model.tvShow.TvShowList
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdb.domain.repository.ArtistRepository
import com.example.tmdb.domain.repository.TvShowRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? = getArtistFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsFromDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistFromApi(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                return artistList
            }
        } catch (e: Exception) {
            Log.i("mytag", e.message.toString())
        }

        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (e: Exception) {
            Log.i("mytag", e.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistsFromDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (e: Exception) {
            Log.i("mytag", e.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}