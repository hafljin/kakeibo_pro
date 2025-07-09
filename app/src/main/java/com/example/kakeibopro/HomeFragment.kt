package com.example.kakeibopro

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
// Home画面
class HomeFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val calender = Calendar.getInstance()
        val dayFormat = SimpleDateFormat("E", Locale.getDefault())
        val dateFormat = SimpleDateFormat("dd", Locale.getDefault())
        val dateContainer = view.findViewById<LinearLayout>(R.id.dateContainer)
        // Scrollview領域を動的にするために生成
        for(i in 0..20) {
            val verticalLayout = LinearLayout(requireContext())
            verticalLayout.orientation = LinearLayout.VERTICAL
            verticalLayout.setPadding(16, 8, 16, 8)
            val dayTextView = TextView(requireContext())
            dayTextView.text = dayFormat.format(calender.time)
            dayTextView.textSize = 20f
            dayTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER

            val dateTextView = TextView(requireContext())
            dateTextView.text = dateFormat.format(calender.time)
            dateTextView.textSize = 20f
            dateTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER

            verticalLayout.addView(dayTextView)
            verticalLayout.addView(dateTextView)
            dateContainer.addView(verticalLayout)

            calender.add(Calendar.DAY_OF_MONTH, 1)
        }

        return view
    }
}