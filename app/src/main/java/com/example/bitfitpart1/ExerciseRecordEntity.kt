// File: ExerciseRecordEntity.kt

package com.example.bitfitpart1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_record")
data class ExerciseRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name="exerciseName") val exerciseName: String,
    @ColumnInfo(name="exerciseDuration") val exerciseDuration: Int
)
