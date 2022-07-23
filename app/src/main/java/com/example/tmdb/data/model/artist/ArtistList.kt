package com.example.tmdb.data.model.artist


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val movies: List<Artist>
)