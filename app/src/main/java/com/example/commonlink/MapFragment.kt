package com.example.commonlink

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


private val TAG = "Map Fragment"
class MapFragment : Fragment(), OnMapReadyCallback {

	private val locationDetailViewModel: LocationDetailViewModel by lazy {
		ViewModelProviders.of(this).get(LocationDetailViewModel::class.java)
	}
	private lateinit var location : Location

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		locationDetailViewModel.locationLiveData.observe(
				viewLifecycleOwner,
				Observer {
					location -> location?.let {
						this.location = location

					}
				}
		)


	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


	}

	 override fun onMapReady(googleMap: GoogleMap) {
		val lat = location.lat
		val lon = location.lon

		Log.d(TAG, "MAP")
		googleMap.addMarker(
				MarkerOptions()
						.position( LatLng(lat,lon) )
						.title("Marker")
		)
		//}


		googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
	}

	companion object{
		fun newInstance(): MapFragment {
			return MapFragment()
		}
	}

}