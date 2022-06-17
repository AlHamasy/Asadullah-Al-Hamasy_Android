package id.asad.news.ui.search

import androidx.lifecycle.ViewModel
import id.asad.news.data.NewsRepository

class NewsBySearchViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getNewsBySearch(search : String) = newsRepository.getNewsBySearch(search)
}