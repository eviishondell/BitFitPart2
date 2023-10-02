package com.example.bitfitpart1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
//import com.example.bitfit.ExerciseApplication
////import com.example.bitfit.R
//import com.example.bitfit.data.dao.ExerciseDao
//import com.example.bitfit.data.entities.ExerciseRecordEntity
//import com.example.bitfitpart1.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RecordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

        val exerciseDao = (application as ExerciseApplication).database.exerciseDao()

        // Find the EditText views by their IDs
        val exerciseNameEditText = findViewById<EditText>(R.id.edit_text_exercise_name)
        val exerciseDurationEditText = findViewById<EditText>(R.id.edit_text_exercise_duration)

        // Find the save button by its ID
        val saveButton = findViewById<Button>(R.id.button_save_exercise)

        // Set a click listener for the save button
        saveButton.setOnClickListener {
            val exerciseName = exerciseNameEditText.text.toString().trim()
            val exerciseDurationText = exerciseDurationEditText.text.toString()
            val exerciseDuration = exerciseDurationText.toIntOrNull()

            if (exerciseName.isNotEmpty() && exerciseDuration != null) {
                val exerciseRecord = ExerciseRecordEntity(
                    exerciseName = exerciseName,
                    exerciseDuration = exerciseDuration
                )
                saveExerciseRecord(exerciseDao, exerciseRecord)
            }
        }
    }

    private fun saveExerciseRecord(exerciseDao: ExerciseDao, exerciseRecord: ExerciseRecordEntity) {
        runBlocking {
            launch(Dispatchers.IO) {
                exerciseDao.insert(exerciseRecord)
            }
        }
        finish()
    }
}
