package com.sleepy.sleeplab.ui.home.duration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sleepy.sleeplab.databinding.ActivityDurationWebViewBinding

class DurationWebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDurationWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDurationWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webviewDuration
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        val url = intent.getStringExtra("url")
        webView.loadUrl(url!!)

    }
}