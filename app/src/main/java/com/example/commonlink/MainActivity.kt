package com.example.commonlink

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

private val TAG = "Main Activity"
class MainActivity : AppCompatActivity(){

	private val locationDetailViewModel: LocationDetailViewModel by lazy {
		ViewModelProviders.of(this).get(LocationDetailViewModel::class.java)
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

		if (currentFragment == null){
			val fragment = MapFragment.newInstance()
			supportFragmentManager
					.beginTransaction()
					.add(R.id.fragment_container, fragment)
					.commit()
		}

	}


	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, MainActivity::class.java)
		}
	}

//	override fun onLocationSelected(locationID: UUID) {
//		val fragment = LocationFragment.newInstance(locationID)
//		supportFragmentManager
//			.beginTransaction()
//			.replace(R.id.fragment_container, fragment)
//			.addToBackStack(null)
//			.commit()
//	}

}