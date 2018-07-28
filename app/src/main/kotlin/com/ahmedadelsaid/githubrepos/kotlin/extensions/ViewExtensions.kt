package com.ahmedadelsaid.githubrepos.kotlin.extensions

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * View Extensions that will be helpful for further development during the app.
 */

fun View.fadeOutAnimation(animationDuration: Long, animationListener: Animation.AnimationListener) {
    val fadeOut = AlphaAnimation(1f, 0f)
    fadeOut.interpolator = AccelerateInterpolator()
    fadeOut.startOffset = animationDuration
    fadeOut.duration = animationDuration
    fadeOut.setAnimationListener(animationListener)
    startAnimation(fadeOut)
}

fun View.fadeInAnimation(animationDuration: Long, animationListener: Animation.AnimationListener) {
    val fadeIn = AlphaAnimation(0f, 1f)
    fadeIn.interpolator = DecelerateInterpolator()
    fadeIn.duration = animationDuration
    fadeIn.setAnimationListener(animationListener)
    startAnimation(fadeIn)
}