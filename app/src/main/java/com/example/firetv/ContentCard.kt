package com.example.firetv

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import coil.compose.AsyncImage
import androidx.compose.material3.icons.Icons
import androidx.compose.material3.icons.filled.PlayCircle


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ContentCard(item: ContentItem) {
    var isFocused by remember { mutableStateOf(false) }

    Box {
        Card(
            onClick = { /* We'll add an action here later */ },
            modifier = Modifier
                .width(180.dp)
                .padding(12.dp)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .scale(if (isFocused) 1.1f else 1.0f)
        ) {
            Column {
                AsyncImage(
                    model = item.posterUrl,
                    contentDescription = item.title,
                    modifier = Modifier.aspectRatio(270f / 400f),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        if (isFocused) {
            Icon(
                imageVector = Icons.Filled.PlayCircle,
                contentDescription = "Play",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(48.dp),
                tint = Color.White.copy(alpha = 0.7f)
            )
        }
    }
}
