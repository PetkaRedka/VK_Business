package com.example.vk_business.metrick.likes

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.broooapps.graphview.CurveGraphConfig
import com.broooapps.graphview.CurveGraphView
import com.broooapps.graphview.models.GraphData
import com.broooapps.graphview.models.PointMap
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

        val v: View = inflater.inflate(R.layout.likes_graph_fragment, container, false)

        // Задаем внешний вид графика
        val curveGraphView: CurveGraphView = v.findViewById(R.id.likes_graph)
        curveGraphView.configure(
            CurveGraphConfig.Builder(activity as AppCompatActivity)
            .setAxisColor(R.color.vk_violet)                                             // Set X and Y axis line color stroke.
            .setIntervalDisplayCount(7)                                             // Set number of values to be displayed in X ax
            .setGuidelineCount(2)                                                   // Set number of background guidelines to be shown.
            .setGuidelineColor(R.color.vk_blue_light)                                 // Set color of the visible guidelines.
            .setNoDataMsg(" No Data ")                                              // Message when no data is provided to the view.
            .setxAxisScaleTextColor(android.R.color.transparent)                                  // Set X axis scale text color.
            .setyAxisScaleTextColor(R.color.vk_green)                                  // Set Y axis scale text color
            .setAnimationDuration(2000)                                             // Set animation duration to be used after set data.
            .build()
        )

        // Задаем координаты графика
        val pointMap = PointMap()
        pointMap.addPoint(0, 100)
        pointMap.addPoint(1, 500)
        pointMap.addPoint(4, 600)
        pointMap.addPoint(5, 800)

        val gd = GraphData.builder(activity as AppCompatActivity)
            .setPointMap(pointMap)
            .setGraphStroke(R.color.black)
            .setGraphGradient(R.color.vk_purple, R.color.vk_blue)
            .animateLine(true)
            .build()

        val p2 = PointMap()
        p2.addPoint(0, 140)
        p2.addPoint(1, 700)
        p2.addPoint(2, 100)
        p2.addPoint(3, 0)
        p2.addPoint(4, 190)

        val gd2 = GraphData.builder(activity as AppCompatActivity)
            .setPointMap(p2)
            .setGraphStroke(R.color.vk_purple)
            .setGraphGradient(R.color.vk_blue_light, R.color.vk_violet)
            .animateLine(true)
            .build()

        Handler().postDelayed(Runnable { curveGraphView.setData(5, 1000, gd, gd2) }, 250)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LikesGraphViewModel::class.java)
        // TODO: Use the ViewModel
    }

}