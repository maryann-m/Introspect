package com.example.introspect.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.introspect.R
import com.example.introspect.databinding.FragmentCustomDialogBinding
import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment


class CustomDialogFragment : BlurDialogFragment() {

    private lateinit var binding:FragmentCustomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCustomDialogBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnProceed.setOnClickListener{
            this.dismiss()
        }
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


}