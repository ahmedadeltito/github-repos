package com.ahmedadelsaid.githubrepos.kotlin

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.BounceInterpolator
import com.ahmedadelsaid.githubrepos.R
import com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist.GithubReposListActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * MainActivity is the entry point of our application.
 *
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startGithubLogoAnimation()

    }

    private fun startGithubLogoAnimation() {
        val translateAnimation =
            ObjectAnimator.ofFloat(github_logo_iv, View.TRANSLATION_Y, 0F, 500F)
        translateAnimation.duration = 2000
        translateAnimation.interpolator = BounceInterpolator()
        translateAnimation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                startGithubWordAnimation()
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }

        })
        translateAnimation.start()
    }

    private fun startGithubWordAnimation() {
        val fade = ObjectAnimator.ofFloat(github_word_iv, View.ALPHA, 0.0f, 1.0f)
        fade.duration = 2000
        fade.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                startActivity(Intent(this@MainActivity, GithubReposListActivity::class.java))
                this@MainActivity.finish()
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {
                github_word_iv.visibility = View.VISIBLE
            }

        })
        fade.start()
    }
}