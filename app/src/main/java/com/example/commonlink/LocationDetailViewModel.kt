package com.example.commonlink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class LocationDetailViewModel: ViewModel() {

	private val locationRepository = LocationRepository.get()
	private val locationIdLiveData = MutableLiveData<UUID>()

	var locationLiveData : LiveData<Location> =
			Transformations.switchMap(locationIdLiveData){
				locationId -> locationRepository.getLocation(locationId)
			}

	fun loadLocation(locationId: UUID){
		locationIdLiveData.value = locationId
	}
}