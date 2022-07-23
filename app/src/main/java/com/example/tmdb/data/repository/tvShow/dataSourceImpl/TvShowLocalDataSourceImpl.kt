package com.example.tmdb.data.repository.tvShow.dataSourceImpl

import com.example.tmdb.data.db.TvShowDAO
import com.example.tmdb.data.model.tvShow.TvShow
import com.example.tmdb.data.model.tvShow.TvShowList
import com.example.tmdb.data.repository.tvShow.dataSource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDAO: TvShowDAO): TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowDAO.getTvShows()

    override suspend fun saveTvShowsFromDB(movies: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDAO.saveTvShows(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowDAO.deleteAlTvShows()
        }
    }
}