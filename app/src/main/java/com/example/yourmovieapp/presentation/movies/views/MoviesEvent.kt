package com.example.yourmovieapp.presentation.movies.views

sealed class MoviesEvent {
    data class Search(val searchString : String) : MoviesEvent()
}