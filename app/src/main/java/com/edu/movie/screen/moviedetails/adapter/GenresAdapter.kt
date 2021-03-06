package com.edu.movie.screen.moviedetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.R
import com.edu.movie.data.model.Genres
import kotlinx.android.synthetic.main.item_movie_genre.view.*

class GenresAdapter : RecyclerView.Adapter<ItemGenreInMovieDetails>() {

    private val genres = mutableListOf<Genres>()
    private var onItemGenreClickListener: (Int, String) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemGenreInMovieDetails(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie_genre, parent, false)
    )

    override fun onBindViewHolder(holder: ItemGenreInMovieDetails, position: Int) {
        holder.registerOnItemGenreClickListener(onItemGenreClickListener)
        holder.bindData(genres[position])
    }

    override fun getItemCount() = genres.size

    fun registerData(genres: MutableList<Genres>) {
        this.genres.clear()
        this.genres.addAll(genres)
        notifyDataSetChanged()
    }

    fun registerItemGenreClickListener(onItemGenreClickListener: (Int, String) -> Unit) {
        this.onItemGenreClickListener = onItemGenreClickListener
    }
}

class ItemGenreInMovieDetails(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var onItemGenreClickListener: (Int, String) -> Unit = { _, _ -> }

    fun bindData(genre: Genres) {
        itemView.textViewGenresInMovie.text = genre.name
        itemView.setOnClickListener {
            if (genre.id != null && genre.name != null)
                onItemGenreClickListener(genre.id, genre.name)
        }
    }

    fun registerOnItemGenreClickListener(onItemGenreClickListener: (Int, String) -> Unit) {
        this.onItemGenreClickListener = onItemGenreClickListener
    }
}
