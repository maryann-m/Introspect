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
import com.example.introspect.databinding.FragmentDashboardBinding
import com.example.introspect.utils.notifyUser
import com.sagarkoli.chetanbottomnavigation.chetanBottomNavigation
import com.sagarkoli.chetanbottomnavigation.chetanBottomNavigation.ShowListener
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()

        val navController = Navigation.findNavController(requireActivity(), R.id.myNavHost)
        binding.bottomNav.menu.getItem(2).isEnabled = false
        binding.bottomNav.setupWithNavController(navController)
        binding.btnExplore.setOnClickListener {

            findNavController().navigate(R.id.exploreFragment)
            notifyUser("Clicked")
        }

/*

        if( binding.bottomNav.menu.getItem(2).isChecked){
            findNavController().navigate(R.id.exploreFragment)
        }

*/

        binding.bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home -> {
                    navController.navigate(R.id.homeFragment2)
                    true}
                R.id.notifications -> {
                    navController.navigate(R.id.notificationsFragment2)
                    true}
                R.id.progress -> {
                    navController.navigate(R.id.progressFragment)
                    true}
                R.id.message -> {
                    navController.navigate(R.id.dataAndSyncFragment)
                    true}




                else->false
            }


        }





        navController.addOnDestinationChangedListener{ _, nd: NavDestination, _->
            if(nd.id == R.id.homeFragment2 || nd.id == R.id.notificationsFragment2|| nd.id == R.id.progressFragment || nd.id == R.id.exploreFragment || nd.id == R.id.dataAndSyncFragment){
                binding.bottomApp.visibility = View.VISIBLE
                binding.btnExplore.visibility = View.VISIBLE
            }else if(nd.id == R.id.homeFragment2  && HomeFragment().isOpen.value){
                binding.bottomApp.visibility = View.GONE
                binding.btnExplore.visibility = View.GONE
            }
            else{
                binding.bottomApp.visibility = View.GONE
                binding.btnExplore.visibility = View.GONE
            }

    }


}

    private fun setUpUI(){
        binding.btnExplore.setOnClickListener { findNavController().navigate(R.id.exploreFragment) }
    }
}

