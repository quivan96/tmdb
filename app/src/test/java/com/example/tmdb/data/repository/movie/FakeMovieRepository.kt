package com.example.tmdb.data.repository.movie

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {

    private var movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "overview1", "poster_path1", "release_date1", "title1"))
        movies.add(Movie(2, "overview2", "poster_path2", "release_date2", "title2"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(3, "overview3", "poster_path3", "release_date3", "title3"))
        movies.add(Movie(4, "overview4", "poster_path4", "release_date4", "title4"))
        return movies
    }
}