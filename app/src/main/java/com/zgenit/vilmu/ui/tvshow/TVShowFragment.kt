package com.zgenit.vilmu.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zgenit.vilmu.R
import com.zgenit.vilmu.viewmodel.ViewModelFactory

class TVShowFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]
            val tvShows = viewModel.getTVShows()

            val tvShowAdapter = TVShowAdapter()
            val rvTVShow : RecyclerView? = view?.findViewById(R.id.rv_tv_show)

            tvShowAdapter.setDatas(tvShows)
            if(rvTVShow != null) {
                with(rvTVShow) {
                    layoutManager = GridLayoutManager(context, 2)
                    setHasFixedSize(true)
                    adapter = tvShowAdapter
                }
            }
        }
    }
}