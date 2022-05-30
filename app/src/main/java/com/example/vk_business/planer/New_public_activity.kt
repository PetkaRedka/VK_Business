package com.example.vk_business.planer

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.vk_business.LogginActivity
import com.example.vk_business.R
import com.smb.glowbutton.NeonButton
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*


class New_public_activity: LogginActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    lateinit var textView: EditText
    lateinit var button: Button
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0

    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.planer_add)

        // Логика для кнопки загрузки изображения
        val download_image_button : NeonButton = findViewById(R.id.file_new_publication_button)
        download_image_button.setOnClickListener(){
            // openGalleryForImage()
        }

        title = "Введите дату и время публикации:"
        textView = findViewById(R.id.notification_add_new_publication)
        button = findViewById(R.id.plan_add_new_publication_button)

        button.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog = DatePickerDialog(this, R.style.MyPickerDialog,this, year, month,day)
            datePickerDialog.show()

            textView.setText("")
        }

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this, R.style.MyPickerDialog,this, hour, minute,
            DateFormat.is24HourFormat(this))
        timePickerDialog.show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        myHour = hourOfDay
        myMinute = minute
//        textView.setText("Year: $myYear\nMonth: $myMonth\nDay: $myDay\nHour: $myHour\nMinute: $myMinute")
        Toast.makeText(this, "Публикация успешно запланирована!\nДата: $myYear.$myMonth.$myDay\nВремя:$myHour:$myMinute", Toast.LENGTH_LONG).show()
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){

            val image: ImageView = findViewById(R.id.image_add_new_publication)
            image.setImageURI(data?.data) // handle chosen image

        }
    }
}

