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
class MainActivity : AppCompatActivity(), OnMapReadyCallback{

	private val locationDetailViewModel: LocationDetailViewModel by lazy {
		ViewModelProviders.of(this).get(LocationDetailViewModel::class.java)
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)


		val mapFragment = supportFragmentManager
				.findFragmentById(R.id.map) as SupportMapFragment
		mapFragment.getMapAsync(this)


	}

	override fun onMapReady(googleMap: GoogleMap) {
		val list = locationDetailViewModel.locationLiveData.value

		val lat = list.lat
		val lon = list.lon


		googleMap.addMarker(
				MarkerOptions()
						.position( LatLng(39.42412592503969, -74.49922338859906) )
						.title("Hi Point")
		)

		googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
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