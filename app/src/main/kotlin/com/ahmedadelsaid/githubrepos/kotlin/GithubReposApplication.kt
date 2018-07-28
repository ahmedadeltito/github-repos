package com.ahmedadelsaid.githubrepos.kotlin

import android.app.Application
import com.ahmedadelsaid.githubrepos.BuildConfig
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import timber.log.Timber

/**
 * Created by Ahmed Adel on 26/07/2018.
 *
 * GithubReposApplication is the project application class.
 */

class GithubReposApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}