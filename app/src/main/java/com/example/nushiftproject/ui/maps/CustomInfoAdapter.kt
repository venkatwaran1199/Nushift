package com.example.nushiftproject.ui.maps

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.annotation.ContentView
import com.example.nushiftproject.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomInfoAdapter(context:Context):GoogleMap.InfoWindowAdapter {

    private val contentview = (context as Activity)
        .layoutInflater.inflate(R.layout.custom_info_window,null)

    override fun getInfoContents(marker: Marker): View? {
        renderingviews(marker,contentview)
        return contentview
    }

    override fun getInfoWindow(marker: Marker): View? {
        renderingviews(marker,contentview)
        return contentview
    }
    private fun renderingviews(marker: Marker?,contextview1:View){
        val title = marker?.title
        val state = marker?.snippet

        val titletextview = contextview1.findViewById<TextView>(R.id.txt_map_name)
        titletextview.text = title

        val statetextview = contextview1.findViewById<TextView>(R.id.txt_map_state)
        statetextview.text = state
    }

}