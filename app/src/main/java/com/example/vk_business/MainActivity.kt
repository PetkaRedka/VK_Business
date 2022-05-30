package com.example.vk_business

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.hdodenhof.circleimageview.CircleImageView


class MainActivity: LogginActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_window)

        // Активируем нижнюю панель навигации
        val toolbar: Toolbar = findViewById(R.id.buttom_nav_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.hide()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.search_view2,
            R.id.metrick_view2,
            R.id.planer_view2
        ))

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Зададим кнопке профиля логику на переход на логин экран
        val profile_button : CircleImageView = findViewById(R.id.profile_image)

        // Открываем БД и ставим картинку, если необходимо
//        val image_path:String = intent.getStringExtra("image_path").toString()
//        profile_button.setImageURI(image_path.toUri())

        profile_button.setOnClickListener(){

            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
//            intent.putExtra("image_path", image_path)
            startActivity(intent)
        }

    }

}