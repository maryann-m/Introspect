package com.example.introspect.data.local_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User(
    @PrimaryKey(autoGenerate = false)
    val id:Int = 0,
    var firstName:String,
    var secondName:String,
    var dateOfBirth:String,
    val email:String? = null,
    var deviceID :String

)
