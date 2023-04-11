package com.example.introspect.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.introspect.R
import com.example.introspect.databinding.FragmentDataAndSyncBinding
import com.example.introspect.utils.setUpBottomNavActionBar

class DataAndSyncFragment : Fragment() {


    private lateinit var binding:FragmentDataAndSyncBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDataAndSyncBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBottomNavActionBar(
            binding.actionBar,
            R.string.data_and_sync,
            R.string.data_and_sync_desc
        )
    }



}