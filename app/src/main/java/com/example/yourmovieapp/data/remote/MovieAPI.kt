package com.example.yourmovieapp.data.remote

import com.example.yourmovieapp.data.remote.dto.MovieDetailDto
import com.example.yourmovieapp.data.remote.dto.MoviesDto
import com.example.yourmovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //https://www.omdbapi.com/?i=tt3896198&apikey=3bec5388&s=batman
    //https://www.omdbapi.com/?apikey=3bec5388&i=tt1877830
    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMoviesDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto

}