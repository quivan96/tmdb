package com.example.tmdb.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.domain.useCase.GetTvShowsUseCase
import com.example.tmdb.domain.useCase.UpdateTvShowsUseCase
import java.lang.IllegalArgumentException

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TvShowViewModel::class.java)) {
            return TvShowViewModel(getTvShowUseCase, updateTvShowsUseCase) as T
        } else {
            throw IllegalArgumentException("Unknown View Model Class")
        }
    }
}