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
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen
import java.lang.reflect.Modifier

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun WatchlistScreen(navController: NavController) {


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Your watchlist") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
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