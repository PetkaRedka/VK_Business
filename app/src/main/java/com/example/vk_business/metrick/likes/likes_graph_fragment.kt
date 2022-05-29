package com.example.vk_business.metrick.likes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vk_business.R

class likes_graph_fragment : Fragment() {

    companion object {
        fun newInstance() = likes_graph_fragment()
    }

    private lateinit var viewModel: LikesGraphViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.likes_graph_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LikesGraphViewModel::class.java)
        // TODO: Use the ViewModel
    }

}