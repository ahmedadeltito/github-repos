package com.ahmedadelsaid.githubrepos.kotlin.api

import com.ahmedadelsaid.githubrepos.kotlin.model.User
import com.google.gson.annotations.SerializedName

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * Data class to hold user responses from searchUser API calls.
 */
data class UserSearchResponse(
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("items") val items: List<User> = emptyList(),
    val nextPage: Int? = null
)