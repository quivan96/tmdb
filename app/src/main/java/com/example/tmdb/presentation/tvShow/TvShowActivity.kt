package com.example.tmdb.presentation.tvShow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityTvShowBinding
import com.example.tmdb.presentation.di.Injector
import com.example.tmdb.presentation.movie.MovieViewModel
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter

    @Inject
    lateinit var factory: TvShowViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        initRecyclerView()



        Log.i("mytag", "+++++++++++ Tv Show Activity +++++++++++++")

    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayTvShows()
    }

    private fun displayTvShows() {
        binding.movieRecyclerView.visibility = View.VISIBLE
        val responseLiveData = viewModel.getTvShow()

        responseLiveData.observe(this, Observer {
            if(it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()

            }
        })
    }
}