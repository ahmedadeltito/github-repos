package com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.ahmedadelsaid.githubrepos.kotlin.data.GithubRepository
import com.ahmedadelsaid.githubrepos.kotlin.data.NetworkState
import com.ahmedadelsaid.githubrepos.kotlin.model.User
import com.ahmedadelsaid.githubrepos.kotlin.model.UserSearchResult

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * ViewModel for the [GithubReposListFragment] screen.
 * The ViewModel works with the [GithubRepository] to get the data.
 */

class GithubReposListViewModel(private val repository: GithubRepository) : ViewModel() {

    private val queryLiveData = MutableLiveData<String>()

    private val userResult: LiveData<UserSearchResult> = Transformations.map(queryLiveData, {
        repository.search(it)
    })

    val networkState: LiveData<NetworkState> = Transformations.switchMap(userResult,
        { it -> it.networkState })

    val users: LiveData<PagedList<User>> = Transformations.switchMap(userResult,
        { it -> it.data })

    /**
     * Search a user based on a query string.
     */
    fun searchUser(queryString: String) {
        queryLiveData.postValue(queryString)
    }

    /**
     * Get the last query value.
     */
    fun lastQueryValue(): String? = queryLiveData.value

    fun retry() {
        queryLiveData.value?.let { query ->
            repository.search(query)
        }
    }

    fun refresh() {
        queryLiveData.value?.let { query ->
            repository.search(query)
        }
    }
}