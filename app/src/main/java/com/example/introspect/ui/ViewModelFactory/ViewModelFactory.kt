package com.example.introspect.ui.ViewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.introspect.ui.viewmodels.AccountLookupViewModel

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AccountLookupViewModel::class.java)) {
            return AccountLookupViewModel(application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown Viewmodel class")

    }
}

