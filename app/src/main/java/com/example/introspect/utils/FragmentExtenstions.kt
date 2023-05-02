package com.example.introspect.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.databinding.CustomActionbarNavFragmentsBinding
import com.example.introspect.databinding.DialogNetworkCallBinding
import com.example.introspect.databinding.DuoChoiceDialogBinding
import com.example.introspect.databinding.FragmentCustomDialogBinding


private lateinit var dialogBuilder: AlertDialog.Builder
private var dialog: AlertDialog? = null

fun Fragment.showDialog(bundle: Bundle? = null) {

    dialogBuilder = AlertDialog.Builder(requireContext(), R.style.BottomSheetDialog)
    val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val bind: DialogNetworkCallBinding = DialogNetworkCallBinding.inflate(inflater)
    dialogBuilder.setView(bind.root)
    dialog = dialogBuilder.create()
    dialog?.setCancelable(false)



    bind.apply {
        pbNetworkCall.setAnimation(R.raw.loader)
        pbNetworkCall.repeatCount = LottieDrawable.INFINITE
        pbNetworkCall.playAnimation()
    }
    dialog?.show()
}

fun Fragment.dialogPinsDontMatch() {

    dialogBuilder = AlertDialog.Builder(requireContext(), R.style.BottomSheetDialog)
    val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val bind: FragmentCustomDialogBinding = FragmentCustomDialogBinding.inflate(inflater)
    dialogBuilder.setView(bind.root)
    dialog = dialogBuilder.create()
    dialog?.setCancelable(false)



    bind.apply {
        btnProceed.setOnClickListener {
            dialog?.dismiss()
        }
    }
    dialog?.show()
}


fun Fragment.duoChoiceDialog(
    heading: String,
    desc: String,
    postiveText: String,
    negativeText: String
): Boolean {

    dialogBuilder = AlertDialog.Builder(requireContext(), R.style.BottomSheetDialog)
    val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val bind: DuoChoiceDialogBinding = DuoChoiceDialogBinding.inflate(inflater)
    dialogBuilder.setView(bind.root)
    dialog = dialogBuilder.create()
    dialog?.setCancelable(false)
    dialog?.show()

    var indicator = 1




    bind.apply {
        btnNegative.text = negativeText
        btnPostive.text = postiveText
        tvHeading.text = heading
        tvDescription.text = desc
        btnPostive.setOnClickListener {
           indicator = 1
            dialog?.dismiss()
            findNavController().navigate(R.id.loginFragment)
        }
        btnNegative.setOnClickListener {
            indicator = 0
            dialog?.dismiss()
        }
    }


    if(indicator == 1){
        return true
    }else{
        return false
    }

}


fun Fragment.hideDialog() {
    if (dialog != null) {
        dialog!!.dismiss()
    }
}

fun Fragment.notifyUser(mescolor_Primary: String) =
    Toast.makeText(requireActivity(), mescolor_Primary, Toast.LENGTH_SHORT).show()


 fun Fragment.setUpBottomNavActionBar(
    actionBar: CustomActionbarNavFragmentsBinding,
    name:Int,
    desc:Int

){

    actionBar.tvDescription.text = resources.getString(desc)
     actionBar.Name.text = resources.getString(name)
}