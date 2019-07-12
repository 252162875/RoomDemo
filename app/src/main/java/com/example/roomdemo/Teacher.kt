package com.example.roomdemo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Teacher")
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    var teacherID: Int?,
    @ColumnInfo(name = "t_name")
    var teacherName: String?,
    //教学年限
    @ColumnInfo(name = "t_year")
    var teachYear: Int?
) {
}