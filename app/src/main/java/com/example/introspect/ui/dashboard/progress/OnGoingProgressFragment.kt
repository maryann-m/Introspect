package com.example.introspect.ui.dashboard.progress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.introspect.R
import com.example.introspect.databinding.FragmentOnGoingProgressBinding


class OnGoingProgressFragment : Fragment() {

    private lateinit var binding :FragmentOnGoingProgressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnGoingProgressBinding.inflate(inflater, container, false)
        return binding.root
    }


}