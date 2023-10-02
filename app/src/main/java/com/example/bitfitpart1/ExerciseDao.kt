// File: ExerciseDao.kt

package com.example.bitfitpart1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {
    @Insert
    fun insert(exerciseRecord: ExerciseRecordEntity)

    @Query("SELECT * FROM exercise_record")
    fun getAllExerciseRecords(): Flow<List<ExerciseRecordEntity>>
}
