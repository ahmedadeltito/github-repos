package com.ahmedadelsaid.githubrepos.kotlin.db

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ahmedadelsaid.githubrepos.kotlin.model.User

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * Room data access object for accessing the [User] table.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<User>)

    // Do a similar query as the search API:
    // Look for users that contain the query string in the name or in the description
    // and order those results descending, by the number of stars and then by name
    @Query("SELECT * FROM user WHERE (login LIKE :queryString)")
    fun usersByName(queryString: String): DataSource.Factory<Int, User>

}