package com.zgenit.vilmu.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.MovieEntity
import com.zgenit.vilmu.utils.DataDummy
import kotlinx.android.synthetic.main.content_detail_movie.*

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)
            if (movieId != 0) {
                populateMovie(DataDummy.getMovieById(movieId))
            }
        }
    }

    private fun populateMovie(movie: MovieEntity){
        if(actionBar != null){
            actionBar?.title = movie.title
        }

        text_title.text = movie.title
        text_category.text = movie.category

        Glide.with(this)
            .load(movie.img)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(image_poster)
    }
}