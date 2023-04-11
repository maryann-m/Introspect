package com.example.introspect.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.introspect.data.local_models.Goal
import com.example.introspect.data.local_models.Progress

class HomeViewModel : ViewModel() {

    val goals = listOf(
        Goal(
            name = "Learning JetpackCompose",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            progress = arrayListOf(
                Progress(
                    name = "JetpackCompose Overview",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Analyze gradle dependencies",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Mutable State Flow.",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Deploy app",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                )
            ),
            progressValue = 30
        ),

        Goal(
            name = "Learn how to swim",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            progress = arrayListOf(
                Progress(
                    name = "JetpackCompose Overview",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Analyze gradle dependencies",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Mutable State Flow.",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                ),
                Progress(
                    name = "Deploy app",
                    state = false,
                    isCurrent = true,
                    startDate = "10-02-2023",
                    endDate = "10-02-2023"
                )
            ),
            progressValue = 30
        ),


        )
}