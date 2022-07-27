package com.example.tmdb.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdb.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDAO
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest(): Unit = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "poster_path1", "release_date1", "title1"),
            Movie(2, "overview2", "poster_path2", "release_date2", "title2"),
            Movie(3, "overview3", "poster_path3", "release_date3", "title3")
        )
        dao.saveMovies(movies)

        val allMoviews = dao.getMovies()
        Truth.assertThat(allMoviews).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest(): Unit = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "poster_path1", "release_date1", "title1"),
            Movie(2, "overview2", "poster_path2", "release_date2", "title2"),
            Movie(3, "overview3", "poster_path3", "release_date3", "title3")
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()

        val moviesResult = dao.getMovies()

        Truth.assertThat(moviesResult).isEmpty()
    }

}