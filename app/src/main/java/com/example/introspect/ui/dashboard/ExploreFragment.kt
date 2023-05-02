package com.example.introspect.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.databinding.FragmentExploreBinding


class ExploreFragment : Fragment() {

    private lateinit var binding:FragmentExploreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimation()
    }

    private fun setUpAnimation(){


        binding.apply {
            lottieAnimation.setAnimation(R.raw.create)
            lottieAnimation.repeatCount = LottieDrawable.INFINITE
            lottieAnimation.playAnimation()

        }
    }


}