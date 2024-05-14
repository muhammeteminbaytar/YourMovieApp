package com.example.yourmovieapp.data.remote.dto

import com.example.yourmovieapp.domain.model.Movie

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDto.toListMovie(): List<Movie> {
    return Search.map { search ->
        Movie(search.Poster, search.Title, search.Year, search.imdbID)
    }
}