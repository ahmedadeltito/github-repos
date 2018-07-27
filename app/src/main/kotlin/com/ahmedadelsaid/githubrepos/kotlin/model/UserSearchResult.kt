package com.ahmedadelsaid.githubrepos.kotlin.model

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * RepoSearchResult from a search, which contains LiveData<List<User>> holding query data,
 * and a LiveData<String> of network error state.
 */
data class UserSearchResult(
    val data: LiveData<PagedList<User>>,
    val networkErrors: LiveData<String>
)