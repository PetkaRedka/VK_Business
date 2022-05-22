package com.example.vk_business.metrick

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vk_business.R

class metrick_view : Fragment() {

    companion object {
        fun newInstance() = metrick_view()
    }

    private lateinit var viewModel: MetrickViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_metrick_view2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MetrickViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}