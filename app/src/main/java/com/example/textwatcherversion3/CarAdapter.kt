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


class CarAdapter(context:Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }
    private val context: Context = context
    private var arrayList : ArrayList<AdapterModel> = ArrayList()
    var onItemClick: ((AdapterModel) -> Unit)? = null
    fun submitData(list : ArrayList<AdapterModel>){
        arrayList.clear()
        arrayList.addAll(list)
    }



    private var index: Int =1
    var onCarClickListener: OnCarClickListener? = null
    fun getIndex(): Int {
        if (index == 2) {
            index = 0
            return index
        }
        index++
        return index
    }


    private inner class ManualCarHolder(item: View) :
        RecyclerView.ViewHolder(item){
        var message: TextView = itemView.findViewById(R.id.tvManual)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(arrayList[adapterPosition])
            }
        }
        fun onBindView(item: AdapterModel) {
            val recyclerViewModel = arrayList[position]
            message.text = recyclerViewModel.toString()
        }

    }

    private inner class CarHolder(item: View) :
        RecyclerView.ViewHolder(item) {
        var message: TextView = itemView.findViewById(R.id.textView)
        var imageView:ImageView=itemView.findViewById(R.id.imageItem2)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(arrayList[adapterPosition])
            }
        }
        fun onBindView(item: AdapterModel) {
            val recyclerViewModel = arrayList[position]
            message.text = (arrayList[position] as Car).toString()
            imageView.setImageResource(R.drawable.pc2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(viewType, parent, false)
        return when(viewType){
            R.layout.car_item-> CarHolder(view)
            R.layout.manual_car_item->ManualCarHolder(view)
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


    override fun getItemViewType(position: Int): Int = when(arrayList[position]){
        is AdapterModel.CarModel ->R.layout.car_item
        is AdapterModel.ManualCarModel->R.layout.manual_car_item
        null->throw IllegalStateException("unknown view")
    }
    interface OnCarClickListener {
        fun onCarClick(car: Car)
    }
}
