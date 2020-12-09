package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LocationEditActivity: AppCompatActivity() {

	private lateinit var menuDoneButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_location_edit)

		menuDoneButton = findViewById(R.id.menuDoneButton)

		menuDoneButton.setOnClickListener { view: View ->
			val intent = updateButtonsActivity.newIntent(this@LocationEditActivity)
			startActivity(intent)

		}

	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, LocationEditActivity::class.java)
		}
	}

}