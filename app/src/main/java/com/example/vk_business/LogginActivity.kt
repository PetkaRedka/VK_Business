package com.example.vk_business

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.smb.glowbutton.GlowButton


open class LogginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loggin_view)

        // Убираем верхнюю полоску
        supportActionBar?.hide()
        // Делаем приложение на весь экран
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убираем кнопки снизу
        if (Build.VERSION.SDK_INT >= 19) {window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)}

        val loggin_button: GlowButton = findViewById(R.id.sign_in_button)
        loggin_button.setOnClickListener {
            val intent = Intent(this@LogginActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

}

