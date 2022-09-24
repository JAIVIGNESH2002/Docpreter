 package com.android.docpreter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swipe.liquid_pager.LiquidPager

 class BoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        supportActionBar?.hide()
        val pager = findViewById<LiquidPager>(R.id.liqPager)
        val vPager = ViewPager(supportFragmentManager,1)
        pager.adapter = vPager

    }
}