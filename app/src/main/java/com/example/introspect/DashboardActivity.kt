package com.example.introspect

import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.introspect.databinding.ActivityDashboardBinding
import com.example.introspect.utils.notifyUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var toggle: ActionBarDrawerToggle


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  WindowCompat.setDecorFitsSystemWindows(window, false)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView)
        this.window.decorView.windowInsetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
        windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())

        setUpNavGraph()
        setUpNavDrawer()

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView2)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    private fun setUpNavGraph(){
        val navController = Navigation.findNavController(this, R.id.fragmentContainerView2)
        binding.bottomNav.setupWithNavController(navController)



        binding.bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    true}
                R.id.explore -> {
                    navController.navigate(R.id.exploreFragment)
                    true}
                R.id.notifications2 -> {
                    navController.navigate(R.id.notificationsFragment)
                    true}
                R.id.progress -> {
                    navController.navigate(R.id.progressFragment)
                    true}
                R.id.mescolor_Primary -> {
                    navController.navigate(R.id.dataAndSyncFragment)
                    true}

                else->false
            }
        }


        navController.addOnDestinationChangedListener{ _, nd: NavDestination, _->
            if(nd.id == R.id.homeFragment|| nd.id == R.id.notificationsFragment|| nd.id == R.id.progressFragment || nd.id == R.id.exploreFragment || nd.id == R.id.dataAndSyncFragment){
                binding.bottomNav.visibility = View.VISIBLE

            }
            else{
                binding.bottomNav.visibility = View.GONE

            }

        }
    }

    private fun setUpNavDrawer(){
        toggle = ActionBarDrawerToggle(this, binding.homeRootDrawer,R.string.open, R.string.close)
        binding.homeRootDrawer.addDrawerListener(toggle)
        toggle.syncState()

        binding.homeDrawer.setNavigationItemSelectedListener {
            when(it.itemId){}
            /*{
                R.id.hio ->notifyUser("Bio")
                R.id.access -> notifyUser("Access")
            }*/

            true
        }


        binding.homeRootDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

    }



        fun openDrawer(){
            binding.homeRootDrawer.openDrawer(GravityCompat.START)

        }
    }



