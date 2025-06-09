package com.example.firetv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class ContentAdapter(private val items: List<ContentItem>) :
    RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    /**
     * The ViewHolder represents a single item in our list. It holds the references
     * to the views (ImageView, TextView) inside our item_content_card.xml layout,
     * so we don't have to look them up repeatedly.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.card_image)
        val titleView: TextView = view.findViewById(R.id.card_title)
    }

    /**
     * This function is called by the RecyclerView when it needs a new ViewHolder.
     * It "inflates" (creates) our XML layout from the item_content_card.xml file.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_card, parent, false)
        return ViewHolder(view)
    }

    /**
     * This function returns the total number of items in our data set.
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * This function is called by the RecyclerView to display the data at a specific position.
     * It takes the data for one item and "binds" it to the views in the ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data for the current item
        val item = items[position]

        // Set the text of the TextView from our data
        holder.titleView.text = item.title

        // Use the Coil library to load the image from the URL into the ImageView
        holder.imageView.load(item.posterUrl) {
            crossfade(true) // Add a nice fade-in effect
        }
    }
}