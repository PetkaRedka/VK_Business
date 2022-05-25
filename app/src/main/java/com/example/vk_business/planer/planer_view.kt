package com.example.vk_business.planer

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.vk_business.R

class planer_view : Fragment() {

    companion object {
        fun newInstance() = planer_view()
    }

    private lateinit var viewModel: PlanerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View = inflater.inflate(R.layout.fragment_planer2, container, false)
        val add_new_button : Button = v.findViewById(R.id.planer_add_button)
        add_new_button.setOnClickListener() {
            val intent = Intent(activity, New_public_activity::class.java)
            startActivity(intent)
        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlanerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}