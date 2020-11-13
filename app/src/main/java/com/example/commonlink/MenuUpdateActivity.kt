package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuUpdateActivity: AppCompatActivity() {

	private lateinit var menuDoneButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.event_update_activity)

		menuDoneButton = findViewById(R.id.doneButton)

		menuDoneButton.setOnClickListener { view: View ->
			val intent = updateButtonsActivity.newIntent(this@MenuUpdateActivity)
			startActivity(intent)

		}

	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			var intent = Intent(packageContext, MenuUpdateActivity::class.java)
			return intent
		}
	}

}