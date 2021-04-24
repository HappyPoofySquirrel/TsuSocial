package com.guvyerhopkins.tsusocial.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.guvyerhopkins.tsusocial.R

private const val IMAGE_URL_KEY = "IMAGE_URL_KEY"
private const val USERNAME_KEY = "USERNAME_KEY"

class DetailsActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, imageUrl: String, userName: String): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(IMAGE_URL_KEY, imageUrl)
                putExtra(USERNAME_KEY, userName)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imageView = findViewById<ImageView>(R.id.details_iv)
        val userName = findViewById<TextView>(R.id.details_username_tv)

        imageView.load(intent.getStringExtra(IMAGE_URL_KEY))
        userName.text = intent.getStringExtra(USERNAME_KEY)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}