package com.example.commonlink.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.commonlink.Location
import java.util.*

@Dao
interface LocationDao {

    @Query("SELECT * FROM Location")
    fun getLocations() : LiveData<List<Location>>

    @Query("SELECT * FROM Location WHERE name = (:id)")
    fun getLocation(id : UUID) : LiveData<Location?>

    @Insert
    fun addLocation(location: Location)

    @Update
    fun updateLocation(location: Location)
}