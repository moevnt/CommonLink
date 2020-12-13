package com.example.commonlink

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class LocationDetailViewModel: ViewModel() {

	private val locationRepository = LocationRepository.get()
	private val locationIdLiveData = MutableLiveData<UUID>()
	private val locationsIdLiveData = MutableLiveData<List<UUID>>()

	var locationLiveData : LiveData<Location> =
			Transformations.switchMap(locationIdLiveData){
				locationId -> locationRepository.getLocation(locationId)
			}
	var locationsLiveData : LiveData<List<Location?>> =
			 locationRepository.getLocations()


	fun loadLocation(locationId: UUID){
		locationIdLiveData.value = locationId
	}
}