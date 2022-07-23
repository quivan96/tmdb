package com.example.tmdb.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.domain.useCase.GetMoviesUseCase
import com.example.tmdb.domain.useCase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies(): LiveData<List<Movie>?> = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies(): LiveData<List<Movie>?> = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}