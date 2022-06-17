package id.asad.news.ui.webview

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.asad.news.databinding.ActivityWebViewBinding
import java.security.AccessController.getContext


class WebViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getStringExtra(KEY_URL_NEWS) ?: ""
        showWebView(intent)
        goBack()
    }

    private fun goBack(){
        binding.imgIconBack.setOnClickListener {
            finish()
        }
    }

    private fun showWebView(url : String){
        binding.webViewNews.settings.javaScriptEnabled = true
        binding.webViewNews.webViewClient = WebViewClient()
        binding.webViewNews.loadUrl(url)
    }

    companion object{
        const val KEY_URL_NEWS = "news"
    }
}