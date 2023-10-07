package com.example.bitfitpart1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.bitfit.ExerciseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddFragment : Fragment() {
    private lateinit var etExercise: EditText
    private lateinit var etDur: EditText
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        etExercise= view.findViewById(R.id.etExercise)
        etDur = view.findViewById(R.id.etDur)
        submitBtn = view.findViewById(R.id.recordBtn)

        submitBtn.setOnClickListener {
            val exerciseName = etExercise.text.toString()
            val dur = etDur.text.toString()

            let {
                lifecycleScope.launch(Dispatchers.IO) {
                    val list = ArrayList<ExerciseEntity>()
                    list.add(ExerciseEntity(name = exerciseName, duration = dur))
                    (requireActivity().application as ExerciseApplication).db.exerciseDao().insertAll(list)
                }
            }
        }

        return view
    }

    companion object {
        fun newInstance(): AddFragment {
            return AddFragment()
        }
    }
}