package com.ahmedadelsaid.githubrepos.kotlin.data

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.ahmedadelsaid.githubrepos.kotlin.api.GithubService
import com.ahmedadelsaid.githubrepos.kotlin.api.searchUsers
import com.ahmedadelsaid.githubrepos.kotlin.data.GithubRepository.Companion.PAGE_SIZE
import com.ahmedadelsaid.githubrepos.kotlin.db.GithubLocalCache
import com.ahmedadelsaid.githubrepos.kotlin.model.User
import timber.log.Timber

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * This boundary callback gets notified when user reaches to the edges of the list for example when
 * the database cannot provide any more data.
 **/
class UserBoundaryCallback(
    private val query: String,
    private val service: GithubService,
    private val cache: GithubLocalCache
) : PagedList.BoundaryCallback<User>() {

    // keep the last requested page. When the request is successful, increment the page number.
    private var lastRequestedPage = 1

    // avoid triggering multiple requests in the same time
    private var isRequestInProgress = false

    val networkState = MutableLiveData<NetworkState>()

    /**
     * Database returned 0 items. We should query the backend for more items.
     */
    override fun onZeroItemsLoaded() {
        Timber.d("onZeroItemsLoaded")
        networkState.postValue(NetworkState.LOADING)
        requestAndSaveData(query)
    }

    /**
     * When all items in the database were loaded, we need to query the backend for more items.
     */
    override fun onItemAtEndLoaded(itemAtEnd: User) {
        Timber.d("onItemAtEndLoaded")
        networkState.postValue(NetworkState.LOADING)
        requestAndSaveData(query)
    }

    private fun requestAndSaveData(query: String) {
        if (isRequestInProgress) return

        isRequestInProgress = true
        searchUsers(service, query, lastRequestedPage, PAGE_SIZE, { users ->
            cache.insert(users, {
                networkState.postValue(NetworkState.LOADED)
                lastRequestedPage++
                isRequestInProgress = false
            })
        }, { error ->
            networkState.postValue(NetworkState.LOADED)
            networkState.postValue(NetworkState.error(error))
            isRequestInProgress = false
        })
    }
}