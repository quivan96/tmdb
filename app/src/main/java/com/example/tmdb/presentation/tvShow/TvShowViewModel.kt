package com.example.tmdb.presentation.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.model.tvShow.TvShow
import com.example.tmdb.domain.useCase.GetTvShowsUseCase
import com.example.tmdb.domain.useCase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShow(): LiveData<List<TvShow>?> = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow(): LiveData<List<TvShow>?> = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}