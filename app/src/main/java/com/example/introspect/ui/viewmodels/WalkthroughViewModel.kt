package com.example.introspect.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.introspect.R
import com.example.introspect.data.local_models.WalkthroughModel

class WalkthroughViewModel:ViewModel() {

    val walkthroughModel = listOf(
        WalkthroughModel(

            head = "Create your dream life",
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
        ),
        WalkthroughModel(

            head = "Get your shit together",
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
        ),
        WalkthroughModel(

            head = "Hallelujah",
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
        ),
    )
}