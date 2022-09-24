package com.android.docpreter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.zoho.catalyst.exception.ZCatalystLogger
import com.zoho.catalyst.setup.ZCatalystApp
import com.zoho.catalyst.setup.ZCatalystSDKConfigs

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        ZCatalystApp.init(
            applicationContext,
            ZCatalystSDKConfigs.AccountType.DEVELOPMENT
        )
        val mailField = findViewById<TextInputEditText>(R.id.txtMail)
        val mobField = findViewById<TextInputEditText>(R.id.txtMob)
        val loginBt = findViewById<TextView>(R.id.loginTxt)
        //Creating user via catalyst
        val rButton = findViewById<MaterialButton>(R.id.regButton)
        rButton.setOnClickListener {
            val userMail = mailField.text.toString()
            val userNumber = mobField.text.toString()
            val cUser = ZCatalystApp.getInstance().newUser(userNumber,userMail)
            println("userMail:***$userMail")
            ZCatalystApp.getInstance().signUp(cUser,
                {
                    println("User Sign up success")
                    val intent = Intent(applicationContext, LoginWait::class.java)
                    startActivity(intent)
                },
                { exception ->
                    println("User Sign up failed $exception")
                })
        }
        loginBt.setOnClickListener {
             ZCatalystApp.getInstance().login(
                {
                    ZCatalystLogger.logInfo("Login Success")
                    Toast.makeText(applicationContext,"Login success",Toast.LENGTH_LONG).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    //Actions to execute on successful login
                },
                {
                    ZCatalystLogger.logError("Login failed - $it")
                    //Actions to execute on failed login
                })
        }
    }
}