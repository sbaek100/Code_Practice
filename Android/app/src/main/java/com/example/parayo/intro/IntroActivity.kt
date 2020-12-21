package com.example.parayo.intro

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.parayo.api.ParayoApi
import com.example.parayo.signup.SignupActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity


class IntroActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IntroActivityUI().setContentView(this)

        GlobalScope.launch{
            delay(1000)
            startActivity<SignupActivity>()
            finish()
        }


        runBlocking{
            try{
                val response = ParayoApi.instance.hello()
                Log.d("IntroActivity", response.data.toString())

            } catch(e: Exception){
                Log.e("IntroActivity", "Hello Api 호출 오류", e)
            }

        }
    }

}