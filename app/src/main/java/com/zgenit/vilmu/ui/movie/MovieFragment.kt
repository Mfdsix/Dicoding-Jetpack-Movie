package com.zgenit.vilmu.ui.movie

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

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movies =viewModel.getMovies()
            val academyAdapter = MovieAdapter()
            val rvMovie : RecyclerView? = view?.findViewById(R.id.rv_movie)

            if(movies.success == true){
                academyAdapter.setDatas(movies.datas)

                if(rvMovie != null) {
                    with(rvMovie) {
                        layoutManager = GridLayoutManager(context, 2)
                        setHasFixedSize(true)
                        adapter = academyAdapter
                    }
                }
            }else{
                Toast.makeText(context, movies.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}