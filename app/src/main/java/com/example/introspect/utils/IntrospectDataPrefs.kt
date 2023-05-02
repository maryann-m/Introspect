package com.example.introspect.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

private const val INTROSPECT_PREFERENCE_DATA = "my_preference"


class IntrospectDataPrefs @Inject constructor(context: Context){
    val applicationContext = context.applicationContext

    private var prefs: SharedPreferences =
        context.getSharedPreferences(
            INTROSPECT_PREFERENCE_DATA,
            Context.MODE_PRIVATE
        )

    companion object {
        const val gone_through_onboarding: String = "gonethruOnboarding"
    }

    fun goneThruOnboarding(boolean: Boolean ) {
        val editor = prefs.edit()
        editor.putBoolean(gone_through_onboarding, boolean)
        editor.apply()
    }

    fun getGoneThruOnboarding(): Boolean {
        return prefs.getBoolean(gone_through_onboarding, false)
    }

}