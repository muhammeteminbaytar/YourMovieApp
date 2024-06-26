package com.example.yourmovieapp.data.repository

import com.example.yourmovieapp.data.remote.MovieAPI
import com.example.yourmovieapp.data.remote.dto.MovieDetailDto
import com.example.yourmovieapp.data.remote.dto.MoviesDto
import com.example.yourmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMoviesDetail(imdbId = imdbId)
    }
}