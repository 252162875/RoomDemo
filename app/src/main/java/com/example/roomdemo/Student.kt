package com.example.roomdemo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    var studentID: Int?,
    @ColumnInfo(name = "s_name")
    var studentName: String?,
    @ColumnInfo(name = "s_type")
    var studentType: String?
) {
}