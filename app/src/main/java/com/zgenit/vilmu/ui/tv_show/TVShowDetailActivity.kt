package com.zgenit.vilmu.ui.tv_show

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.TVShowEntity
import com.zgenit.vilmu.utils.DataDummy
import kotlinx.android.synthetic.main.content_detail_movie.*

class TVShowDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_TV_SHOW, 0)
            if (tvShowId != 0) {
                populateTVShow(DataDummy.getTVShowById(tvShowId))
            }
        }
    }

    fun populateTVShow(tvShow: TVShowEntity){
        if(actionBar != null){
            actionBar?.title = tvShow.title
        }

        text_title.text = tvShow.title
        text_category.text = tvShow.category

        Glide.with(this)
                .load(tvShow.img)
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                .into(image_poster)
    }
}