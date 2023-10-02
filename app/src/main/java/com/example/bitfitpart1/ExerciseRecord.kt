// File: ExerciseRecord.kt

package com.example.bitfitpart1

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ExerciseRecord(
    val exerciseName: String,
    val exerciseDuration: Int
)
