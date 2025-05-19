package com.tuno_appsmusic.features.home.presentation.pages

import java.util.Calendar

fun getGreeting(): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 4..10 -> "Good Morning"
        in 11..15 -> "Good Afternoon"
        in 16..18 -> "Good Evening"
        else -> "Good Night"
    }
}
