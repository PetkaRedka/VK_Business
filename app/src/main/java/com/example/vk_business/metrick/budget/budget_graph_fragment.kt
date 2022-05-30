package com.example.vk_business.metrick.budget

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vk_business.R
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel


class budget_graph_fragment : Fragment() {

    companion object {
        fun newInstance() = budget_graph_fragment()
    }

    private lateinit var viewModel: BudgetGraphViewModel

    lateinit var tvR: TextView
    lateinit var tvPython:TextView
    lateinit var tvCPP:TextView
    lateinit var tvJava:TextView
    lateinit var pieChart: PieChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v:View = inflater.inflate(R.layout.budget_graph_fragment, container, false)

        val tvR: TextView = v.findViewById(R.id.tvR);
        val tvPython: TextView = v.findViewById(R.id.tvPython);
        val tvCPP: TextView = v.findViewById(R.id.tvCPP);
        val tvJava: TextView = v.findViewById(R.id.tvJava);
        val pieChart: PieChart = v.findViewById(R.id.piechart);

        setData();

        return v
    }

    private fun setData() {

        // Set the percentage of language used
        tvR.setText(Integer.toString(40))
        tvPython.setText(Integer.toString(25))
        tvCPP.setText(Integer.toString(30))
        tvJava.setText(Integer.toString(5))

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
            PieModel(
                "Неосвоенный бюджет", tvR.getText().toString().toFloat(),
                Color.parseColor("#aaa")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "Телевизионная реклама", tvPython.getText().toString().toFloat(),
                Color.parseColor("#66BB6A")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "Реклама в социальных сетях", tvCPP.getText().toString().toFloat(),
                Color.parseColor("#FF0084")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "Наружная реклама", tvJava.getText().toString().toFloat(),
                Color.parseColor("#5281B9")
            )
        )

        // To animate the pie chart
        pieChart.startAnimation()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BudgetGraphViewModel::class.java)
        // TODO: Use the ViewModel
    }

}