package com.example.introspect.ui.dashboard.progress

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.introspect.R
import com.example.introspect.adapters.AccountSetUpAdapters
import com.example.introspect.adapters.ProgressTabAdapter
import com.example.introspect.databinding.FragmentProgressBinding
import com.google.android.material.tabs.TabLayout


class ProgressFragment : Fragment() {


    private lateinit var binding: FragmentProgressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpActionBar()
        initUi()
    }


    private fun setUpActionBar(){
        binding.actionBar.Name.text = resources.getString(R.string.progress)
        binding.actionBar.tvDescription.text = "4 goals set in the past 2 weeks"
    }


    private fun initUi(){
        val adapter = ProgressTabAdapter(requireActivity(), binding.tabLayoutTransferFunds.tabCount)

        binding.vpAccountSetUp.adapter = adapter
        binding.vpAccountSetUp.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
        {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onPageSelected(position: Int) {
                binding.tabLayoutTransferFunds.selectTab(binding.tabLayoutTransferFunds.getTabAt(position))

            }
        })

        binding.tabLayoutTransferFunds.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.vpAccountSetUp.currentItem = tab.position


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })



    }
}