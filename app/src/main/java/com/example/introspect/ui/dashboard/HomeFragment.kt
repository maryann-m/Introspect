package com.example.introspect.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.DashboardActivity
import com.example.introspect.R
import com.example.introspect.adapters.GoalAdapter
import com.example.introspect.databinding.FragmentHomeBinding
import com.example.introspect.ui.viewmodels.HomeViewModel
import com.example.introspect.utils.notifyUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {


    var isOpen:MutableStateFlow<Boolean> = MutableStateFlow(true)
    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var binding: FragmentHomeBinding
    private lateinit var goalAdapter: GoalAdapter
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setUpNavDrawer()
        setUpAnimation()
        setUpAdapter()
        setUpUI()

        lifecycleScope.launch {
            isOpen.collect {
                if(binding.homeRootDrawer.isDrawerOpen(GravityCompat.START)){
                    isOpen.value = true
                    notifyUser(isOpen.value.toString())
                    Log.i("Is open", "true")
                }else {
                    isOpen.value = false
                    notifyUser(isOpen.value.toString())
                    Log.i("Is open", "false")
                }
            }
        }
    }





    private fun setUpUI(){
        binding.myProfile.setOnClickListener {
            //DashboardActivity().openDrawer()
        /**/ }




    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpAnimation(){

        binding.llQuotes.setOnClickListener {
            findNavController().navigate(R.id.goalsFragment)
        }
        binding.apply {
            lottie2.setAnimation(R.raw.blobenvelopebrown)
            lottie2.repeatCount = LottieDrawable.INFINITE
            lottie2.playAnimation()

            lottieProgress.setAnimation(R.raw.graph)
            lottieProgress.repeatCount = LottieDrawable.INFINITE
            lottieProgress.playAnimation()
        }
    }



    private fun setUpAdapter() = binding.rvGoals.apply {
        goalAdapter = GoalAdapter(homeViewModel.goals)
        adapter = goalAdapter
        layoutManager = LinearLayoutManager(requireContext())

    }

}