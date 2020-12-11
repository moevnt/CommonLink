package com.example.commonlink

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.commonlink.database.LocationDatabase
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private val DATABASE_NAME = "location-database"
class LocationRepository private constructor(context: Context){

	private val executor = Executors.newSingleThreadExecutor() //

	private val database : LocationDatabase = Room.databaseBuilder(
			context.applicationContext,
			LocationDatabase::class.java,
			DATABASE_NAME
	).build()

	private val locationDao = database.locationDao()

	fun getLocations() : LiveData<List<Location>> = locationDao.getLocations()

	fun getLocation(id : UUID) : LiveData<Location> = locationDao.getLocation(id)

	fun addLocation(location: Location) {

		executor.execute{
			locationDao.addLocation(location)
		}
	}

	fun updateLocation(location: Location) {

		executor.execute{
			locationDao.updateLocation(location)
		}
	}

	companion object {

		private var INSTANCE: LocationRepository? = null

		fun initialize(context: Context) {

			if(INSTANCE == null) {

				INSTANCE = LocationRepository(context)
			}
		}

		fun get(): LocationRepository {

			return  INSTANCE ?:
			throw IllegalStateException("CrimeRepository must be initialized")
		}
	}
}