package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.components.AppBars
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen
import java.lang.reflect.Modifier

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun WatchlistScreen(navController: NavController) {

    var appbars = AppBars()
    Scaffold(
        topBar = {appbars.SimpleTopAppBar(isDetail = false, movieId = "", navController = navController, "Watchlist")},
        bottomBar = {
            appbars.SimpleBottomAppBar(navController = navController)
        },
        content = {
            MovieList(
                modifier = androidx.compose.ui.Modifier.padding(8.dp),
                movies = getMovies(),
                navController = navController
            )
        }
    )

}