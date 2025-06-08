package com.example.firetv

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun RecommendationRow(row: RecommendationRow) {
    // 1. We use a Column to stack the title vertically on top of the row of cards.
    Column(modifier = Modifier.padding(vertical = 16.dp)) {

        // 2. A Text composable to display the title of the row, e.g., "Trending Now".
        Text(
            text = row.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 24.dp) // Give the title some horizontal padding.
        )

        // 3. This is the TV-optimized horizontal lazy row. "Lazy" means it only renders
        //    the items currently on screen, making it super efficient for long lists.
        TvLazyRow(
            // We add some padding so the cards don't touch the screen edge.
            contentPadding = PaddingValues(horizontal = 12.dp),
            // This controls the spacing between each card in the row.
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 4. This is the loop. For every 'ContentItem' in our data...
            items(row.items) { item ->
                // 5. ...we call the ContentCard composable that we just built!
                // This is the power of component reuse.
                ContentCard(item = item)
            }
        }
    }
}