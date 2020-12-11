package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class updateButtonsActivity : AppCompatActivity() {

	private lateinit var menuButton: Button
	private lateinit var specialEventButton: Button
	private lateinit var signOutButton: Button
	private lateinit var locationButton : Button

	private val REQUESTED = "requested"
	private var request = true

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.update_buttons_activity)

		request = intent.getBooleanExtra(REQUESTED, true)
//		menuButton = findViewById(R.id.menuButton)
//		specialEventButton = findViewById(R.id.specialEventButton)
		signOutButton = findViewById(R.id.sign_out_button)
		locationButton = findViewById(R.id.location_update_button)


//		menuButton.setOnClickListener {
//			val intent = MenuEditActivity.newIntent(this@updateButtonsActivity)
//			startActivity(intent)
//		}
//
//		specialEventButton.setOnClickListener {
//			val intent = EventEditActivity.newIntent(this@updateButtonsActivity)
//			startActivity(intent)
//		}

		signOutButton.setOnClickListener {
			val intent = LoginActivity.newIntent(this@updateButtonsActivity)
			startActivity(intent)
		}

		locationButton.setOnClickListener {
			val intent = LocationEditActivity.newIntent(this@updateButtonsActivity)
			startActivity(intent)
		}

	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, updateButtonsActivity::class.java)
		}
	}
}
