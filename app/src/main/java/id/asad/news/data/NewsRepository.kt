package id.asad.news.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.asad.news.data.remote.RemoteDataSource
import id.asad.news.data.remote.network.ArticlesItem

class NewsRepository(private val remoteDataSource: RemoteDataSource) : INewsRepository {

    override fun getAllNewsByCategory(category: String): LiveData<PagedList<ArticlesItem>> {
        return remoteDataSource.getAllNewsByCategory(category)
    }

    override fun getAllNewsBySource(source: String): LiveData<PagedList<ArticlesItem>> {
        return remoteDataSource.getAllNewsBySource(source)
    }

    override fun getNewsBySearch(search: String): LiveData<PagedList<ArticlesItem>> {
        return remoteDataSource.getNewsBySearch(search)
    }


}