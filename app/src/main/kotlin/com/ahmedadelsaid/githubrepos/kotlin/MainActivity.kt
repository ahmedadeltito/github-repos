package com.ahmedadelsaid.githubrepos.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import com.ahmedadelsaid.githubrepos.R
import com.ahmedadelsaid.githubrepos.kotlin.extensions.fadeOutAnimation
import com.ahmedadelsaid.githubrepos.kotlin.reboslist.GithubReposListActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startGithubLogoAnimation()

    }

    private fun startGithubLogoAnimation() {
        github_logo_iv.fadeOutAnimation(2000, object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                startGithubWordAnimation()
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
    }

    private fun startGithubWordAnimation() {
        github_word_iv.fadeOutAnimation(2000, object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                startActivity(Intent(this@MainActivity, GithubReposListActivity::class.java))
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
    }
}