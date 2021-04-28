package com.example.test2.ActivityTwo

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.test2.R
import kotlinx.android.synthetic.main.activity_two.*

class ActivityTwo : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        webViewSetup()
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        wb_webView.webViewClient = WebViewClient()
        wb_webView.apply {
            loadUrl("https://www.google.com")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (wb_webView.canGoBack()) wb_webView.goBack() else super.onBackPressed()
    }
}