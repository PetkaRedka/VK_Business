package com.example.vk_business.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vk_business.R


class search_view : Fragment() {

    val headers: Array<String> = arrayOf("Suzuki.SA: Мы любим создавать машины...",
        "ThreadUP: Полностью новый гардероб...",
        "Parlor Skis: В погоне за идеальным поворотом...",
        "Caterpillar: Контроль качества руды...",
        "BookBup: Примите участие в 30-секундной викторине...")

    val texts: Array<String> = arrayOf("Мы любим создавать машины, которые вы любите водить. Поэтому мы разрабатываем функциональные автомобили для различных стилей жизни. Suzuki использует новейшие технологии в области энергии, электроники, информационных систем и систем управления, чтобы выпускать новое поколение автомобилей, с которыми вы ощутите радость жизни.",
    "30 секунд. 10 долларов. Полностью новый гардероб. Подарочные коробки от ThredUP предлагают крутые скидки и радость приодеться без труда! Для вас мы подбираем стильные вещи и спецпредложения. Вы платите за то, что вам понравилось. Пройдите наш тест по стилю и закажите подарочную коробку сегодня.",
    "В погоне за идеальным поворотом и лучшей траекторией мы вручную изготавливаем лыжи. Освободите время для демо-дня, расспросите друзей о нас или приходите на завод в Восточном Бостоне, чтобы посмотреть, что  здесь происходит.",
    "Контроль качества руды. Встроенная система взвешивания. Помощник прохождения уклонов. Измерение полезной нагрузки. В наши дни управление машиной ー это гораздо больше, чем перевозка железок по строительной площадке.",
    "Примите участие в 30-секундной викторине, и мы покажем до 7 книг, которые, по нашему мнению, вам в первую очередь стоит прочитать.\n" +
            "\n" +
            "Которая из этих?\n" +
            "\n" +
            "Найдите лучшие книги для меня!")

    val images = listOf(R.drawable.suzuki, R.drawable.thredup, R.drawable.parlor_skis, R.drawable.catepillar, R.drawable.bookbup)

    companion object {
        fun newInstance() = search_view()
    }

    private lateinit var viewModel: SearchViewViewModel

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View =  inflater.inflate(R.layout.fragment_search_view2, container, false)


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewViewModel::class.java)
        // TODO: Use the ViewModel
    }


}