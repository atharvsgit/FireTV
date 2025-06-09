package com.example.firetv

fun getFakeRecommendations(): List<RecommendationRow> {
    val appItems = listOf(
        ContentItem(id = "app1", title = "Netflix", posterUrl = "https://picsum.photos/200/200?random=1"),
        ContentItem(id = "app2", title = "Prime Video", posterUrl = "https://picsum.photos/200/200?random=2"),
        ContentItem(id = "app3", title = "Disney+", posterUrl = "https://picsum.photos/200/200?random=3"),
        ContentItem(id = "app4", title = "YouTube", posterUrl = "https://picsum.photos/200/200?random=4"),
        ContentItem(id = "app5", title = "Hulu", posterUrl = "https://picsum.photos/200/200?random=5"),
    )

    // Changed this from actionItems to recommendedItems
    val recommendedItems = (11..20).map { number ->
        ContentItem(
            id = "rec$number",
            title = "Recommended Film $number", // Changed title
            posterUrl = "https://picsum.photos/270/400?random=${number + 40}"
        )
    }

    return listOf(
        RecommendationRow(title = "Your Apps & Channels", items = appItems),
        RecommendationRow(title = "Recommended For You", items = recommendedItems) // Changed title
    )
}