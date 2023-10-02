// File: ExerciseApplication.kt

package com.example.bitfitpart1

import android.app.Application
//import com.example.bitfit.data.database.AppDatabase

class ExerciseApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
}
