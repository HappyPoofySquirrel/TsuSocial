package com.guvyerhopkins.tsusocial.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.guvyerhopkins.tsusocial.R

class MainActivity : AppCompatActivity() {

    companion object {
        const val USERNAME_KEY = "USERNAME_KEY"
        fun getIntent(context: Context, userName: String): Intent {
            return Intent(context, MainActivity::class.java).apply {
                putExtra(USERNAME_KEY, userName)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        showWelcomeMessage(intent.getStringExtra(USERNAME_KEY)!!)
    }

    private fun showWelcomeMessage(userName: String) {
        val welcome = getString(R.string.welcome)

        Toast.makeText(
            applicationContext,
            "$welcome $userName",
            Toast.LENGTH_LONG
        ).show()
    }
}