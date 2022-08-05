package com.example.textwatcherversion3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.textwatcherversion3.databinding.CarItemBinding
import com.example.textwatcherversion3.databinding.ManualCarItemBinding


class CarAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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


    val carrList = ArrayList<Car>()

    class CarHolder0(item: View) : RecyclerView.ViewHolder(item), CarHolder{
        val binding = CarItemBinding.bind(item)
        override fun bind(car:Car){
            println(car.imageIndex)
            binding.im.setImageResource(MassCar.imageIdList[car.imageIndex!!])
            binding.tvTitle.text=car.title
        }

    }
    interface CarHolder{
        fun bind(car:Car)
    }

    class CarHolder2(item: View) : RecyclerView.ViewHolder(item),CarHolder {
        val bindingManual = ManualCarItemBinding.bind(item)
        override fun bind(car: Car) {
            bindingManual.tvManual.text = car.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            if(getItemViewType(viewType)==0) {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.car_item, parent, false)
                view.setOnClickListener {
                    onCarClickListener?.onCarClick(carrList[index])
                }

                return CarHolder0(view)
            }

                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.manual_car_item, parent, false)
                return CarHolder2(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val index=getIndex()
        println(holder.javaClass)
        when(getItemViewType(position)) {
            0 -> {
                (holder as? CarHolder0)?.bind(car = Car(title = MassCar.titleList[index], description = "", imageIndex = index))
                println(index)
            }
            2->{
                (holder as? CarHolder2)?.bind(car = Car("", description = MassCar.descriptionList[index],null))
                println(index)
            }
        }
    }

    override fun getItemCount(): Int {
        return carrList.size
    }

    fun addCar(car: Car) {
        carrList.add(car)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2 * 2
    }
    interface OnCarClickListener {
        fun onCarClick(car: Car)
    }
}
