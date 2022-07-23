package com.example.tmdb.data.repository.tvShow.dataSource

import com.example.tmdb.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>

}