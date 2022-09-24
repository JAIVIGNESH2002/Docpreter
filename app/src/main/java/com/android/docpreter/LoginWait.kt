package com.android.docpreter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.zoho.catalyst.exception.ZCatalystLogger
import com.zoho.catalyst.setup.ZCatalystApp

class LoginWait : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_wait)
        val openMail = findViewById<MaterialButton>(R.id.gmOpen)
        openMail.setOnClickListener {
            val i = Intent(Intent.ACTION_MAIN)
            i.addCategory(Intent.CATEGORY_APP_EMAIL)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(Intent.createChooser(i,"Email"))
        }
        val loginBt = findViewById<MaterialButton>(R.id.loginBt)
        loginBt.setOnClickListener {
            ZCatalystApp.getInstance().login(
                {
                    ZCatalystLogger.logInfo("Login Success")
                    val intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    //Actions to execute on successful login
                },
                {
                    ZCatalystLogger.logError("Login failed - $it")
                    //Actions to execute on failed login
                })
        }
    }
}