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

    fun submitData(list : ArrayList<AdapterModel>){
        arrayList.clear()
        arrayList.addAll(list)
    }

    private inner class ManualCarHolder(item: View) :
        RecyclerView.ViewHolder(item){
        var message: TextView? = itemView.findViewById(R.id.tvManual)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(arrayList[layoutPosition])
            }
        }
        fun onBindView(item: AdapterModel) {
            val recyclerViewModel = arrayList[layoutPosition]
            message?.text = recyclerViewModel.toString()
        }

    }

    private inner class CarHolder(item: View) :
        RecyclerView.ViewHolder(item) {
        var message: TextView? = itemView.findViewById(R.id.textView)
        var imageView:ImageView?=itemView.findViewById(R.id.imageItem2)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(arrayList[layoutPosition])
            }
        }
        fun onBindView(item: AdapterModel) {
//            val recyclerViewModel = arrayList[layoutPosition]
            message?.text = (arrayList[layoutPosition] as Car).toString()
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
            is CarHolder ->holder.onBindView(item as AdapterModel.CarModel)
            is ManualCarHolder->holder.onBindView(item as AdapterModel.ManualCarModel)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    private fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    override fun getItemViewType(position: Int): Int = when(arrayList[position]){
        is AdapterModel.CarModel ->R.layout.car_item
        is AdapterModel.ManualCarModel->R.layout.manual_car_item
        null->throw IllegalStateException("unknown view")
    }

    interface OnCarClickListener {
        fun onCarClick(car: Car)
    }
}