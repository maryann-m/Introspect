package com.example.introspect.ui.dashboard.goals

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.databinding.BottomSheetDescriptionBinding
import com.example.introspect.databinding.FragmentAddGoalBinding
import com.example.introspect.utils.setUpBottomNavActionBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class AddGoalFragment : Fragment() {

    private lateinit var binding: FragmentAddGoalBinding
    private  var isDescriptionSet:MutableStateFlow<Boolean> = MutableStateFlow(false)
    private lateinit var dialogDescription: BottomSheetDialog
    private lateinit var dialogBuilder: AlertDialog.Builder
    private var dialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddGoalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        promptBottomDialogGoalDesription()
        val goalName = arguments?.getString("goal_name_EXTRA")
        setUpBottomNavActionBar(
            binding.actionBar,
           goalName.toString(),
            "0 tasks set to achieve"
        )


        lifecycleScope.launch {

            isDescriptionSet.collect{
                if(it){
                    binding.actionBar.cardDescription.apply{


                        visibility =View.VISIBLE
                        startAnimation(setUpAnim(R.anim.fade_in))
                    }
                }
            }

        }
    }


    private fun promptBottomDialogGoalDesription() {
        dialogDescription = BottomSheetDialog(requireContext(),R.style.BottomSheetDialog)
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bind: BottomSheetDescriptionBinding = BottomSheetDescriptionBinding.inflate(inflater)
        dialogDescription.setCancelable(true)
        dialogDescription.setContentView(bind.root)
        dialogDescription.show()

        bind.btnProceed.setOnClickListener {
            //  isDescriptionSet = MutableStateFlow(true)
            dialog?.dismiss()

        }
        bind.lottie2.visibility = View.GONE
        bind.progress2.visibility = View.GONE
        bind.dialogbackground.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        bind.name2.text = getString(R.string.add_description)
        bind.name2.setTextColor(resources.getColor(R.color.black))




    }

    private fun setUpAnim(anim: Int): Animation {
        return AnimationUtils.loadAnimation(requireContext(), anim)
    }


}