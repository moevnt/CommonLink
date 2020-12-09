package com.example.commonlink

import androidx.room.*
import java.util.*

@Entity
data class Location(@PrimaryKey val id : UUID = UUID.randomUUID(),
                                var name : String = "",
                                var address : String = "",
                                var website : String = "",
                                var hours : String = ""
)