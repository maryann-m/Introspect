package com.example.introspect.ui.onboarding.account_setUp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.adapters.AccountSetUpAdapters
import com.example.introspect.databinding.FragmentAccountSetUpBinding
import com.google.android.material.tabs.TabLayout


class AccountSetUpFragment : Fragment() {


    private lateinit var binding: FragmentAccountSetUpBinding
    //private val accountLookupViewModel by lazy {  ViewModelProviders.of(this, ViewModelFactory(requireActivity().application))[AccountLookupViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = FragmentAccountSetUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimation()
        initUi()
    }

    private fun initUi(){
        val adapter = AccountSetUpAdapters(requireActivity(), binding.tabLayoutTransferFunds.tabCount)

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


    private fun setUpAnimation(){
        binding.apply {
            lottie1.setAnimation(R.raw.blobenvelopegreen)
            binding.lottie2.speed = 0.4F
            lottie1.repeatCount = LottieDrawable.INFINITE
            lottie1.playAnimation()
        }

        binding.apply {
            lottie2.setAnimation(R.raw.blobenvelopebrown)
            lottie2.repeatCount = LottieDrawable.INFINITE


            lottie2.playAnimation()
        }
    }
    }

