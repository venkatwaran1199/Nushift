package com.example.nushiftproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.nushiftproject.R

class MainActivity : AppCompatActivity() {
    private lateinit var navcontroller:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navhostfragment = supportFragmentManager.findFragmentById(R.id.navhostfragment) as NavHostFragment
        navcontroller = navhostfragment.findNavController()
        setupActionBarWithNavController(navcontroller)
    }

    override fun onNavigateUp(): Boolean {
        return navcontroller.navigateUp() || super.onNavigateUp()
    }
}