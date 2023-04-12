package com.example.nushiftproject.ui.home

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nushiftproject.databinding.RecyclerContentBinding
import com.example.nushiftproject.model.data.CityDataItem
import com.example.nushiftproject.viewmodel.Retrofitviewmodel

class RecyclerAdapter(private val retrofitviewmodel: Retrofitviewmodel):RecyclerView.Adapter<RecyclerAdapter.myviewholder>() {

    var datalist = mutableListOf<CityDataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val binding = RecyclerContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myviewholder(binding)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        val curritem = datalist[position]
        holder.bind(curritem)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    class myviewholder(private val binding: RecyclerContentBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data1:CityDataItem){
            binding.citydataitem = data1
        }
    }

    fun setdata(data:List<CityDataItem>){
        datalist  = data.toMutableList()
        notifyDataSetChanged()
    }

    fun newAddeddata(newdata: CityDataItem) {
        val newValue = newdata
        datalist.add(newValue)
        notifyDataSetChanged()
    }
}