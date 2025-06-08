package com.example.firetv

/**
 * Represents a single piece of content, like a movie or a TV show.
 *
 * @param id A unique identifier for the item.
 * @param title The title to be displayed.
 * @param posterUrl The web URL of the poster image.
 * @param tags A list of keywords used by our recommendation engine (e.g., "action", "evening").
 */
data class ContentItem(
    val id: String = "", // Default values are good practice for Firebase
    val title: String = "",
    val posterUrl: String = "",
    val tags: List<String> = emptyList()
)

/**
 * Represents a full horizontal row on our main screen.
 *
 * @param title The title of the row, e.g., "Trending Now".
 * @param items The list of ContentItem objects to display in this row.
 */
data class RecommendationRow(
    val title: String,
    val items: List<ContentItem>
)