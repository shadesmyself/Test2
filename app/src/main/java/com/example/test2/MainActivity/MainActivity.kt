package com.example.test2.MainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.activityThree.ui.ActivityThree
import com.example.test2.ActivityTwo.ActivityTwo
import com.example.test2.R
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAnotherActivity()
    }

    private fun getAnotherActivity() {
        val needOpenTwoActivity = Random.nextBoolean()

        val intent = if (needOpenTwoActivity) {
            Intent(this, ActivityTwo::class.java)
        } else {
            Intent(this, ActivityThree::class.java)
        }

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(intent)
                finish()
            }
        }, 3500)
    }

}