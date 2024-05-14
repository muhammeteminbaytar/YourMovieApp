package com.example.yourmovieapp.domain.use_case.get_movies_detail

import com.example.yourmovieapp.data.remote.dto.toListMovie
import com.example.yourmovieapp.data.remote.dto.toMovieDetail
import com.example.yourmovieapp.domain.model.Movie
import com.example.yourmovieapp.domain.model.MovieDetail
import com.example.yourmovieapp.domain.repository.MovieRepository
import com.example.yourmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository){
    fun executeGetDetailMovies(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movie.toMovieDetail()))
        }catch (_: IOError) {
            emit(Resource.Error("Internet Problem"))
        }
    }
}