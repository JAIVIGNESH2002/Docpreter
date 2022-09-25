@file:Suppress("DEPRECATION")

package com.android.docpreter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val check = sharedPreference.getString("visited","false")
            if(check.equals("true")){
                val intent = Intent(this,RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                val intent = Intent(this, BoardingActivity::class.java)
                startActivity(intent)
                finish()
            }
        },3000)
    }
}