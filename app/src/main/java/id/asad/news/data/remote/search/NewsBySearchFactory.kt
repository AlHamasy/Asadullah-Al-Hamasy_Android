package id.asad.news.data.remote.search

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.asad.news.data.remote.network.ApiService
import id.asad.news.data.remote.network.ArticlesItem
import id.asad.news.data.remote.source.NewsBySrcSource

class NewsBySearchFactory(private val service: ApiService, private val search : String) : DataSource.Factory<Int, ArticlesItem>() {

    private val dataSourceLiveData = MutableLiveData<NewsBySearchSource>()

    override fun create(): DataSource<Int, ArticlesItem> {
        val newsBySearchSource = NewsBySearchSource(service, search)
        dataSourceLiveData.postValue(newsBySearchSource)
        return newsBySearchSource
    }
}