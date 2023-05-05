package com.example.introspect.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.introspect.data.local_models.User

class AccountLookupViewModel(application: Application) : AndroidViewModel(application) {

    val user = MutableLiveData(
        User(
        firstName = "",
        secondName = "",
        dateOfBirth = "",
        deviceID = ""
    ))
}