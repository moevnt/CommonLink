package com.example.commonlink

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(){

	private lateinit var loginButton : Button
	private lateinit var usernameEdit : EditText

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)

		loginButton = findViewById(R.id.login_button)
		usernameEdit = findViewById(R.id.username_edit)

		loginButton.setOnClickListener { view: View ->

			if ( usernameEdit.text.toString() == "HOST"){
				val intent = updateButtonsActivity.newIntent(this@LoginActivity)
				startActivity(intent)
			}
			else {
				val intent = MainActivity.newIntent(this@LoginActivity)
				startActivity(intent)
			}
		}

	}
}