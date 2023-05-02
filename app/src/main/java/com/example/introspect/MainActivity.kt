package com.example.introspect

import android.content.pm.ActivityInfo
import android.icu.text.DisplayContext
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets.Type.systemBars
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type.systemBars
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED


        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView)
        this.window.decorView.windowInsetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
        windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

/*    override fun onUserInteraction() {
        super.onUserInteraction()

        Handler().postDelayed({
            val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView)
            windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())
        },500)
    }*/
}