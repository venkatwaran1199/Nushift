package com.example.nushiftproject.model.utils

import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.nushiftproject.model.data.CityDataItem
import com.example.nushiftproject.ui.home.HomeDirections
import com.example.nushiftproject.ui.maps.MapsFragmentDirections

class BindingAdapter {

    companion object{


        @androidx.databinding.BindingAdapter("android:send_to_mapsfragment")
        @JvmStatic
        fun senttomapsfragment(view:CardView,currdata:CityDataItem){
        view.setOnClickListener {
            val action = HomeDirections.actionHome2ToMapsFragment(currdata)
            view.findNavController().navigate(action)
        }
        }
    }
}