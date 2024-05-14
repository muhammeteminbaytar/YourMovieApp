package com.example.yourmovieapp.domain.use_case.get_movies

import com.example.yourmovieapp.data.remote.dto.toListMovie
import com.example.yourmovieapp.domain.model.Movie
import com.example.yourmovieapp.domain.repository.MovieRepository
import com.example.yourmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response == "True"){
                emit(Resource.Success(movieList.toListMovie()))
            }else {
                emit(Resource.Error("No Movie Found"))
            }
        }catch (_: IOError) {
            emit(Resource.Error("Internet Problem"))
        }
    }

}