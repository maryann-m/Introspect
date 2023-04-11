package com.example.introspect.data.local_models

data class Goal(
    val name:String,
    val description:String,
    val progressValue:Int,
    val progress:ArrayList<Progress>
)
