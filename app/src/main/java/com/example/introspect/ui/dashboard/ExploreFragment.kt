package com.example.introspect.ui.dashboard

import android.content.Context
import android.graphics.ColorFilter
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.SimpleColorFilter
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback
import com.example.introspect.R
import com.example.introspect.databinding.DialogAddGoalBinding
import com.example.introspect.databinding.FragmentCustomDialogBinding
import com.example.introspect.databinding.FragmentExploreBinding
import com.example.introspect.utils.notifyUser


class ExploreFragment : Fragment() {


    private lateinit var dialogBuilder: AlertDialog.Builder
    private var dialog: AlertDialog? = null
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

        binding.CreateGoal.setOnClickListener {
            dialogAddGoal()
        }

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


    private fun dialogAddGoal(){
        dialogBuilder = AlertDialog.Builder(requireContext())
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bind: DialogAddGoalBinding = DialogAddGoalBinding.inflate(inflater)
        dialogBuilder.setView(bind.root)
        dialog = dialogBuilder.create()
        dialog?.setCancelable(true)



        bind.apply {
            btnProceed.setOnClickListener {

                if(TextUtils.isEmpty(bind.firstName.text)){
                    notifyUser("Please enter a goal name")
                }else{
                    dialog?.dismiss()

                    val bundle = Bundle()
                    bundle.putString("goal_name_EXTRA", bind.firstName.text.toString())
                    findNavController().navigate(R.id.addGoalFragment, bundle)
                }

            }
        }
        dialog?.show()
    }

}