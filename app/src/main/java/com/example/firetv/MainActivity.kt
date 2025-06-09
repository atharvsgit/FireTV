package com.example.firetv

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : androidx.fragment.app.FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the "Recommended For You" RecyclerView
        setupRecommendedRow()

        // Setup the click listeners for our new navigation buttons
        setupClickListeners()
    }

    private fun setupRecommendedRow() {
        val recommendationRows = getFakeRecommendations()
        val recommendedRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_recommended)

        recommendedRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // The data now has only two rows, so index 1 is the "Recommended" data
        recommendedRecyclerView.adapter = ContentAdapter(recommendationRows[1].items)
    }

    private fun setupClickListeners() {
        // Find each button by its ID from the XML layout
        val profileButton = findViewById<ImageButton>(R.id.btn_profile)
        val searchButton = findViewById<ImageButton>(R.id.btn_search)
        val homeButton = findViewById<ImageButton>(R.id.btn_home)
        val bookmarksButton = findViewById<ImageButton>(R.id.btn_bookmarks)
        val exitButton = findViewById<ImageButton>(R.id.btn_exit)

        val netflixButton = findViewById<Button>(R.id.btn_netflix)
        val primeButton = findViewById<Button>(R.id.btn_prime)
        val huluButton = findViewById<Button>(R.id.btn_hulu)
        val allAppsButton = findViewById<ImageButton>(R.id.btn_all_apps)


        // Set an OnClickListener for each button.
        profileButton.setOnClickListener { showToast("Profile clicked") }
        searchButton.setOnClickListener { showToast("Search clicked") }
        homeButton.setOnClickListener { showToast("Home clicked") }
        bookmarksButton.setOnClickListener { showToast("Bookmarks clicked") }
        exitButton.setOnClickListener { showToast("Exit clicked") }

        netflixButton.setOnClickListener { showToast("Netflix clicked") }
        primeButton.setOnClickListener { showToast("Prime Video clicked") }
        huluButton.setOnClickListener { showToast("Hulu clicked") }
        allAppsButton.setOnClickListener { showToast("All Apps clicked") }
    }

    // A helper function to make showing Toasts easier
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}