package com.example.tmdb.domain.repository

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.model.tvShow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}