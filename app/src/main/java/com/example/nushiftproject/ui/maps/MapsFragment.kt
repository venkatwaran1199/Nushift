package com.example.nushiftproject.ui.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.nushiftproject.R
import com.example.nushiftproject.databinding.FragmentMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(),OnMapReadyCallback {

    private var Mbinding:FragmentMapsBinding? = null
    private val binding get() = Mbinding!!
    private lateinit var map:GoogleMap
    private val args:MapsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Mbinding = FragmentMapsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val lat = args.CurrItem.lat
        val long = args.CurrItem.lon
        val sydney = LatLng(lat.toDouble(), long.toDouble())
        map.setInfoWindowAdapter(CustomInfoAdapter(requireContext()))
        map.addMarker(MarkerOptions()
            .position(sydney)
            .title("Name: ${args.CurrItem.name}")
            .snippet("State: ${args.CurrItem.state}"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f))
        //map.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Mbinding = null
    }
}