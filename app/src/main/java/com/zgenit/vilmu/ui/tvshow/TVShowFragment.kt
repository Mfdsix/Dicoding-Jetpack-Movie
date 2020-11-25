package com.zgenit.vilmu.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zgenit.vilmu.R

class TVShowFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TVShowViewModel::class.java]
            val tvShows = viewModel.getTVShows()
            val academyAdapter = TVShowAdapter()
            val rvTVShow : RecyclerView? = view?.findViewById(R.id.rv_tv_show)

            if(tvShows.success == true){
                academyAdapter.setDatas(tvShows.datas)

                if(rvTVShow != null) {
                    with(rvTVShow) {
                        layoutManager = GridLayoutManager(context, 2)
                        setHasFixedSize(true)
                        adapter = academyAdapter
                    }
                }
            }else{
                Toast.makeText(context, tvShows.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}