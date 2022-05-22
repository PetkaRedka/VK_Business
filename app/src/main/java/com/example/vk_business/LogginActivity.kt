package com.example.vk_business

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


open class LogginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loggin_view)

        supportActionBar?.hide()

        val loggin_button: Button = findViewById(R.id.sign_in_button)
        loggin_button.setOnClickListener {
            val intent = Intent(this@LogginActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

}

