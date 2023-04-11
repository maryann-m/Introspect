package com.example.introspect.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.databinding.FragmentSplashFragmentBinding


class Splash_fragment : Fragment() {

    private lateinit var binding: FragmentSplashFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentSplashFragmentBinding.inflate(inflater, container,false)
            return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimation()
        binding.splashFragmentLottie.setOnClickListener {
            findNavController().navigate(R.id.action_splash_fragment_to_walkthroughFragment)
        }
    }


    private fun setUpAnimation(){
        binding.apply {
            splashFragmentLottie.setAnimation(R.raw.loader)
            splashFragmentLottie.repeatCount = LottieDrawable.INFINITE
            splashFragmentLottie.playAnimation()
        }
    }


}