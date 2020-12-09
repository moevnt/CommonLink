package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuEditActivity: AppCompatActivity() {

	private lateinit var menuDoneButton: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.menu_edit_activity)

		menuDoneButton = findViewById(R.id.menuDoneButton)

		menuDoneButton.setOnClickListener {
			val intent = updateButtonsActivity.newIntent(this@MenuEditActivity)
			startActivity(intent)

		}

	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, MenuEditActivity::class.java)
		}
	}

}