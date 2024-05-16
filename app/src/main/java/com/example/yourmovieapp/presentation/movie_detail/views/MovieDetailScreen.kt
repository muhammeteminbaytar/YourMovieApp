package com.example.yourmovieapp.presentation.movie_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.yourmovieapp.presentation.movie_detail.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = movieDetailViewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        state.movie?.let {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = it.Poster),
                    contentDescription = it.Title
                )
                Modifier
                    .padding(16.dp)
                    .size(300.dp, 300.dp)
                    .clip(RectangleShape)
                    .align(Alignment.CenterHorizontally)

                Text(
                    text = it.Title, textAlign = TextAlign.Center, modifier = Modifier.padding(14.dp), color = Color.White
                )
                Text(
                    text = it.Year, textAlign = TextAlign.Center, modifier = Modifier.padding(14.dp), color = Color.White
                )
                Text(
                    text = it.Actors, textAlign = TextAlign.Center, modifier = Modifier.padding(14.dp), color = Color.White
                )
                Text(
                    text = it.Country, textAlign = TextAlign.Center, modifier = Modifier.padding(14.dp), color = Color.White
                )
                Text(
                    text = it.Director, textAlign = TextAlign.Center, modifier = Modifier.padding(14.dp), color = Color.White
                )
                Text(
                    text = it.imdbRating, textAlign = TextAlign.Center, modifier = Modifier.padding(14.dp), color = Color.White
                )
            }


        }
        if (state.error.isNotEmpty()) {
            Text(
                text = state.error, textAlign = TextAlign.Center, modifier = Modifier.padding(14.dp), color = Color.White
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }
}