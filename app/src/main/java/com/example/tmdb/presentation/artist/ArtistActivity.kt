package com.example.tmdb.presentation.artist

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
import com.example.tmdb.databinding.ActivityArtistBinding
import com.example.tmdb.presentation.di.Injector
import com.example.tmdb.presentation.movie.MovieAdapter
import com.example.tmdb.presentation.movie.MovieViewModel
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter

    @Inject
    lateinit var factory: ArtistViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initRecyclerView()

        Log.i("mytag", "+++++++++++ Artist Activity +++++++++++++")

    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayArtists()
    }

    private fun displayArtists() {
        Toast.makeText(applicationContext, "Inside FUNCTION", Toast.LENGTH_LONG).show()
        binding.movieProgressBar.visibility = View.VISIBLE

        val responseLiveData = viewModel.getArtists()

        responseLiveData.observe(this, Observer {
            if(it !=null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Inside IF", Toast.LENGTH_LONG).show()
            }else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Inside ELSE", Toast.LENGTH_LONG).show()
            }
        })
    }
}