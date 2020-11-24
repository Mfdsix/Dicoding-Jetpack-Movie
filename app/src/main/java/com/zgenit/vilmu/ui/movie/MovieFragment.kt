package com.zgenit.vilmu.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zgenit.vilmu.R
import kotlinx.android.synthetic.main.fragment_movie.*

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

            if(movies.success == true){
                academyAdapter.setDatas(movies.datas)

                with(rv_movie) {
                    layoutManager = GridLayoutManager(context, 2)
                    setHasFixedSize(true)
                    adapter = academyAdapter
                }
            }else{
                Toast.makeText(context, movies.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}