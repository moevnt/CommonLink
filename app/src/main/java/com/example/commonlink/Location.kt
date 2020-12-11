package com.example.commonlink

import androidx.room.*
import java.util.*

@Entity
data class Location(@PrimaryKey val id : UUID = UUID.randomUUID(),
                                var name: String = "",
                                var lat: Double = 0.0,
                                var lon: Double= 0.0
)