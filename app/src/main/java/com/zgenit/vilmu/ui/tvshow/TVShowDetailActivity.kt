package com.zgenit.vilmu.ui.tvshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.tvshow.TVShowEntity
import kotlinx.android.synthetic.main.content_detail_movie.*

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

        text_title.text = tvShow.title
        text_category.text = tvShow.category
        text_year.text = tvShow.year.toString()
        text_duration.text = tvShow.duration
        text_score.text = "${tvShow.userScore}%"
        text_overview.text = tvShow.description

        Glide.with(this)
                .load(tvShow.img)
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                .into(img_poster)
        Glide.with(this)
            .load(tvShow.img)
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