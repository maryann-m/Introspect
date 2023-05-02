package com.example.introspect.ui.onboarding

import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.introspect.R
import com.example.introspect.adapters.WalkthroughAdapter
import com.example.introspect.databinding.FragmentWalkthroughBinding
import com.example.introspect.ui.viewmodels.WalkthroughViewModel

class WalkthroughFragment : Fragment() {

    private lateinit var binding: FragmentWalkthroughBinding
    private val viewModel by viewModels<WalkthroughViewModel>()
    private lateinit var walkthroughAdapter: WalkthroughAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWalkthroughBinding.inflate(inflater,container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
        initUI()
    }


    private fun initUI(){

    }


    private fun setUpViewPager(){
        walkthroughAdapter = WalkthroughAdapter(viewModel.walkthroughModel)
        binding.ViewPager.adapter = walkthroughAdapter
        binding.Indicator.setViewPager2(binding.ViewPager)

        binding.ViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
        {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onPageSelected(position: Int) {
                if (position == 2){

                    binding.btnProceed.startAnimation(setUpAnim(R.anim.fade_in))
                    binding.btnProceed.visibility = View.VISIBLE

                    binding.btnProceed.setOnClickListener{findNavController().navigate(R.id.accountSetUpFragment)}


                }else {

                    if(binding.btnProceed.isVisible){
                        binding.btnProceed.startAnimation(setUpAnim(R.anim.fade_out))
                        binding.btnProceed.visibility = View.GONE
                    }

                }

            }
        })
    }

    private fun setUpAnim(anim:Int): Animation
    {
        return AnimationUtils.loadAnimation(requireContext(), anim)
    }



}