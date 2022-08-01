package com.tanishq.inshortsclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tanishq.inshortsclone.Utils.ZoomOutPageTransformer
import com.tanishq.inshortsclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager2()

    }

    private fun setupViewPager2() {
        val colorList = arrayListOf("465JBv3g6XI", "kLJRZpRhX1o","-2ckvIzs0nU")
        binding.viewPager.adapter = ViewPagerAdapter(this, colorList)

        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())
    }

    // This function handles back button press. When user press back button, previous view in viewPager2
    // is displayed.
    override fun onBackPressed() {
        val viewPager = binding.viewPager
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back but ton. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

}