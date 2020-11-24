package com.zgenit.vilmu.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.movie.MovieEntity
import kotlinx.android.synthetic.main.content_detail_movie.*

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

        text_title.text = movie.title
        text_category.text = movie.category
        text_year.text = movie.year.toString()
        text_director.text = movie.director
        text_duration.text = movie.duration
        text_score.text = "${movie.userScore}%"
        text_overview.text = movie.description

        Glide.with(this)
                .load(movie.img)
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                .into(img_poster)
        Glide.with(this)
            .load(movie.img)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_background)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}