package com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ahmedadelsaid.githubrepos.R
import kotlinx.android.synthetic.main.activity_github_repos_list.*

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * GithubReposListActivity is the user repository activity.
 */

class GithubReposListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_repos_list)
        setSupportActionBar(toolbar)

    }

}
