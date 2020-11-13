package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LocationPageActivity : AppCompatActivity() {

	private lateinit var backButton : Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_location_page)

		backButton = findViewById(R.id.back_button)

		backButton.setOnClickListener {view: View ->
			val intent = MainActivity.newIntent(this@LocationPageActivity)
			startActivity(intent)
		}

	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, LocationPageActivity::class.java)
		}
	}
}