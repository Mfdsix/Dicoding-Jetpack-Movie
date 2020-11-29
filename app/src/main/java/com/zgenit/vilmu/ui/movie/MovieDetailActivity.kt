package com.zgenit.vilmu.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.viewmodel.ViewModelFactory

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
                val factory = ViewModelFactory.getInstance()
                val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
                val mainView : NestedScrollView = findViewById(R.id.main_view)
                val progressBar: ProgressBar = findViewById(R.id.progressbar)

                mainView.visibility = View.GONE
                progressBar.visibility = View.VISIBLE

                viewModel.getMovieById(movieId).observe(this, { movie ->
                    if(movie != null){
                        mainView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        populateMovie(movie)
                    }else{
                        Toast.makeText(this, getString(R.string.movie_not_found), Toast.LENGTH_SHORT).show()
                    }
                })
            }else{
                Toast.makeText(this, getString(R.string.id_not_valid), Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovie(movie: MovieEntity){
        supportActionBar?.title = movie.title

        val textTitle: TextView = findViewById(R.id.text_movie_title)
        val textCategory: TextView = findViewById(R.id.text_movie_category)
        val textYear: TextView = findViewById(R.id.text_movie_year)
        val textScore: TextView = findViewById(R.id.text_movie_score)
        val textOverview: TextView = findViewById(R.id.text_movie_overview)
        val imgPoster: ImageView = findViewById(R.id.img_movie_poster)
        val imgBackground: ImageView = findViewById(R.id.img_movie_background)

        textTitle.text = movie.title
        textCategory.text = movie.language
        textYear.text = movie.releaseDate
        textScore.text = "${movie.voteAverage}%"
        textOverview.text = movie.overview

        Glide.with(this)
                .load(movie.posterPath)
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                .into(imgPoster)
        Glide.with(this)
            .load(movie.posterPath)
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