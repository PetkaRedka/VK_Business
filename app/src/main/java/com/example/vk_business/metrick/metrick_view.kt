package com.example.vk_business.metrick

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.vk_business.R
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class metrick_view : Fragment(){

    companion object {
        fun newInstance() = metrick_view()
    }

    private lateinit var viewModel: MetrickViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val v: View = inflater.inflate(R.layout.fragment_metrick_view2, container, false)

        val drawerLayout: DrawerLayout = v.findViewById(R.id.drawer_layout)
        val options_button: ImageButton = v.findViewById(R.id.metrick_options_button)
        options_button.setOnClickListener(){
            drawerLayout.openDrawer(Gravity.LEFT)
        }

        val navView: NavigationView = v.findViewById(R.id.metrick_nav_view)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(setOf(
                    R.id.likes_graph_view,
                    R.id.budget_graph_view,
                    R.id.reposts_graph_view,
                    R.id.new_peaple_graph_view
        ))
        setupActionBarWithNavController(activity as AppCompatActivity, navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MetrickViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}