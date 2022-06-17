package id.asad.news.ui.source

import androidx.lifecycle.ViewModel
import id.asad.news.data.NewsRepository

class NewsBySourceViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getAllNewsBySource(source : String) = newsRepository.getAllNewsBySource(source)
}