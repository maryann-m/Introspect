package com.example.introspect.utils

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings



@SuppressLint("HardwareIds")
fun Context.getDeviceId(): String {
    return Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
        .uppercase()
}
