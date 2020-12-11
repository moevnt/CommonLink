package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class LocationEditActivity: AppCompatActivity() {

	private lateinit var menuDoneButton: Button
	private lateinit var latEditText: EditText
	private lateinit var lonEditText: EditText
	private lateinit var nameEditText: EditText


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_location_edit)

		menuDoneButton = findViewById(R.id.menuDoneButton)
		latEditText = findViewById(R.id.LatEditText)
		lonEditText = findViewById(R.id.LongEditText)
		nameEditText = findViewById(R.id.locaiton_name_edit_text)
		val locationRepository = LocationRepository.get()

		menuDoneButton.setOnClickListener { view: View ->

			val location = Location(UUID.randomUUID(), nameEditText.text.toString(), latEditText.text.toString().toDouble(), lonEditText.text.toString().toDouble())

			locationRepository.addLocation(location)
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