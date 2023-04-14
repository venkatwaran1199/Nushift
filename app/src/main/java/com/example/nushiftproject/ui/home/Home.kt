package com.example.nushiftproject.ui.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nushiftproject.R
import com.example.nushiftproject.databinding.FragmentHomeBinding
import com.example.nushiftproject.model.data.CityDataItem
import com.example.nushiftproject.model.repository.Retrofitrepository
import com.example.nushiftproject.model.utils.Retrofit_services
import com.example.nushiftproject.viewmodel.Retrofitviewmodel
import com.example.nushiftproject.viewmodel.Retrofitviewmodelfactory

class Home : Fragment() {

    private var Hbinding:FragmentHomeBinding? = null
    private val binding get() = Hbinding!!

    private lateinit var retrofitviewmodel:Retrofitviewmodel
    private  val retrofitServices = Retrofit_services.getInstance()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerAdapter
    private val args:HomeArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        Hbinding =  FragmentHomeBinding.inflate(inflater, container, false)
        retrofitviewmodel = ViewModelProvider(this,Retrofitviewmodelfactory(Retrofitrepository(retrofitServices))).get(Retrofitviewmodel::class.java)
        initrecycler()

        retrofitviewmodel.getcitydata()

        retrofitviewmodel.reporesult.observe(viewLifecycleOwner) {
            adapter.setdata(it)
            args.currnewdata?.let { it1 -> adapter.datalist.add(it1)
            adapter.notifyDataSetChanged()}
            }

        /*retrofitviewmodel.reporesult.observe(viewLifecycleOwner) {
            adapter.setdata(it)
            args.currnewdata?.let { it1 -> adapter.datalist.add(it1) }
            adapter.notifyDataSetChanged()
            //args.currnewdata?.let { it1 -> retrofitviewmodel.addIssuePost(it1)}
        }*/



/*        retrofitviewmodel.totaladdeddata.observe(viewLifecycleOwner){
            Log.d(TAG, "onCreateView: "+it)
        }*/


        //Checking
/*        val city = CityDataItem("12.2","12.2","venkat","tamilnadu")
        val city1 = CityDataItem("12.2","12.2","hindu","chennai")
        val city2 = CityDataItem("12.2","12.2","muslim","madurai")
        val city3 = CityDataItem("12.2","12.2","christian","thanjai")
        val city4 = CityDataItem("12.2","12.2","buddist","trichy")
        val city5 = CityDataItem("12.2","12.2","saddist","salem")
        val totaldata = mutableListOf<CityDataItem>()
         totaldata.add(city)
         totaldata.add(city1)
         totaldata.add(city2)
         totaldata.add(city3)
         totaldata.add(city4)
         totaldata.add(city5)
         args.currnewdata?.let { totaldata.add(it) }
         adapter.setdata(totaldata)*/



        binding.FABAddnewcity.setOnClickListener {
            /*val city55 = CityDataItem("12.2","12.2","finee","okayyy")
            adapter.newAddeddata(city55)
            adapter.notifyDataSetChanged()*/
            findNavController().navigate(R.id.action_home2_to_addnewcity)
        }

        binding.recyclerview.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_mapsFragment)
        }

        return binding.root
    }

    private fun initrecycler() {
        adapter = RecyclerAdapter(retrofitviewmodel)
        recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Hbinding = null
    }

}