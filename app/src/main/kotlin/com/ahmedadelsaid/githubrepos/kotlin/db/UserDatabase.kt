package com.ahmedadelsaid.githubrepos.kotlin.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ahmedadelsaid.githubrepos.kotlin.model.User

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * Database schema that holds the list of users.
 */
@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class RepoDatabase : RoomDatabase() {

    abstract fun usersDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: RepoDatabase? = null

        fun getInstance(context: Context): RepoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RepoDatabase::class.java,
                "Github.db"
            ).build()
    }
}