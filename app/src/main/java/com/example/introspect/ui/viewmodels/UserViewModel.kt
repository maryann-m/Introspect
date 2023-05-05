package com.example.introspect.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.introspect.data.local_models.User
import com.example.introspect.data.repostory.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel@Inject constructor(
    private val repository: Repository,
    private val app: Application

):AndroidViewModel(app) {

     fun addUser(user: User) = repository.addUser(user)

     fun readUser() = repository.readUser()
}