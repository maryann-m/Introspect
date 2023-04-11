package com.example.introspect.data.local_models

data class Progress(
    val name:String,
    val state:Boolean = false,
    val isCurrent:Boolean = false,
    val startDate:String,
    val endDate:String,

)
