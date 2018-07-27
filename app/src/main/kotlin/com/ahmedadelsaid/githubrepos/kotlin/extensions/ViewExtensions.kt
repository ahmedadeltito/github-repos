package com.ahmedadelsaid.githubrepos.kotlin.extensions

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

/**
 * Created by Ahmed Adel on 27/07/2018.
 */

fun View.fadeOutAnimation(animationDuration: Long, animationListener: Animation.AnimationListener) {
    val fadeOut = AlphaAnimation(1f, 0f)
    fadeOut.interpolator = AccelerateInterpolator()
    fadeOut.startOffset = animationDuration
    fadeOut.duration = animationDuration
    fadeOut.setAnimationListener(animationListener)
    startAnimation(fadeOut)
}