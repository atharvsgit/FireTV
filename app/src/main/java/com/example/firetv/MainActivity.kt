package com.example.firetv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.firetv.ui.theme.FireTVTheme // Make sure this matches your theme's package name

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent is where you define your app's UI with Jetpack Compose
        setContent {
            // We wrap our entire UI in the theme we defined earlier
            FireTVTheme {
                RecommendationScreen()
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun RecommendationScreen() {
    // 1. We call our fake data source to get the list of rows to display.
    val recommendationRows = getFakeRecommendations()

    // 2. A Surface is a container that provides a background color from our theme.
    Surface(modifier = Modifier.fillMaxSize()) {

        // 3. TvLazyColumn is the TV-optimized vertical list. It will stack our
        //    RecommendationRow components on top of each other.
        TvLazyColumn(
            contentPadding = PaddingValues(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 4. This is the final loop. For each "RecommendationRow" in our data...
            items(recommendationRows) { row ->
                // ...we call the RecommendationRow composable we built!
                RecommendationRow(row = row)
            }
        }
    }
}