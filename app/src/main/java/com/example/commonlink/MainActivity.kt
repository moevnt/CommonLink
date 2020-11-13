package com.example.commonlink

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

	private lateinit var locationButton : Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		locationButton = findViewById(R.id.location_button)

		locationButton.setOnClickListener { view: View ->
			val intent = LocationPageActivity.newIntent(this@MainActivity)
			startActivity(intent)
		}

	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, MainActivity::class.java)
		}
	}

}