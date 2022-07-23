package com.example.tmdb.domain.useCase

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}