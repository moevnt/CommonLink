package com.example.commonlink

import android.app.Application

class LocationIntentApplication: Application() {
	override fun onCreate() {
		super.onCreate()
		LocationRepository.initialize(this)
	}
}