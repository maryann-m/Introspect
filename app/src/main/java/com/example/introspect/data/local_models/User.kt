package com.example.introspect.data.local_models

data class User(
    var firstName:String,
    var secondName:String,
    val dateOfBirth:String,
    val email:String? = null,
    val deviceID :String

)
