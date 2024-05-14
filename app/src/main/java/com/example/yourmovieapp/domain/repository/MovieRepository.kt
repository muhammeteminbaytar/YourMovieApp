package com.example.yourmovieapp.domain.repository

import com.example.yourmovieapp.data.remote.dto.MovieDetailDto
import com.example.yourmovieapp.data.remote.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto

}