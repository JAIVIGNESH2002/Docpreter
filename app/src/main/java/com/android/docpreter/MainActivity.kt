package com.android.docpreter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zoho.catalyst.common.ZCatalystUtil
import com.zoho.catalyst.datastore.ZCatalystSelectQuery
import com.zoho.catalyst.setup.ZCatalystApp
import com.zoho.catalyst.setup.ZCatalystSDKConfigs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabTitles = arrayOf("IN EFFECT","MY RECEIPTS")
        val tBar = findViewById<Toolbar>(R.id.mainTBar)
        setSupportActionBar(tBar)
        val v2 = findViewById<ViewPager2>(R.id.v2PagerElement)
        val v2Adapter = FragPager(this)
        v2.adapter= v2Adapter
        val tabLays = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLays,v2){ tab,position ->
            tab.text = tabTitles[position]
        }.attach()

    }

}