package com.example.nushiftproject.ui.addnew

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nushiftproject.R
import com.example.nushiftproject.databinding.FragmentAddnewcityBinding
import com.example.nushiftproject.model.data.CityDataItem
import com.example.nushiftproject.model.repository.Retrofitrepository
import com.example.nushiftproject.model.utils.Retrofit_services
import com.example.nushiftproject.ui.home.HomeDirections
import com.example.nushiftproject.ui.home.RecyclerAdapter
import com.example.nushiftproject.ui.maps.MapsFragmentDirections
import com.example.nushiftproject.viewmodel.Retrofitviewmodel
import com.example.nushiftproject.viewmodel.Retrofitviewmodelfactory

class Addnewcity : Fragment() {

    private var Abinding:FragmentAddnewcityBinding? = null
    private val binding get() = Abinding!!
    private lateinit var retrofitviewmodel: Retrofitviewmodel
    private  val retrofitServices = Retrofit_services.getInstance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        Abinding =  FragmentAddnewcityBinding.inflate(inflater, container, false)
        retrofitviewmodel = ViewModelProvider(this, Retrofitviewmodelfactory(Retrofitrepository(retrofitServices))).get(Retrofitviewmodel::class.java)
        val adapter = RecyclerAdapter(retrofitviewmodel)

        binding.btnAddcity.setOnClickListener {
            val name = binding.edtName.text.toString()
            val state = binding.edtState.text.toString()
            val lat = binding.edtLatitude.text.toString()
            val long = binding.edtLongitude.text.toString()
            val validation = validateuser(name,state,lat,long)
            if(validation){
                Toast.makeText(requireContext(),"success",Toast.LENGTH_SHORT).show()
                val newcity = CityDataItem(lat,long,name,state)
                val action =AddnewcityDirections.actionAddnewcityToHome2(newcity)
                findNavController().navigate(action)
            }else{
                Toast.makeText(requireContext(),"Please fill all the fields",Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun validateuser(name: String, state: String, lat: String, long: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(state) || TextUtils.isEmpty(lat) || TextUtils.isEmpty(long))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Abinding = null
    }

}