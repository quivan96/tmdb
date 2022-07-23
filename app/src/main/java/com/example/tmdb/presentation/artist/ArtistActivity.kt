package com.example.tmdb.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.tmdb.R
import com.example.tmdb.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        Log.i("mytag", "+++++++++++ Artist Activity +++++++++++++")

    }
}