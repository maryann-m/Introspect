package com.example.introspect.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.introspect.data.local_models.User

class AccountLookupViewModel(application: Application): ViewModel() {

    val user = User(
        firstName = "",
        secondName = "",
        dateOfBirth = "",
        deviceID = ""
    )
}