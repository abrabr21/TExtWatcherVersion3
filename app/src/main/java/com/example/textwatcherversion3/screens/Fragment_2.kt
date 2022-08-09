package com.example.textwatcherversion3.screens

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater)
//        displayMessage = arguments?.getString("message")
//        binding.displayMessage.text=displayMessage
//        val adapter = CarAdapter(MainActivity, dataList)
//        init()
        val dataList = ArrayList<AdapterModel>()
        for(i in 0..20){
             dataList.add(AdapterModel.CarModel(car = Car(1,"MB")))
             dataList.add(AdapterModel.ManualCarModel(manualCar = ManualCar("MB means Mercedes Benz")))

        }
//dataList.add(Car(CarAdapter.VIEW_TYPE_ONE, "1. Hi! I am in View 1"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_TWO, "2. Hi! I am in View 2"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_ONE, "3. Hi! I am in View 3"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_TWO, "4. Hi! I am in View 4"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_ONE, "5. Hi! I am in View 5"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_TWO, "6. Hi! I am in View 6"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_ONE, "7. Hi! I am in View 7"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_TWO, "8. Hi! I am in View 8"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_ONE, "9. Hi! I am in View 9"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_TWO, "10. Hi! I am in View 10"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_ONE, "11. Hi! I am in View 11"))
//dataList.add(Car(CarAdapter.VIEW_TYPE_TWO, "12. Hi! I am in View 12"))
        val adapter=CarAdapter(binding.root.context,dataList)
        recyclerView=binding.rcView
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        recyclerView.adapter = adapter
        var itemFrag:DialogFragment=ItemFrag()
        adapter.onItemClick={
            val bundle =Bundle()
//            bundle.putString("message",dataList[adapter.getIndex()].description)
//            println(bundle.putString("message", dataList[adapter.getIndex()].description))
            itemFrag.arguments=bundle
            itemFrag.show(childFragmentManager,"")
//            Log.d("LOG",dataList[adapter.getIndex()].description)
        }
        return binding.root
    }
//    private fun init(){
//        binding.apply {
//
//            rcView.layoutManager= LinearLayoutManager(context)
//            rcView.adapter= adapter
//            buttonAdd.setOnClickListener{
//                if(index==2) index=0
//                val car = Car("","",index)
//                adapter.addCar(car)
//                index++
//            }
//        }
//    }

}