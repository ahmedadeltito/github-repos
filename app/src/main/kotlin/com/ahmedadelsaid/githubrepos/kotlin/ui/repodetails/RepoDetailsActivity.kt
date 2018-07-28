package com.ahmedadelsaid.githubrepos.kotlin.ui.repodetails

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.ahmedadelsaid.githubrepos.R
import com.ahmedadelsaid.githubrepos.kotlin.GlideApp
import com.ahmedadelsaid.githubrepos.kotlin.Injection
import com.ahmedadelsaid.githubrepos.kotlin.Injection.USER_ID
import com.ahmedadelsaid.githubrepos.kotlin.model.User
import kotlinx.android.synthetic.main.activity_repo_details.*
import kotlinx.android.synthetic.main.content_repo_details.*

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * RepoDetailsActivity is the user details repository activity.
 */

class RepoDetailsActivity : AppCompatActivity() {

    private var userId: Long = 0

    private lateinit var viewModel: RepoDetailsViewModel

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)
        setSupportActionBar(toolbar)

        userId = intent.extras.getLong(USER_ID)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(
            this@RepoDetailsActivity,
            Injection.provideViewModelFactory(this)
        ).get(RepoDetailsViewModel::class.java)

        fireUserObserver()

    }

    private fun fireUserObserver() {
        viewModel.setUserId(userId)
        viewModel.user.observe(this, Observer { user ->
            user?.let {
                this.user = it
                toolbar?.title = user.login
                GlideApp.with(this@RepoDetailsActivity)
                    .load(user.avatarUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(user_details_avatar_iv)
                user_details_followers_url_tv.text =
                        if (user.followersUrl.isNotEmpty()) user.followersUrl else "Not Followers URL is Found."
                user_details_repos_url_tv.text =
                        if (user.organizationsUrl.isNotEmpty()) user.reposUrl else "Not Repos URL is Found."
            }
        })
    }

    fun openChromeCustomTabs(view: View) {
        user?.let { user ->
            val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
            builder.setStartAnimations(this, R.anim.slide_in_right, R.anim.slide_out_left)
            builder.setExitAnimations(this, R.anim.slide_in_left, R.anim.slide_out_right)
            val customTabsIntent: CustomTabsIntent = builder.build()
            if (view.id == R.id.user_details_followers_url_tv) {
                customTabsIntent.launchUrl(this, Uri.parse(user.followersUrl))
            } else if (view.id == R.id.user_details_repos_url_tv) {
                customTabsIntent.launchUrl(this, Uri.parse(user.organizationsUrl))
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
