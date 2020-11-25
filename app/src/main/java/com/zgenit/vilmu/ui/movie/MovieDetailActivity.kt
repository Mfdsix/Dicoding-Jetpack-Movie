package com.zgenit.vilmu.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.movie.MovieEntity

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)
            if (movieId != 0) {
                val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
                val movie = viewModel.getMovieById(movieId)

                if(movie.success == true){
                    movie.data?.let { populateMovie(it) }
                }else{
                    Toast.makeText(this, movie.message, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "ID not valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovie(movie: MovieEntity){
        supportActionBar?.title = movie.title

        val textTitle: TextView = findViewById(R.id.text_movie_title)
        val textCategory: TextView = findViewById(R.id.text_movie_category)
        val textYear: TextView = findViewById(R.id.text_movie_year)
        val textDirector: TextView = findViewById(R.id.text_movie_director)
        val textDuration: TextView = findViewById(R.id.text_movie_duration)
        val textScore: TextView = findViewById(R.id.text_movie_score)
        val textOverview: TextView = findViewById(R.id.text_movie_overview)
        val imgPoster: ImageView = findViewById(R.id.img_movie_poster)
        val imgBackground: ImageView = findViewById(R.id.img_movie_background)

        textTitle.text = movie.title
        textCategory.text = movie.category
        textYear.text = movie.year.toString()
        textDirector.text = movie.director
        textDuration.text = movie.duration
        textScore.text = "${movie.userScore}%"
        textOverview.text = movie.description

        Glide.with(this)
                .load(movie.img)
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                .into(imgPoster)
        Glide.with(this)
            .load(movie.img)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(imgBackground)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}