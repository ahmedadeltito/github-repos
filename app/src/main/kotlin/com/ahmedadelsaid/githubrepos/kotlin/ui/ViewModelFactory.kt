package com.ahmedadelsaid.githubrepos.kotlin.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ahmedadelsaid.githubrepos.kotlin.data.GithubRepository
import com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist.GithubReposListViewModel
import com.ahmedadelsaid.githubrepos.kotlin.ui.repodetails.RepoDetailsViewModel

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GithubReposListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GithubReposListViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(RepoDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RepoDetailsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
