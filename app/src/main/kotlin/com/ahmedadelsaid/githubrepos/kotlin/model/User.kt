package com.ahmedadelsaid.githubrepos.kotlin.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * User model that will returned in the UserSearchResult Model
 */

@Entity(tableName = "user")
data class User(
    @PrimaryKey @field:SerializedName("id") val id: Long,
    @field:SerializedName("login") val login: String,
    @field:SerializedName("avatar_url") val avatarUrl: String,
    @field:SerializedName("html_url") val htmlUrl: String,
    @field:SerializedName("followers_url") val followersUrl: String,
    @field:SerializedName("following_url") val followingUrl: String,
    @field:SerializedName("gists_url") val gistsUrl: String,
    @field:SerializedName("starred_url") val starredUrl: String,
    @field:SerializedName("subscriptions_url") val subscriptionsUrl: String,
    @field:SerializedName("organizations_url") val organizationsUrl: String,
    @field:SerializedName("repos_url") val reposUrl: String,
    @field:SerializedName("events_url") val eventsUrl: String,
    @field:SerializedName("received_events_url") val receivedEventsUrl: String,
    @field:SerializedName("type") val type: String,
    @field:SerializedName("site_admin") val siteAdmin: Boolean = false
)