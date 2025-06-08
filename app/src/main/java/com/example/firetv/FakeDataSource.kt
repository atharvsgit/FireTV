package com.example.firetv

/**
 * This function simulates the output of your recommendation engine.
 * It provides instant, hardcoded data so we can build the UI.
 */
fun getFakeRecommendations(): List<RecommendationRow> {

    // Let's create a list of items for our "Trending" row.
    val trendingItems = (1..10).map { number ->
        ContentItem(
            id = "t$number",
            title = "Trending Movie $number",
            // Using a placeholder image service to get varied poster images.
            // Each image will be 270x400 pixels. The '?random=' part gives us different images.
            posterUrl = "https://picsum.photos/270/400?random=$number",
            tags = listOf("action", "evening")
        )
    }

    // And another list of items for our "Comedy" row.
    val comedyItems = (11..20).map { number ->
        ContentItem(
            id = "c$number",
            title = "Comedy Show $number",
            posterUrl = "https://picsum.photos/270/400?random=$number",
            tags = listOf("comedy", "feel-good")
        )
    }

    // Now, create the list of rows.
    return listOf(
        RecommendationRow(title = "Trending Now", items = trendingItems),
        RecommendationRow(title = "Laugh Out Loud Comedies", items = comedyItems)
    )
}