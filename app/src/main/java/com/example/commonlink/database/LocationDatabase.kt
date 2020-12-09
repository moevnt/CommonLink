package com.example.commonlink.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.commonlink.Location


@Database(entities = [Location::class], version = 1)
@TypeConverters(LocationTypeConverters::class)
abstract class LocationDatabase : RoomDatabase(){

    abstract fun locationDao() : LocationDao
}