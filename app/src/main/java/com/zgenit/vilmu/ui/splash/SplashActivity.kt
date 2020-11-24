package com.zgenit.vilmu.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zgenit.vilmu.R
import com.zgenit.vilmu.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timerThread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        timerThread.start()
    }
}