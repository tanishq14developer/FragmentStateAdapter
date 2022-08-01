package com.tanishq.inshortsclone.Utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.max



class ZoomOutPageTransformer : ViewPager2.PageTransformer {


    override fun transformPage(view: View, position: Float) {
        view.apply {
            when {
                position < -1 -> // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.alpha = 0f
                position <= 1 -> { // [-1,1]

                    view.scaleX = max(MIN_SCALE, 1 - Math.abs(position))
                    view.scaleY = max(MIN_SCALE, 1 - Math.abs(position))
                    view.alpha = max(MIN_ALPHA, 1 - Math.abs(position))

                }
                else -> // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.alpha = 0f
            }


        }


    }
    companion object {

        private val MIN_SCALE = 0.65f
        private val MIN_ALPHA = 0.3f
    }
}