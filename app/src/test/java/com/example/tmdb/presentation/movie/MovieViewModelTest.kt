package com.example.tmdb.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.movie.FakeMovieRepository
import com.example.tmdb.domain.useCase.GetMoviesUseCase
import com.example.tmdb.domain.useCase.UpdateMoviesUseCase
import com.example.tmdb.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)

        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        var movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "poster_path1", "release_date1", "title1"))
        movies.add(Movie(2, "overview2", "poster_path2", "release_date2", "title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()

        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList() {
        var movies = mutableListOf<Movie>()
//        movies.add(Movie(1, "overview1", "poster_path1", "release_date1", "title1"))
//        movies.add(Movie(2, "overview2", "poster_path2", "release_date2", "title2"))
        movies.add(Movie(3, "overview3", "poster_path3", "release_date3", "title3"))
        movies.add(Movie(4, "overview4", "poster_path4", "release_date4", "title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()

        assertThat(updatedList).isEqualTo(movies)
    }
}