package com.example.vk_business

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.vk_business.metrick.metrick_view
import com.example.vk_business.planer.planer_view
import com.example.vk_business.search.search_view
import com.smb.glowbutton.NeonButton

class ProfileActivity: LogginActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_main)

        val metricks_button : NeonButton = findViewById(R.id.profile_metricks_button)
        metricks_button.setOnClickListener(){

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, metrick_view()).addToBackStack(null).commit()
            }
        }
    }

}