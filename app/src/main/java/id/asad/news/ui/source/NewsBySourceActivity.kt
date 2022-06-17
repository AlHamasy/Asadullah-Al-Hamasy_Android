package id.asad.news.ui.source

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.asad.news.databinding.ActivityNewsBySourceBinding
import id.asad.news.ui.adapter.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsBySourceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBySourceBinding
    private val newsBySourceViewModel : NewsBySourceViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val source = intent.getStringExtra(KEY_SOURCE) ?: "cnn"
        val sourceCaps = intent.getStringExtra(KEY_SOURCE_CAPS) ?: "CNN"

        showNews(source)
        showTitle(sourceCaps)
        goBack()
    }

    private fun goBack() {
        binding.imgIconBack.setOnClickListener {
            finish()
        }
    }

    private fun showTitle(source: String) {
        binding.tvCategory.text = source
    }

    private fun showNews(source: String) {
        val newsAdapter = NewsAdapter()
        newsBySourceViewModel.getAllNewsBySource(source).observe(this) { data ->
            newsAdapter.submitList(data)
        }
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@NewsBySourceActivity)
            adapter = newsAdapter
        }
    }

    companion object{
        const val KEY_SOURCE = "source"
        const val KEY_SOURCE_CAPS = "source-caps"
    }


}