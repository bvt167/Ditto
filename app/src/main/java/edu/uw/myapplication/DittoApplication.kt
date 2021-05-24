package edu.uw.myapplication

import android.app.Application
import edu.uw.myapplication.repository.DataRepository

class DittoApplication: Application() {

    lateinit var dataRepository: DataRepository

    override fun onCreate() {
        super.onCreate()

        dataRepository = DataRepository()
    }
}