package com.example.filmuygulama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmuygulama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private val movieList = ArrayList<Movie>()

    private val initialMovies = listOf(
        Movie("Yüzüklerin efendisi", "Peter Jackson", "10.0"),
        Movie("Film Başlığı 1", "Yönetmen 1", "7.5"),
        Movie("Film Başlığı 2", "Yönetmen 2", "9.2"),
        Movie("Film Başlığı 3", "Yönetmen 3", "6.5"),
        Movie("Film Başlığı 4", "Yönetmen 4", "8.8"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieList.addAll(initialMovies)

        movieAdapter = MovieAdapter(movieList)
        binding.recyclerView.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.addButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val director = binding.directorEditText.text.toString()
            val rating = binding.ratingEditText.text.toString()

            val newMovie = Movie(title, director, rating)
            movieList.add(newMovie)
            movieAdapter.notifyItemInserted(movieList.size - 1)

            clearInputFields()
        }
    }

    private fun clearInputFields() {
        binding.titleEditText.text.clear()
        binding.directorEditText.text.clear()
        binding.ratingEditText.text.clear()
    }
}