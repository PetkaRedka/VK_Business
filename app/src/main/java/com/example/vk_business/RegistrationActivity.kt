package com.example.vk_business

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mvp.handyopinion.URIPathHelper
import com.smb.glowbutton.NeonButton
import de.hdodenhof.circleimageview.CircleImageView

class RegistrationActivity: Activity() {

    val REQUEST_CODE = 1
    var image_path= "default"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_view)

        // Устанавливаем фото профиля
        val photo_button: NeonButton = findViewById(R.id.profile_settings_button)
        photo_button.setOnClickListener(){
            openGalleryForImage()
        }

        val login_et: EditText = findViewById(R.id.registration_login)
        val pass_et: EditText = findViewById(R.id.registration_password)
        val reg_button: Button = findViewById(R.id.registration_button)

        reg_button.setOnClickListener(){

            if (login_et.text.isEmpty() == false && pass_et.text.isEmpty() == false){

                // Добавляем пользователя в базу
                val login = login_et.text.toString()
                val pass = pass_et.text.toString()
                val db = DB_Helper_LAP(this, null)
                db.addPerson(login, pass, image_path)

                // Сообщаем об успешной регистрации пользователя
                Toast.makeText(this, login + " успешно зарегистрирован!", Toast.LENGTH_LONG).show()

                val intent = Intent(this@RegistrationActivity, LogginActivity::class.java)
                startActivity(intent)}

            else{
                Toast.makeText(this, "Ввдеите логин и пароль!", Toast.LENGTH_LONG).show()
            }
        }
    }

    // Открываем галлерею и достаем фото
    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){

            val profile_image: CircleImageView = findViewById(R.id.registration_profile_image)
            profile_image.setImageURI(data?.data) // handle chosen image

            image_path = data?.data.toString()

        }
    }

}