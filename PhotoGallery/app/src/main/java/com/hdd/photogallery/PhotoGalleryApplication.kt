package com.hdd.photogallery

import android.app.Application

class PhotoGalleryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferencesRepository.initialize(this)
    }
}