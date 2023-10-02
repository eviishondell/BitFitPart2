// File: ExerciseRecordAdapter.kt

package com.example.bitfitpart1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.example.bitfit.R
//import com.example.bitfit.data.entities.ExerciseRecord
//import com.example.bitfitpart1.R

class ExerciseRecordAdapter(private val exerciseRecords: List<ExerciseRecord>) :
    RecyclerView.Adapter<ExerciseRecordAdapter.ExerciseRecordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseRecordViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_record, parent, false)
        return ExerciseRecordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseRecordViewHolder, position: Int) {
        val currentItem = exerciseRecords[position]
        holder.textViewExerciseName.text = currentItem.exerciseName
        holder.textViewExerciseDuration.text = currentItem.exerciseDuration.toString()
    }

    override fun getItemCount(): Int {
        return exerciseRecords.size
    }

    class ExerciseRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewExerciseName: TextView = itemView.findViewById(R.id.text_view_exercise_name)
        val textViewExerciseDuration: TextView = itemView.findViewById(R.id.text_view_exercise_duration)
    }
}
