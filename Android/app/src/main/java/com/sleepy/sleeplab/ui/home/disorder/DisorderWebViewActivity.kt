package com.sleepy.sleeplab.ui.home.disorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.databinding.ActivityDisorderWebViewBinding
import com.sleepy.sleeplab.databinding.ActivitySleepDisorderBinding

class DisorderWebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisorderWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisorderWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webviewDisorder
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        val url = intent.getStringExtra("url")
        webView.loadUrl(url!!)

    }
}