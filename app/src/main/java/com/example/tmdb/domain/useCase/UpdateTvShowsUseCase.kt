package com.example.tmdb.domain.useCase

import com.example.tmdb.data.model.tvShow.TvShow
import com.example.tmdb.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}