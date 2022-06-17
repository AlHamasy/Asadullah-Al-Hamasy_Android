package id.asad.news.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.asad.news.data.remote.category.NewsByCategoryFactory
import id.asad.news.data.remote.network.ApiService
import id.asad.news.data.remote.network.ArticlesItem
import id.asad.news.data.remote.search.NewsBySearchFactory
import id.asad.news.data.remote.source.NewsBySrcFactory
import id.asad.news.data.remote.source.NewsBySrcSource

class RemoteDataSource(private val apiService: ApiService) {

    private val config = PagedList.Config.Builder()
                                            .setPageSize(5)
                                            .setInitialLoadSizeHint(10)
                                            .setEnablePlaceholders(false)
                                            .build()

    fun getAllNewsByCategory(category : String) : LiveData<PagedList<ArticlesItem>>{
        return LivePagedListBuilder(NewsByCategoryFactory(apiService, category), config).build()
    }

    fun getAllNewsBySource(source : String) : LiveData<PagedList<ArticlesItem>>{
        return LivePagedListBuilder(NewsBySrcFactory(apiService, source), config).build()
    }

    fun getNewsBySearch(search : String) : LiveData<PagedList<ArticlesItem>>{
        return LivePagedListBuilder(NewsBySearchFactory(apiService, search), config).build()
    }

}