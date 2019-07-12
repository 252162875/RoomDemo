package com.example.roomdemo

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase


@Database(entities = [Student::class, Teacher::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    abstract fun getTeacherDao(): TeacherDao

    companion object {

        @Volatile
        private var instance: AppDataBase? = null

        fun getDBInstace(): AppDataBase {

            if (instance == null) {

                synchronized(AppDataBase::class) {

                    if (instance == null) {

                        instance = Room.databaseBuilder(
                            MyApplication.getContext(),
                            AppDataBase::class.java,
                            "android_room_dev.db"
                        )
                            .allowMainThreadQueries()
//                            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                            .build()
                    }
                }
            }
            return instance!!
        }
        /*  */
        /**
         * 数据库版本 1->2 user表格新增了age列
         *//*
        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE User ADD COLUMN age integer")
            }
        }

        */
        /**
         * 数据库版本 2->3 新增book表格
         *//*
        private val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `book` (`uid` INTEGER PRIMARY KEY autoincrement, `name` TEXT , `userId` INTEGER, 'time' INTEGER)"
                )
            }
        }*/
    }

    override fun clearAllTables() {

    }

}