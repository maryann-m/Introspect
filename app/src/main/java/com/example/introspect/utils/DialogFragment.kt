package com.example.introspect.utils

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.introspect.R
import com.example.introspect.databinding.FragmentDialogBinding

class DialogFragment : androidx.fragment.app.DialogFragment() {

    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String): androidx.fragment.app.DialogFragment {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = androidx.fragment.app.DialogFragment()
            fragment.arguments = args
            return fragment
        }

    }


    private lateinit var binding :FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupClickListeners()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        dialog?.window?.setGravity(Gravity.CENTER)
        dialog?.window?.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
    }

    private fun setupView() {
        binding.tvTitle.text = arguments?.getString(KEY_TITLE)
        binding.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
    }

    private fun setupClickListeners() {
        binding.btnPositive.setOnClickListener {

            dismiss()
        }
        binding.btnNegative.setOnClickListener {

            dismiss()
        }
    }


}