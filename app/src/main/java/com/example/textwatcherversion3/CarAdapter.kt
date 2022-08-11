package com.example.textwatcherversion3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.textwatcherversion3.databinding.CarItemBinding
import com.example.textwatcherversion3.databinding.ManualCarItemBinding
import java.lang.IllegalStateException


class CarAdapter(private val arrayList: ArrayList<AdapterModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClick: ((AdapterModel) -> Unit)? = null

    private inner class ManualCarHolder(item: View) :
        RecyclerView.ViewHolder(item){
        var message: TextView? = itemView.findViewById(R.id.tvManual)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(arrayList[layoutPosition])
            }
        }
        fun onBindView(item: AdapterModel.ManualCar) {
            val recyclerViewModel = arrayList[layoutPosition]
            message?.text = item.description
        }

    }

    private inner class CarHolder(item: View) :
        RecyclerView.ViewHolder(item) {
        var message: TextView? = itemView.findViewById(R.id.tvTitle)
        var imageView:ImageView?=itemView.findViewById(R.id.im)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(arrayList[adapterPosition])
            }
        }
        fun onBindView(item: AdapterModel.Car) {
//            val recyclerViewModel = arrayList[layoutPosition]
            message?.text = item.description
            imageView?.setImageResource(R.drawable.pc2)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(viewType, parent, false)
        return when(viewType){
            R.layout.car_item-> CarHolder(parent.inflate(R.layout.car_item))
            R.layout.manual_car_item->ManualCarHolder(parent.inflate(R.layout.manual_car_item))
            else -> { throw IllegalStateException("Shit")}
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val item = arrayList[position]
        when(holder){
            is CarHolder ->(holder as CarHolder).onBindView(item as AdapterModel.Car)
            is ManualCarHolder->(holder as ManualCarHolder).onBindView(item as AdapterModel.ManualCar)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    private fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    override fun getItemViewType(position: Int): Int = when(arrayList[position]){
        is AdapterModel.Car ->R.layout.car_item
        is AdapterModel.ManualCar->R.layout.manual_car_item
        null->throw IllegalStateException("unknown view")
    }

}