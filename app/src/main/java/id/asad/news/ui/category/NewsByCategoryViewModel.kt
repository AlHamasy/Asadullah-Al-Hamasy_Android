package id.asad.news.ui.category

import androidx.lifecycle.ViewModel
import id.asad.news.data.NewsRepository

class NewsByCategoryViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getAllNewsByCategory(category: String) = newsRepository.getAllNewsByCategory(category)
}