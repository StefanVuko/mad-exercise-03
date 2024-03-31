package com.example.movieappmad24.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.findMovieById
import com.example.movieappmad24.navigation.Screen

class AppBars {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SimpleTopAppBar(isDetail: Boolean, movieId: String, navController: NavController, title: String) {

        if (isDetail) {
            val movie: Movie = findMovieById(movieId)!!
            CenterAlignedTopAppBar(
                title = {
                    Text(movie.title)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }

        else {
            CenterAlignedTopAppBar(
                title = { Text(title)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
    @Composable
    fun SimpleBottomAppBar(navController: NavController) {
        NavigationBar {
            NavigationBarItem(
                label = { Text("Home") },
                selected = true,
                onClick = {navController.navigate(route = Screen.Home.route) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Go to home"
                    )
                }
            )
            NavigationBarItem(
                label = { Text("Watchlist") },
                selected = false,
                onClick = { navController.navigate(route = Screen.Watchlist.route) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Go to watchlist"
                    )
                }
            )
        }
    }
}