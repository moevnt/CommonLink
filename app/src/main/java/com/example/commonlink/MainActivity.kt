package com.example.commonlink

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Transformation
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

private val TAG = "Main Activity"
class MainActivity : AppCompatActivity(), OnMapReadyCallback{

	val locationDetailViewModel : LocationDetailViewModel by lazy {
		ViewModelProviders.of(this).get(LocationDetailViewModel::class.java)
	}
	private var  list = mutableListOf<Location>()
	private lateinit var nmap : GoogleMap
	private lateinit var locationRepository: LocationRepository


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		locationRepository = LocationRepository.get()


		locationDetailViewModel.locationListLiveData.observe(this,
				{ location ->
					location?.let {
						val tempList = mutableListOf<Location>()
						for(i in location.listIterator()){
							tempList.add(i)
							createMarker(i)
							Log.d(TAG, "size: ${i.id}")
						}
					}
				}
		)


		Log.d(TAG, "Test")

		val mapFragment = supportFragmentManager
				.findFragmentById(R.id.map) as SupportMapFragment
		mapFragment.getMapAsync(this)



	}

	fun createMarker(location: Location){

			Log.d(TAG, "Adding ${location.id}")
			nmap.addMarker(
					MarkerOptions()
							.position(LatLng(location.lat, location.lon))
							.title(location.name)
			)


	}

	override fun onMapReady(googleMap: GoogleMap) {

		nmap = googleMap

		Log.d(TAG,"${list.size} ")
		for (i in list.iterator()) {
			Log.d(TAG, "Adding ${i.id}")
			googleMap.addMarker(
					MarkerOptions()
							.position(LatLng(i.lat, i.lon))
							.title(i.name)
			)

		}

			googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
	}


	companion object {
		fun newIntent(packageContext: Context): Intent {

			return Intent(packageContext, MainActivity::class.java)
		}
	}
}

