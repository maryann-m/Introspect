package com.example.introspect.data.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.introspect.data.dao.UserDao
import com.example.introspect.data.local_models.User


@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false)
abstract class Introspect_DataBase:RoomDatabase()
{
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: Introspect_DataBase? = null

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(Any()) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context): Introspect_DataBase {
            val buildRoomDB = Room.databaseBuilder(
                context.applicationContext,
                Introspect_DataBase::class.java,
                "introspect.db"
            )
                .fallbackToDestructiveMigration()
                .build()
            return buildRoomDB
        }
    }
}