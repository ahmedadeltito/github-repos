package com.ahmedadelsaid.githubrepos.kotlin

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

/**
 * Created by Ahmed Adel on 26/07/2018.
 */

class GithubReposApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
    }

}