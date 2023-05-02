package com.example.introspect.ui.dashboard.goals

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.adapters.ProgressAdapter
import com.example.introspect.data.local_models.Progress
import com.example.introspect.databinding.BottomSheetDescriptionBinding
import com.example.introspect.databinding.DialogNetworkCallBinding
import com.example.introspect.databinding.DialogProgressItemBinding
import com.example.introspect.databinding.FragmentGoalsBinding
import com.example.introspect.ui.viewmodels.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_progress_item.*
import kotlinx.android.synthetic.main.duo_choice_dialog.*
import kotlinx.android.synthetic.main.duo_choice_dialog.tvDescription
import timber.log.Timber
import java.util.*


class GoalsFragment : Fragment() {

    private lateinit var binding:FragmentGoalsBinding
    private lateinit var dialogDescription: BottomSheetDialog
    private lateinit var dialogBuilder: AlertDialog.Builder
    private var dialog: AlertDialog? = null
    private lateinit var progressAdapter:ProgressAdapter
    private val homeViewModel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGoalsBinding.inflate(inflater,  container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        promptBottomDialogGoalDesription()
        setUpUI()
        setUpRecyclerView()
    }



    private  fun setUpUI(){
        binding.Name.setOnClickListener { promptBottomDialogGoalDesription() }
        binding.cardEdit.setOnClickListener { findNavController().navigate(R.id.editRoadMapFragment) }
    }


    private fun setUpRecyclerView() = binding.rvProgressItem.apply {
        progressAdapter = ProgressAdapter(homeViewModel.goals.first().progress)
        adapter = progressAdapter
        layoutManager = LinearLayoutManager(requireContext())

        progressAdapter.onItemClick = {
            promptDialogProgress(it)
        }
    }

    private fun promptBottomDialogGoalDesription() {
        dialogDescription = BottomSheetDialog(requireContext(),R.style.BottomSheetDialog)
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bind: BottomSheetDescriptionBinding = BottomSheetDescriptionBinding.inflate(inflater)
        dialogDescription.setCancelable(true)
        dialogDescription.setContentView(bind.root)
        dialogDescription.show()


        bind.apply {
            lottie2.setAnimation(R.raw.blobenvelopegreen)
            lottie2.repeatCount = LottieDrawable.INFINITE
            lottie2.playAnimation()
        }


}

    private fun promptDialogProgress(progress: Progress) {
        dialogBuilder = AlertDialog.Builder(requireContext())
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bind: DialogProgressItemBinding = DialogProgressItemBinding.inflate(inflater)
        dialogBuilder.setView(bind.root)
        dialog = dialogBuilder.create()
        dialog?.setCancelable(true)
        dialog?.show()


        bind.apply {
            tvHeading.text = progress.name
            tvStartDate.text = progress.startDate
            tvEndDate.text = progress.endDate
            tvStatus.text = progress.isCurrent.toString()
            btnNegative.setOnClickListener {
                dialog?.dismiss()
            }
        }

    }
}