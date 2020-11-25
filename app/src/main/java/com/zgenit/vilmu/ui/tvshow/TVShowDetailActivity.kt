package com.zgenit.vilmu.ui.tvshow

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
import com.zgenit.vilmu.data.tvshow.TVShowEntity

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
                val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TVShowViewModel::class.java]
                val tvShow = viewModel.getTVShowVById(tvShowId)

                if(tvShow.success == true){
                    tvShow.data?.let { populateTVShow(it) }
                }else{
                    Toast.makeText(this, tvShow.message, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "ID not valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateTVShow(tvShow: TVShowEntity){
        supportActionBar?.title = tvShow.title

        val textTitle: TextView = findViewById(R.id.text_tv_show_title)
        val textCategory: TextView = findViewById(R.id.text_tv_show_category)
        val textYear: TextView = findViewById(R.id.text_tv_show_year)
        val textDuration: TextView = findViewById(R.id.text_tv_show_duration)
        val textScore: TextView = findViewById(R.id.text_tv_show_score)
        val textOverview: TextView = findViewById(R.id.text_tv_show_overview)
        val imgPoster: ImageView = findViewById(R.id.img_tv_show_poster)
        val imgBackground: ImageView = findViewById(R.id.img_tv_show_background)

        textTitle.text = tvShow.title
        textCategory.text = tvShow.category
        textYear.text = tvShow.year.toString()
        textDuration.text = tvShow.duration
        textScore.text = "${tvShow.userScore}%"
        textOverview.text = tvShow.description

        Glide.with(this)
            .load(tvShow.img)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(imgPoster)
        Glide.with(this)
            .load(tvShow.img)
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