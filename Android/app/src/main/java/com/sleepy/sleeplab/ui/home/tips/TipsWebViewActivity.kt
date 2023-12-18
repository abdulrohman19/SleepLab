package com.sleepy.sleeplab.ui.home.tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.databinding.ActivityTipsForSleepBinding
import com.sleepy.sleeplab.databinding.ActivityTipsWebViewBinding

class TipsWebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipsWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webviewTips
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        val url = intent.getStringExtra("url")
        webView.loadUrl(url!!)

    }
}