package com.ahmedadelsaid.githubrepos.kotlin.db

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.util.Log
import com.ahmedadelsaid.githubrepos.kotlin.model.User
import java.util.concurrent.Executor

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * Class that handles the DAO local data source. This ensures that methods are triggered on the
 * correct executor.
 */
class GithubLocalCache(
    private val userDao: UserDao,
    private val ioExecutor: Executor
) {

    /**
     * Insert a list of users in the database, on a background thread.
     */
    fun insert(users: List<User>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            Log.d("GithubLocalCache", "inserting ${users.size} users")
            userDao.insert(users)
            insertFinished()
        }
    }

    /**
     * Request a LiveData<List<User>> from the Dao, based on a user name. If the name contains
     * multiple words separated by spaces, then we're emulating the GitHub API behavior and allow
     * any characters between the words.
     * @param name user name
     */
    fun usersByName(name: String): DataSource.Factory<Int, User> {
        // appending '%' so we can allow other characters to be before and after the query string
        val query = "%${name.replace(' ', '%')}%"
        return userDao.usersByName(query)
    }

    fun findUser(userId: Long): LiveData<User> {
        return userDao.userById(userId)
    }
}