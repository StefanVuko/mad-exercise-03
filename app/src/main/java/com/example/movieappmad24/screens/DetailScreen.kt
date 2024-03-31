package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.models.findMovieById

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(movieId: String?, navController: NavController) {

    Scaffold(
        topBar = { appbars.SimpleTopAppBar(isDetail = true, movieId = movieId!!, navController = navController, "")},
        content = {
            Column {
                MovieRow(movie = findMovieById(movieId)!!)
                LazyRow {
                    items(findMovieById(movieId)!!.images) {
                            image -> AsyncImage(
                        model = image,
                        contentDescription = "Movie Images",
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .height(250.dp)
                    )
                    }
                }
            }
        }
    )

}