package com.example.introspect.ui.dashboard

import android.graphics.ColorFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.SimpleColorFilter
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback
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



        /*binding.lottie3.apply {
            speed =1F
            changeLayersColor(R.color.white)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()}

        binding.lottie4.apply {
            speed =1F
            changeLayersColor(R.color.white)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()}*/
    }


    fun LottieAnimationView.changeLayersColor(
        @ColorRes colorRes: Int
    ) {
        val color = ContextCompat.getColor(context, colorRes)
        val filter = SimpleColorFilter(color)
        val keyPath = KeyPath("**")
        val callback: LottieValueCallback<ColorFilter> = LottieValueCallback(filter)

        addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback)
    }


}