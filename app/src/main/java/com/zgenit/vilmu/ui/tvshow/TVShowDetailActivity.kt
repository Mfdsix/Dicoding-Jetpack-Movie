package com.zgenit.vilmu.ui.tvshow

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
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity
import com.zgenit.vilmu.viewmodel.ViewModelFactory

class TVShowDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_TV_SHOW, 0)
            if (tvShowId != 0) {
                val factory = ViewModelFactory.getInstance()
                val viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]
                val mainView : NestedScrollView = findViewById(R.id.main_view)
                val progressBar: ProgressBar = findViewById(R.id.progressbar)

                mainView.visibility = View.GONE
                progressBar.visibility = View.VISIBLE

                viewModel.getTVShowVById(tvShowId).observe(this, { tvShow ->
                    if(tvShow != null){
                        mainView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        populateTVShow(tvShow)
                    }else{
                        Toast.makeText(this, getString(R.string.tv_show_not_found), Toast.LENGTH_SHORT).show()
                    }
                })

            }else{
                Toast.makeText(this, getString(R.string.id_not_valid), Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateTVShow(tvShow: TVShowEntity){
        supportActionBar?.title = tvShow.title

        val textTitle: TextView = findViewById(R.id.text_tv_show_title)
        val textCategory: TextView = findViewById(R.id.text_tv_show_category)
        val textYear: TextView = findViewById(R.id.text_tv_show_year)
        val textScore: TextView = findViewById(R.id.text_tv_show_score)
        val textOverview: TextView = findViewById(R.id.text_tv_show_overview)
        val imgPoster: ImageView = findViewById(R.id.img_tv_show_poster)
        val imgBackground: ImageView = findViewById(R.id.img_tv_show_background)

        textTitle.text = tvShow.title
        textCategory.text = tvShow.language
        textYear.text = tvShow.firstAirDate
        textScore.text = "${tvShow.voteAverage}%"
        textOverview.text = tvShow.overview

        Glide.with(this)
            .load(tvShow.posterPath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(imgPoster)
        Glide.with(this)
            .load(tvShow.posterPath)
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