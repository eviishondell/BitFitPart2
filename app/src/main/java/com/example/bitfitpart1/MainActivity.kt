// File: MainActivity.kt

package com.example.bitfitpart1
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var exerciseRecordsRecyclerView: RecyclerView
    private val exerciseRecords = mutableListOf<ExerciseRecord>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exerciseRecordsRecyclerView = findViewById(R.id.recycler_view)
        val recordsAdapter = ExerciseRecordAdapter(exerciseRecords)

        lifecycleScope.launch {
            (application as ExerciseApplication).database.exerciseDao().getAllExerciseRecords()
                .collect { databaseList ->
                    databaseList.map { entity ->
                        ExerciseRecord(
                            entity.exerciseName,
                            entity.exerciseDuration
                        )
                    }.also { mappedList ->
                        exerciseRecords.clear()
                        exerciseRecords.addAll(mappedList)
                        recordsAdapter.notifyDataSetChanged()
                    }
                }
        }

        exerciseRecordsRecyclerView.adapter = recordsAdapter
        exerciseRecordsRecyclerView.layoutManager = LinearLayoutManager(this)

        val addSessionBtn = findViewById<Button>(R.id.button)

        addSessionBtn.setOnClickListener {
            // launch the detail activity
            val intent = Intent(this, RecordActivity::class.java)
            this.startActivity(intent)
        }
    }
}