package com.example.introspect.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.DashboardActivity
import com.example.introspect.R
import com.example.introspect.databinding.FragmentLoginBinding
import com.example.introspect.utils.dialogPinsDontMatch
import com.example.introspect.utils.duoChoiceDialog
import com.example.introspect.utils.notifyUser
import java.util.concurrent.Executor


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var stage = 0
    private var pin = ""
    private var pinConfrim = ""
    private var one1: String? = null
    private var two2: String? = null
    private var three3: String? = null
    private var four4: String? = null
    private var isDone = false

    //private val customDialogFragment = CustomDialogFragment()
    private var mConfirmPin: String? = null

    lateinit var executor: Executor
    lateinit var biometricPrompt: androidx.biometric.BiometricPrompt
    lateinit var promptInfo: androidx.biometric.BiometricPrompt.PromptInfo
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimation()
        setUpBiometric()
        initUI()
    }

    private fun setUpBiometric(){

        executor = ContextCompat.getMainExecutor(requireContext())

        biometricPrompt = androidx.biometric.BiometricPrompt(requireActivity(),
            executor,object :androidx.biometric.BiometricPrompt.AuthenticationCallback(){
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)

                    notifyUser(errString.toString())
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()

                    notifyUser("Authentication failed")
                }

                override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)

                    notifyUser("Authentication success")
                }
            })

        promptInfo = androidx.biometric.BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric login")
            .setDeviceCredentialAllowed(true)

            //.setSubtitle("\n\nLog in using fingerprint or face")
            //.setNegativeButtonText("Cancel")
            .build()
    }

    private fun setUpAnimation() {
        binding.apply {
            lottie1.setAnimation(R.raw.blobenvelopegreen)
            binding.lottie2.speed = 0.4F
            lottie1.repeatCount = LottieDrawable.INFINITE
            lottie1.playAnimation()
        }

        binding.apply {
            lottie2.setAnimation(R.raw.blobenvelopebrown)
            lottie2.repeatCount = LottieDrawable.INFINITE


            lottie2.playAnimation()
        }
    }

    private fun initUI() {

        binding.tvBiometric.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }

        binding.linearLayout2.apply {
            No0.setOnClickListener { numPad("0") }
            No1.setOnClickListener { numPad("1") }
            No2.setOnClickListener { numPad("2") }
            No3.setOnClickListener { numPad("3") }
            No4.setOnClickListener { numPad("4") }
            No5.setOnClickListener { numPad("5") }
            No6.setOnClickListener { numPad("6") }
            No7.setOnClickListener { numPad("7") }
            No8.setOnClickListener { numPad("8") }
            No9.setOnClickListener { numPad("9") }

            cvDelete.setOnClickListener { delete() }
        }

    }

    private fun numPad(entry: String) {

        binding.apply {
            when {
                one1 == null -> {

                    binding.pin1.startAnimation(setUpAnim(R.anim.fade_in))
                    binding.pin1.setImageResource(R.drawable.pin_selected)
                    one1 = entry
                }
                two2 == null -> {
                    binding.pin2.startAnimation(setUpAnim(R.anim.fade_in))
                    binding.pin2.setImageResource(R.drawable.pin_selected)
                    two2 = entry
                }
                three3 == null -> {
                    binding.pin3.startAnimation(setUpAnim(R.anim.fade_in))
                    binding.pin3.setImageResource(R.drawable.pin_selected)
                    three3 = entry
                }
                four4 == null -> {
                    binding.pin4.startAnimation(setUpAnim(R.anim.fade_in))
                    binding.pin4.setImageResource(R.drawable.pin_selected)
                    four4 = entry
                    isDone = true
                }
            }

            if (isDone) {

                if (stage == 0) {
                    pin = one1 + two2 + three3 + four4

                    if (pin.length == 4) {


                        val myIntent = Intent(requireActivity(), DashboardActivity::class.java)
                        requireActivity().startActivity(myIntent)
                    }
                    Log.i("Pin", pin)
                } else {
                    pinConfrim = one1 + two2 + three3 + four4
                    if (pinConfrim.length == 4) {


                        if (pinConfrim == pin) {

                            val timerValues = (500.toLong()..2500.toLong()).random()

                            /* showDialog()

                             Handler().postDelayed({hideDialog()}, timerValues)
                             Log.i("TimerValue", timerValues.toString())*/

                            Handler().postDelayed({
                                duoChoiceDialog(
                                    resources.getString(R.string.biometric),
                                    resources.getString(R.string.biometric2),
                                    resources.getString(R.string.add),
                                    resources.getString(R.string.later)
                                )
                            }, timerValues)
                            Log.i("TimerValue", timerValues.toString())

                            /* if( duoChoiceDialog(
                                     resources.getString(R.string.biometric),
                                     resources.getString(R.string.biometric2),
                                     resources.getString(R.string.add),
                                     resources.getString(R.string.later)
                                 )){
                                 notifyUser("Adding biometric...")
                             }else{
                                 notifyUser("You can always add biometric from the settings menu")
                             }*/


                        } else {
                            dialogPinsDontMatch()
                            //customDialogFragment.show(childFragmentManager, customDialogFragment.tag )
                            //DialogFragment.newInstance("Log put", "Are you sure you want to log out").show(parentFragmentManager, DialogFragment.TAG)
                            //notifyUser("Passwords dont match")
                            Handler().postDelayed({
                                binding.tvHeading.text = resources.getString(R.string.create_pin)
                                resetUI()
                                stage = 0
                            }, 500)
                        }
                    }
                }
            }
        }


    }


    private fun delete() {
        binding.apply {

            if (mConfirmPin != null && mConfirmPin!!.length > 0) {

                mConfirmPin = mConfirmPin!!.substring(0, mConfirmPin!!.length - 1)
            }
            if (four4 != null) {
                binding.pin4.startAnimation(setUpAnim(R.anim.fade_out))
                binding.pin4.setImageResource(R.drawable.pin_background)
                four4 = null
                isDone = false
            } else if (three3 != null) {
                binding.pin3.startAnimation(setUpAnim(R.anim.fade_out))
                binding.pin3.setImageResource(R.drawable.pin_background)
                three3 = null
            } else if (two2 != null) {
                binding.pin2.startAnimation(setUpAnim(R.anim.fade_out))
                binding.pin2.setImageResource(R.drawable.pin_background)
                two2 = null
            } else if (one1 != null) {
                binding.pin1.startAnimation(setUpAnim(R.anim.fade_out))
                binding.pin1.setImageResource(R.drawable.pin_background)
                one1 = null
            }
        }
    }

    private fun setUpAnim(anim: Int): Animation {
        return AnimationUtils.loadAnimation(requireContext(), anim)
    }


    private fun resetUI() {
        binding.pin4.setImageResource(R.drawable.pin_background)
        binding.pin3.setImageResource(R.drawable.pin_background)
        binding.pin2.setImageResource(R.drawable.pin_background)
        binding.pin1.setImageResource(R.drawable.pin_background)


        one1 = null
        two2 = null
        three3 = null
        four4 = null
        isDone = false
    }
}