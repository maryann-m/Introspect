package com.example.introspect.ui.onboarding.account_setUp

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.introspect.databinding.FragmentEnterNameBinding
import com.example.introspect.ui.viewmodels.AccountLookupViewModel
import com.example.introspect.ui.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterNameFragment : Fragment() {

    private lateinit var binding: FragmentEnterNameBinding

    private lateinit var viewModel: AccountLookupViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentEnterNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(AccountLookupViewModel::class.java)


        initUI()
    }



    private fun initUI(){
        binding.cardBack.setOnClickListener { findNavController().navigateUp() }
        // binding.btnProceed.setOnClickListener{findNavController().navigate(R.id.action_enterNameFragment_to_DOBFragment)}


        binding.firstName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tvFirstName.text = binding.firstName.text.toString()
                viewModel.user.value?.firstName   = binding.firstName.text.toString()

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        binding.SecondName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tvSecondName.text = binding.SecondName.text.toString()
                viewModel.user.value?.secondName   = binding.tvSecondName.text.toString()
               // accountLookupViewModel.user.secondName = binding.SecondName.text.toString()

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}