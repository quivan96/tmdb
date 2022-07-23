package com.example.tmdb.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityMovieBinding
import com.example.tmdb.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieViewModel

    @Inject
    lateinit var factory: MovieViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        val responseLiveData = viewModel.getMovies()

        responseLiveData.observe(this, Observer {
            Log.i("mytag", it.toString())
        })

        Log.i("mytag", "+++++++++++ Movie Activity +++++++++++++")
    }
}