package id.asad.news.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.asad.news.data.remote.network.ArticlesItem

interface INewsRepository {

    fun getAllNewsByCategory(category : String) : LiveData<PagedList<ArticlesItem>>

    fun getAllNewsBySource(source : String) : LiveData<PagedList<ArticlesItem>>

    fun getNewsBySearch(search : String) : LiveData<PagedList<ArticlesItem>>

}