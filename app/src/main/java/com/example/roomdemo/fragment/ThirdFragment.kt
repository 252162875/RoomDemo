package com.example.roomdemo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdemo.AppDataBase
import com.example.roomdemo.R
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val tDao = AppDataBase.getDBInstace().getTeacherDao()
        val allTeachers = tDao.getAllByDateDesc()
        val thachersString = StringBuilder()
        for (teacher in allTeachers) {
            thachersString.append(teacher.toString() + "\n")
        }
        if (thachersString.isEmpty()) thachersString.append("空的")
        tv_teachers.text = thachersString
    }
}