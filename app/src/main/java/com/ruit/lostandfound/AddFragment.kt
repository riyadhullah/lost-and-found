package com.ruit.lostandfound

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AddFragment : Fragment() {

    lateinit var date : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        date = view.findViewById(R.id.date)

        date.setOnClickListener {
            showDatePickerDialog()
        }

        return view
    }

    fun showDatePickerDialog(){
        val calander = Calendar.getInstance()
        val year = calander.get(Calendar.YEAR)
        val month = calander.get(Calendar.MONTH)
        val day = calander.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            {
                _, selectedYear, selectedMonth, selectedDay ->
                date.text = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
            },
            year, month, day
        )

        datePickerDialog.show()
    }

}