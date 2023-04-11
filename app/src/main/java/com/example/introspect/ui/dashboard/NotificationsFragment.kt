package com.example.introspect.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {


    private lateinit var binding: FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimation()
    }

    private fun setUpAnimation(){


        binding.apply {
            lottieAnimation.setAnimation(R.raw.not_found)
            lottieAnimation.repeatCount = LottieDrawable.INFINITE
            lottieAnimation.playAnimation()

        }
    }

}