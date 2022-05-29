package com.example.vk_business.metrick.budget

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vk_business.R

class budget_graph_fragment : Fragment() {

    companion object {
        fun newInstance() = budget_graph_fragment()
    }

    private lateinit var viewModel: BudgetGraphViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.budget_graph_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BudgetGraphViewModel::class.java)
        // TODO: Use the ViewModel
    }

}