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


class CarAdapter(context:Context,list: ArrayList<Car>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }
    private val context: Context = context
    var carlist: ArrayList<Car> = list
    var onItemClick: ((Car) -> Unit)? = null



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


    private inner class CarHolder0(item: View) :
        RecyclerView.ViewHolder(item){
        var message: TextView = itemView.findViewById(R.id.textView)
        var imageView:ImageView=itemView.findViewById(R.id.imageItem1)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(carlist[adapterPosition])
            }
        }
        fun bind(position: Int) {
            val recyclerViewModel = carlist[position]
            message.text = recyclerViewModel.description
            imageView.setImageResource(R.drawable.pc3)


        }

    }

    private inner class CarHolder1(item: View) :
        RecyclerView.ViewHolder(item) {
        var message: TextView = itemView.findViewById(R.id.textView)
        var imageView:ImageView=itemView.findViewById(R.id.imageItem2)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(carlist[adapterPosition])
            }
        }
        fun bind(position: Int) {
            val recyclerViewModel = carlist[position]
            message.text = recyclerViewModel.description
            imageView.setImageResource(R.drawable.pc2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
            return CarHolder0(
                LayoutInflater.from(context).inflate(R.layout.item_view_1, parent, false)
            )
        }
        return CarHolder1(
            LayoutInflater.from(context).inflate(R.layout.item_view_2, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (carlist[position].viewType === VIEW_TYPE_ONE) {
            (holder as CarHolder0).bind(position)
        } else {
            (holder as CarHolder1).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return carlist.size
    }

    fun addCar(car: Car) {
        carlist.add(car)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return carlist[position].viewType
    }
    interface OnCarClickListener {
        fun onCarClick(car: Car)
    }
}
