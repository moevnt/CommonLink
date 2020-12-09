package com.example.commonlink

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity(), LocationListFragment.Callbacks {


	private lateinit var signOutButton : Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		signOutButton = findViewById(R.id.sign_out_button)
		signOutButton.setOnClickListener {
			val intent = LoginActivity.newIntent(this@MainActivity)
			startActivity(intent)
		}

		val currentFragment =
				supportFragmentManager.findFragmentById(R.id.fragment_container)

		if (currentFragment == null){
			val fragment = LocationListFragment.newInstance()
				supportFragmentManager
					.beginTransaction()
					.add(R.id.fragment_container, fragment)
					.commit()
		}

		val locationRepository = LocationRepository.get()
		val l1 = Location(UUID.randomUUID(), "Black Cat", "1 N Shore Rd, Absecon, NJ 08201", "https://www.yelp.com/biz/black-cat-bar-and-grill-absecon", "10-10")
		val l2 = Location(UUID.randomUUID(), "Hi Point", "5 N Shore Rd, Absecon, NJ 08201", "https://www.hipointpubac.com/", "24")

		locationRepository.addLocation(l1)
		locationRepository.addLocation(l2)
	}

	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, MainActivity::class.java)
		}
	}

	override fun onLocationSelected(locationID: UUID) {
		val fragment = LocationFragment.newInstance(locationID)
		supportFragmentManager
			.beginTransaction()
			.replace(R.id.fragment_container, fragment)
			.addToBackStack(null)
			.commit()
	}

}