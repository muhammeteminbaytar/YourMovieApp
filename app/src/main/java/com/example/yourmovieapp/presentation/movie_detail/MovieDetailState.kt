package com.example.yourmovieapp.presentation.movie_detail

import com.example.yourmovieapp.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = ""
)