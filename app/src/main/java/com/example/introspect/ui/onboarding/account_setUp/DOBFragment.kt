package com.example.introspect.ui.onboarding.account_setUp

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.introspect.R
import com.example.introspect.databinding.FragmentDOBBinding
import com.example.introspect.ui.viewmodels.AccountLookupViewModel
import com.example.introspect.utils.notifyUser
import java.text.SimpleDateFormat
import java.util.*


class DOBFragment : Fragment() {


    private lateinit var binding:FragmentDOBBinding
    private val cal = Calendar.getInstance()
   // private val accountLookupViewModel = ViewModelProvider(requireActivity()).get(AccountLookupViewModel::class.java)
   // private val accountLookupViewModel:AccountLookupViewModel by viewModels(ownerProducer = {requireParentFragment()})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDOBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            initUi()
    }


    private fun initUi(){

        //binding.tvFirstName.text = accountLookupViewModel.user.firstName
        //binding.tvSecondName.text = accountLookupViewModel.user.secondName

            setupDatePicker()

    }


    private fun setupDatePicker() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                if(dayOfMonth.toString().length == 1){
                    val newDay ="0$dayOfMonth"
                    binding.pvDay.setText(newDay)
                }else{
                    binding.pvDay.setText(dayOfMonth.toString())
                }

                if(monthOfYear.toString().length == 1){
                    val newMonth ="0$monthOfYear"
                    binding.pvMonth.setText(newMonth)
                }else{
                    binding.pvMonth.setText(monthOfYear.toString())
                }


                binding.pvYear.setText(year.toString())
            }

        binding.ll2.setOnClickListener {
            DatePickerDialog(requireContext(),
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
    }


}

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.pvDay.setText(sdf.format(cal.time.date))
        binding.pvMonth.setText(sdf.format(cal.time.month))
        binding.pvYear.setText(sdf.format(cal.time.year))

       // val age =getAge(binding.etBirthDate.text.toString())

    }
}