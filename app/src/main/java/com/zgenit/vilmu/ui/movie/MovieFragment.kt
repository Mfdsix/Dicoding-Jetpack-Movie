package com.zgenit.vilmu.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zgenit.vilmu.R
import com.zgenit.vilmu.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(activity != null){
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            val rvMovie : RecyclerView? = view?.findViewById(R.id.rv_movie)
            val progressBar : ProgressBar? = view?.findViewById(R.id.progressbar)

            progressBar?.visibility = View.VISIBLE
            rvMovie?.visibility = View.GONE

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                movieAdapter.setDatas(movies)
                movieAdapter.notifyDataSetChanged()
                progressBar?.visibility = View.GONE
                rvMovie?.visibility = View.VISIBLE
            })

            if(rvMovie != null) {
                with(rvMovie) {
                    layoutManager = GridLayoutManager(context, 2)
                    setHasFixedSize(true)
                    adapter = movieAdapter
                }
            }
        }
    }
}