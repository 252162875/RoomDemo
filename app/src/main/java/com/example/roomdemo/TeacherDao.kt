package com.example.roomdemo

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface TeacherDao : BaseDao<Teacher> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element: Teacher)

    @Query("select * from Teacher")
    fun getAllTeachers(): MutableList<Teacher>

    @Query("select * from Teacher where teacherID = :teacherID")
    fun getTeacher(teacherID: Int): Teacher

    @Query("select * from Teacher order by t_year desc ")
    fun getAllByDateDesc(): MutableList<Teacher>

    @Query("delete from Teacher")
    fun deleteAll()
}