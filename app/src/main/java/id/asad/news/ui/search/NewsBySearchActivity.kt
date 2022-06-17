package id.asad.news.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import id.asad.news.databinding.ActivityNewsBySearchBinding
import id.asad.news.ui.adapter.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsBySearchActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBySearchBinding
    private val newsBySearchViewModel : NewsBySearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchNews()
        goBack()
    }

    private fun showNews(query : String){

        val newsAdapter = NewsAdapter()
        newsBySearchViewModel.getNewsBySearch(query).observe(this){ data ->
            newsAdapter.submitList(data)
        }
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@NewsBySearchActivity)
            adapter = newsAdapter
        }
    }

    private fun searchNews() {

        binding.edtSearch.postDelayed({
            binding.edtSearch.requestFocus()
            val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.showSoftInput(binding.edtSearch, InputMethodManager.SHOW_IMPLICIT)
        }, 100)

        binding.edtSearch.setOnEditorActionListener(object : TextView.OnEditorActionListener{
            override fun onEditorAction(p0: TextView?, actionId: Int, p2: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    showNews(binding.edtSearch.text.toString())
                    return true
                }
                return false
            }
        })
    }

    private fun goBack() {
        binding.imgIconBack.setOnClickListener {
            finish()
        }
    }
}