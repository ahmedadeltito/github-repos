package com.ahmedadelsaid.githubrepos.kotlin.data

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * Network State data class and Status Enum class are for handling the status of
 * the network request of get users repositories.
 */
enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
    val status: Status,
    val message: String? = null
) {
    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        fun error(msg: String?) = NetworkState(Status.FAILED, msg)
    }
}