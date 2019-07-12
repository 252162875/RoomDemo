package com.example.roomdemo

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface StudentDao : BaseDao<Student> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element: Student)

    @Query("select * from Student")
    fun getAllStudents(): MutableList<Student>

    @Query("select * from Student where studentID = :studentID")
    fun getStudent(studentID: Int): Student

    @Query("select * from Student order by studentID desc ")
    fun getAllByDateDesc():MutableList<Student>

    @Query("delete from Student")
    fun deleteAll()
}