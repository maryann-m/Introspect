package com.example.introspect.data.repostory

import com.example.introspect.data.database.Introspect_DataBase
import com.example.introspect.data.local_models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(private val appDatabase: Introspect_DataBase)
 {

    //Add User
    fun addUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase.userDao().addUser(user)
        }

    }

    //Update User
    fun readUser() :Flow<User>{
             return  appDatabase.userDao().readAllData()
        }

    }

