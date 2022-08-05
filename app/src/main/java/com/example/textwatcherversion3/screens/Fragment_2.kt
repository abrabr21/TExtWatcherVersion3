package com.example.textwatcherversion3.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.textwatcherversion3.Car
import com.example.textwatcherversion3.CarAdapter
import com.example.textwatcherversion3.databinding.Fragment2Binding


class Fragment_2 : Fragment() {
    lateinit var binding: Fragment2Binding
    private val adapter = CarAdapter()
    var displayMessage:String?=""
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater)
        displayMessage = arguments?.getString("message")
        binding.displayMessage.text=displayMessage
        init()
        return binding.root
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager= LinearLayoutManager(context)
            rcView.adapter= adapter
            buttonAdd.setOnClickListener{
                if(index==2) index=0
                val car = Car("","",index)
                adapter.addCar(car)
                index++
            }
        }
    }

}