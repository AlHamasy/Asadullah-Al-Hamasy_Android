package id.asad.news.ui.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.asad.news.databinding.ActivityNewsByCategoryBinding
import id.asad.news.ui.adapter.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsByCategoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsByCategoryBinding
    private val newsByCategoryViewModel : NewsByCategoryViewModel by viewModel()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsByCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra(KEY_CATEGORY) ?: "Health"

        showNews(category)
        showTitle(category)
        goBack()
    }

    private fun goBack() {
        binding.imgIconBack.setOnClickListener {
            finish()
        }
    }

    private fun showTitle(category: String) {
        binding.tvCategory.text = category
    }

    private fun showNews(category: String) {
        val newsAdapter = NewsAdapter()
        newsByCategoryViewModel.getAllNewsByCategory(category).observe(this) { data ->
            newsAdapter.submitList(data)
        }
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@NewsByCategoryActivity)
            adapter = newsAdapter
        }
    }

    companion object{
        const val KEY_CATEGORY = "category"
    }
}