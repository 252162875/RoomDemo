package com.example.roomdemo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.roomdemo.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener {
    var numS = 0
    var numT = 0
    var yearT = 10
    var type = "小学"
    override fun onClick(v: View?) {
        val sDao = AppDataBase.getDBInstace().getStudentDao()
        val tDao = AppDataBase.getDBInstace().getTeacherDao()
        when (v?.id) {
            R.id.btn_delete_all -> {
                sDao.deleteAll()
                goSecond(sDao, v)
            }
            R.id.btn_update -> {
                var s = Student(1, "S - 1", "大学")
                sDao.insert(s)
                goSecond(sDao, v)
            }
            R.id.btn_add -> {

                type = if (3 > numS + 1) {
                    "高中"
                } else {
                    "小学"
                }
                var s = Student(++numS, "S - $numS", type)

                sDao.insert(s)
                goSecond(sDao, v)
            }
            R.id.btn_add_t -> {
                var y = Math.random() * 100
                var t = Teacher(++numT, "s - $numT", y.toInt())
                tDao.insert(t)
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_thirdFragment)
            }
            R.id.btn_update_t -> {
                var t = Teacher(1, "s - 1", ++yearT)
                tDao.update(t)
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_thirdFragment)
            }
        }
    }

    private fun goSecond(sDao: StudentDao, v: View) {
        val allStudents = sDao.getAllStudents()
        val students = ArrayList<String>()
        for (st in allStudents) {
            Log.e("STUDENT", st.toString())
            students.add(st.toString())
        }
        val bundle = Bundle()
        bundle.putStringArrayList("students", students)
        Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_secondFragment, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_add.setOnClickListener(this)
        btn_update.setOnClickListener(this)
        btn_delete_all.setOnClickListener(this)

        btn_add_t.setOnClickListener(this)
        btn_update_t.setOnClickListener(this)
    }
}