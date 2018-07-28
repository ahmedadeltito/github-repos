package com.ahmedadelsaid.githubrepos.kotlin.ui.repodetails

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.ahmedadelsaid.githubrepos.kotlin.data.GithubRepository
import com.ahmedadelsaid.githubrepos.kotlin.model.User

/**
 * Created by Ahmed Adel on 28/07/2018.
 *
 * RepoDetailsViewModel is the view holder of the user details screen.
 */
class RepoDetailsViewModel(private val repository: GithubRepository) : ViewModel() {

    private val userId = MutableLiveData<Long>()

    val user: LiveData<User> = Transformations.switchMap(userId, {
        repository.findUser(it)
    })

    fun setUserId(userId: Long) {
        this.userId.postValue(userId)
    }

}