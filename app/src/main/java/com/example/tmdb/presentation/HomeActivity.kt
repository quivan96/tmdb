package com.example.tmdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityHomeBinding
import com.example.tmdb.presentation.artist.ArtistActivity
import com.example.tmdb.presentation.movie.MovieActivity
import com.example.tmdb.presentation.tvShow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieBtn.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistBtn.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

        binding.tvShowBtn.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        Log.i("mytag", "$$$$$$$$ Home Activity $$$$$$$$$$$")
    }
}