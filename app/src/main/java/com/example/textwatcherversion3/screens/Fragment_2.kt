package com.example.textwatcherversion3.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.textwatcherversion3.*
import com.example.textwatcherversion3.databinding.Fragment2Binding


class Fragment_2 : Fragment() {
    lateinit var binding: Fragment2Binding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment2Binding.inflate(inflater)
        val dataList = ArrayList<AdapterModel>()

        for(i in 0..20){
             dataList.add(AdapterModel.Car ("MB",R.drawable.pc2))
             dataList.add(AdapterModel.ManualCar("MB means Mercedes Benz"))
        }

        var itemFrag:DialogFragment=ItemFrag()
        binding.rcView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rcView.adapter = CarAdapter(dataList).apply {
            onItemClick = {

                itemFrag.show(childFragmentManager,"dialog")

            }
        }

//        CarAdapter(dataList).onItemClick={
//            val bundle =Bundle()
//            itemFrag.show(childFragmentManager,"")
//            TODO("Transfer information to child dialog fragment")
//        }

        return binding.root
    }
}