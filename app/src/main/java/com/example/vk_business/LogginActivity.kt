package com.example.vk_business

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smb.glowbutton.GlowButton


open class LogginActivity : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loggin_view)

        // Делаем приложение на весь экран
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убираем кнопки снизу
        if (Build.VERSION.SDK_INT >= 19) {window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)}

        // Проверяем, заполнены ли оба поля
        val login_et: EditText = findViewById(R.id.login_text)
        val password_et: EditText = findViewById(R.id.password_text)
        val loggin_button: GlowButton = findViewById(R.id.sign_in_button)
        loggin_button.isEnabled = false

        login_et.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
            count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int){
                if (!login_et.text.isEmpty() && !password_et.text.isEmpty()){
                    loggin_button.enableWithAnimation()
                    loggin_button.isEnabled = true}
                else{
                    loggin_button.disableWithAnimation()
                    loggin_button.isEnabled = false}
            }

        })

        password_et.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int){
                if (!login_et.text.isEmpty() && !password_et.text.isEmpty()){
                    loggin_button.enableWithAnimation()
                    loggin_button.isEnabled = true}
                else{
                    loggin_button.disableWithAnimation()
                    loggin_button.isEnabled = false}
            }

        })

        loggin_button.setOnClickListener {

            // Проверяем соответствует ли логин пароль заявленным пользователям
            if (loggin_button.isEnabled){

                // Проверим, существует ли такой человечек в базе
                val db = DB_Helper_LAP(this, null)
                val cursor = db.getPerson()
                var login = "login"
                var pass = "password"

                try{
                    cursor!!.moveToFirst()
                    login = cursor.getString(cursor.getColumnIndex(DB_Helper_LAP.LOGIN_COL))
                    pass = cursor.getString(cursor.getColumnIndex(DB_Helper_LAP.PASS_COL))
                }
                catch (e: Exception){
                    Toast.makeText(this, "Не один пользователь не зарегистрирован!", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                while(cursor.moveToNext()){

                    if (login_et.text.toString() == login && password_et.text.toString() == pass){

                        val intent = Intent(this@LogginActivity, MainActivity::class.java)
//                        intent.putExtra("image_path", cursor.getString(cursor.getColumnIndex(DB_Helper_LAP.IMAGE_PATH_COL)))
                        startActivity(intent)
                        cursor.close()
                        return@setOnClickListener
                    }

                    login = cursor.getString(cursor.getColumnIndex(DB_Helper_LAP.LOGIN_COL))
                    pass = cursor.getString(cursor.getColumnIndex(DB_Helper_LAP.PASS_COL))

                }

                Toast.makeText(this, "Неправильые логин и пароль.\nВозможно пользователь не зарегистрирован!", Toast.LENGTH_LONG).show()
                cursor.close()
            }


            else{
                loggin_button.disableWithAnimation()
                loggin_button.enableWithAnimation()

                Toast.makeText(this, "Введите логин и пароль!", Toast.LENGTH_LONG).show()
            }
        }

        // Обработаем переход на экран регистрации
        val regist_text: TextView = findViewById(R.id.login_registration_text)
        regist_text.setOnClickListener(){
            val intent = Intent(this@LogginActivity, RegistrationActivity::class.java)
                startActivity(intent)}

    }
}


