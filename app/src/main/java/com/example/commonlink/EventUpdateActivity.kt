package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EventUpdateActivity: AppCompatActivity() {

	private lateinit var doneButton : Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.event_update_activity)

		doneButton = findViewById(R.id.doneButton)

		doneButton.setOnClickListener { view : View ->
			val intent = updateButtonsActivity.newIntent(this@EventUpdateActivity)
			startActivity(intent)
		}


	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			var intent = Intent(packageContext, EventUpdateActivity::class.java)
			return intent
		}
	}
}