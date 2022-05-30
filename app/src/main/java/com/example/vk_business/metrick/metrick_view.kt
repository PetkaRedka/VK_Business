package com.example.vk_business.metrick

import android.app.FragmentTransaction
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageButton
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vk_business.R
import com.example.vk_business.metrick.budget.budget_graph_fragment
import com.example.vk_business.metrick.likes.likes_graph_fragment
import com.example.vk_business.metrick.new_peaple.new_peaple_graph_fragment
import com.example.vk_business.metrick.reposts.reposts_graph_fragment


class metrick_view : Fragment(){

    companion object {
        fun newInstance() = metrick_view()
    }

    private lateinit var viewModel: MetrickViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val v: View = inflater.inflate(R.layout.fragment_metrick_view2, container, false)


        val butt_1: Button = v.findViewById(R.id.butt_1)
        val butt_2: Button = v.findViewById(R.id.butt_2)
        val butt_3: Button = v.findViewById(R.id.butt_3)
        val butt_4: Button = v.findViewById(R.id.butt_4)

        butt_1.setOnClickListener(){

            val fragment: Fragment = likes_graph_fragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.contentFragment, fragment)?.commit()

        }

        butt_2.setOnClickListener(){

            val fragment: Fragment = budget_graph_fragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.contentFragment, fragment)?.commit()

        }

        butt_3.setOnClickListener(){

            val fragment: Fragment = reposts_graph_fragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.contentFragment, fragment)?.commit()

        }

        butt_4.setOnClickListener(){

            val fragment: Fragment = new_peaple_graph_fragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.contentFragment, fragment)?.commit()

        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MetrickViewViewModel::class.java)
        // TODO: Use the ViewModel
    }


}