package com.ahmedadelsaid.githubrepos.kotlin.model

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.ahmedadelsaid.githubrepos.kotlin.data.NetworkState

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * UserSearchResult from a search, which contains LiveData<List<User>> holding query data,
 * and a LiveData<NetworkState> of network status.
 */
data class UserSearchResult(
    val data: LiveData<PagedList<User>>,
    val networkState: LiveData<NetworkState>
)