package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class updateButtonsActivity : AppCompatActivity() {

	private lateinit var menuButton: Button
	private lateinit var specialEventButton: Button
	private lateinit var hostName: TextView

	private val REQUEST = 0
	private val REQUESTED = "requested"
	private var request = true

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.update_buttons_activity)

		request = intent.getBooleanExtra(REQUESTED, true)
		menuButton = findViewById(R.id.menuButton)
		specialEventButton = findViewById(R.id.specialEventButton)


		menuButton.setOnClickListener {
			val intent = MenuUpdateActivity.newIntent(this@updateButtonsActivity)
			startActivity(intent)
		}

		specialEventButton.setOnClickListener {
			val intent = EventUpdateActivity.newIntent(this@updateButtonsActivity)
			startActivity(intent)
		}



	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			var intent = Intent(packageContext, updateButtonsActivity::class.java)
			return intent
		}
	}
}
