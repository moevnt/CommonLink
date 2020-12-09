package com.example.commonlink

import androidx.lifecycle.ViewModel

class LocationListViewModel : ViewModel() {


	private val locationRepository = LocationRepository.get()

	val locationListLiveData = locationRepository.getLocations()
}