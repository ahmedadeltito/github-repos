package com.ahmedadelsaid.githubrepos.kotlin.api

import com.ahmedadelsaid.githubrepos.BuildConfig
import com.ahmedadelsaid.githubrepos.kotlin.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import timber.log.Timber

/**
 * Created by Ahmed Adel on 27/07/2018.
 */

/**
 * Search users based on a query.
 * Trigger a request to the Github searchUser API with the following params:
 * @param query searchUser keyword
 * @param page request page index
 * @param itemsPerPage number of users to be returned by the Github API per page
 *
 * The result of the request is handled by the implementation of the functions passed as params
 * @param onSuccess function that defines how to handle the list of users received
 * @param onError function that defines how to handle request failure
 */
fun searchUsers(
    service: GithubService,
    query: String,
    page: Int,
    itemsPerPage: Int,
    onSuccess: (users: List<User>) -> Unit,
    onError: (error: String) -> Unit
) {

    Timber.d("query: $query, page: $page, itemsPerPage: $itemsPerPage")

    service.searchUsers(
        query,
        page,
        itemsPerPage,
        BuildConfig.CLIENT_ID,
        BuildConfig.CLIENT_SECRET
    ).enqueue(
        object : Callback<UserSearchResponse> {
            override fun onFailure(call: Call<UserSearchResponse>?, t: Throwable) {
                Timber.d("fail to get data")
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<UserSearchResponse>?,
                response: Response<UserSearchResponse>
            ) {
                Timber.d("got a response $response")
                if (response.isSuccessful) {
                    val users = response.body()?.items ?: emptyList()
                    onSuccess(users)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}

/**
 * Github API communication setup via Retrofit.
 */
interface GithubService {
    /**
     * Get users ordered by stars.
     */
    @GET("search/users")
    fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String
    ): Call<UserSearchResponse>

    companion object {

        fun create(): GithubService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        }
    }
}