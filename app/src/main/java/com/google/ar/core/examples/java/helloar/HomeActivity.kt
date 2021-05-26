package com.google.ar.core.examples.java.helloar

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    companion object staticInstance {
        private var instance:HomeActivity?=null
        @Synchronized
        fun get():HomeActivity{
            if(null==instance) instance=HomeActivity()
            return instance as HomeActivity
        }
        fun set(value:HomeActivity){
            instance = value
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        staticInstance.set(this)
        setSupportActionBar(toolbar)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_cart, R.id.navigation_login,R.id.navigation_ar))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // initial the bitmap for AR when the cart is empty
        var bitmapData = BitmapFactory.decodeResource(resources,R.drawable.daisy)
        PlaceholderContent.bitmap =bitmapData
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        ).navigateUp() || super.onSupportNavigateUp()
    }

}