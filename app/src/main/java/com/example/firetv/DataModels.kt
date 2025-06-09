package com.example.firetv

/**
 * Represents a single piece of content, like a movie or a TV show.
 */
data class ContentItem(
    val id: String,
    val title: String,
    val posterUrl: String
)

/**
 * Represents a full horizontal row on our main screen.
 */
data class RecommendationRow(
    val title: String,
    val items: List<ContentItem>
)