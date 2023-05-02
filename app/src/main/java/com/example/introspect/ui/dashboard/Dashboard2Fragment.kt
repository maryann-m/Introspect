package com.example.introspect.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.introspect.R
import com.example.introspect.databinding.FragmentDashboard2Binding
import com.example.introspect.utils.notifyUser


class Dashboard2Fragment : Fragment() {


    private lateinit var binding:FragmentDashboard2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboard2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // setUpUI()
/*
        val navController = Navigation.findNavController(requireActivity(), R.id.myNavHostDashboard)
        binding.bottomNav.setupWithNavController(navController)



        if( binding.bottomNav.menu.getItem(2).isChecked){
            findNavController().navigate(R.id.exploreFragment)
        }


        binding.bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    true}
                R.id.explore -> {
                    navController.navigate(R.id.exploreFragment)
                    true}
                R.id.notifications2 -> {
                    navController.navigate(R.id.notificationsFragment)
                    true}
                R.id.progress -> {
                    navController.navigate(R.id.progressFragment)
                    true}
                R.id.mescolor_Primary -> {
                    navController.navigate(R.id.dataAndSyncFragment)
                    true}




                else->false
            }


        }


        navController.addOnDestinationChangedListener{ _, nd: NavDestination, _->
            if(nd.id == R.id.homeFragment|| nd.id == R.id.notificationsFragment|| nd.id == R.id.progressFragment || nd.id == R.id.exploreFragment || nd.id == R.id.dataAndSyncFragment){
                binding.bottomNav.visibility = View.VISIBLE

            }
            else{
                binding.bottomNav.visibility = View.GONE

            }

        }*/


    }



}