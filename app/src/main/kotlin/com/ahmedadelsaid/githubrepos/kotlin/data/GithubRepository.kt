package com.ahmedadelsaid.githubrepos.kotlin.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import com.ahmedadelsaid.githubrepos.kotlin.api.GithubService
import com.ahmedadelsaid.githubrepos.kotlin.db.GithubLocalCache
import com.ahmedadelsaid.githubrepos.kotlin.model.User
import com.ahmedadelsaid.githubrepos.kotlin.model.UserSearchResult
import timber.log.Timber

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * Repository class that works with local and remote data sources.
 */
class GithubRepository(
    private val service: GithubService,
    private val cache: GithubLocalCache
) {

    companion object {
        const val PAGE_SIZE = 10
    }

    /**
     * Search users whose names match the query.
     */
    fun search(query: String): UserSearchResult {
        Timber.d("New query: $query")

        // Get data source factory from the local cache
        val dataSourceFactory = cache.usersByName(query)

        // every new query creates a new BoundaryCallback
        // The BoundaryCallback will observe when the user reaches to the edges of
        // the list and update the database with extra data
        val boundaryCallback = UserBoundaryCallback(query, service, cache)

        // Get the paged list
        val data = LivePagedListBuilder(dataSourceFactory, PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        // Get the network errors exposed by the boundary callback
        return UserSearchResult(data, boundaryCallback.networkState)
    }

    /**
     * Get user by the User Id
     * @userId is the User Id that we get the user by.
     */
    fun findUser(userId: Long): LiveData<User> = cache.findUser(userId)
}