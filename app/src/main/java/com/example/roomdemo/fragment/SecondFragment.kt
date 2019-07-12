package com.example.roomdemo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdemo.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var students: ArrayList<String> = ArrayList()
        students = arguments?.getStringArrayList("students") ?: students
        val studentsString = StringBuilder()
        for (student in students) {
            studentsString.append(student+"\n")
        }
        if (studentsString.isEmpty()) studentsString.append("空的")
        tv_students.text = studentsString
    }
}