package com.example.introspect.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.introspect.ui.onboarding.account_setUp.DOBFragment
import com.example.introspect.ui.onboarding.account_setUp.EnterNameFragment
import com.example.introspect.ui.onboarding.account_setUp.PINFragment

class AccountSetUpAdapters (activity: FragmentActivity, private val tabCount: Int): FragmentStateAdapter(activity){

    override fun getItemCount(): Int {
        return tabCount
    }
    override fun createFragment(position: Int): Fragment {
        return when(position)
        {
            0-> EnterNameFragment()
            1-> DOBFragment()
            else -> PINFragment()

        }
    }
}