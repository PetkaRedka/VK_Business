package com.example.vk_business

import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.vk_business.metrick.metrick_view
import com.example.vk_business.planer.planer_view
import com.example.vk_business.search.search_view
import com.smb.glowbutton.NeonButton
import de.hdodenhof.circleimageview.CircleImageView

class ProfileActivity: LogginActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_main)


        // Открываем БД и ставим картинку, если необходимо
 //       val profile_button : CircleImageView = findViewById(R.id.profile_profile_image)
//        val image_path:String = intent.getStringExtra("image_path").toString()
//        profile_button.setImageURI(image_path.toUri())
    }

}