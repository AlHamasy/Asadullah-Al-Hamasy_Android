package id.asad.news.data.remote.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.asad.news.data.remote.network.ApiService
import id.asad.news.data.remote.network.ArticlesItem

class NewsBySrcFactory(private val service: ApiService, private val source : String) : DataSource.Factory<Int, ArticlesItem>() {

    private val dataSourceLiveData = MutableLiveData<NewsBySrcSource>()

    override fun create(): DataSource<Int, ArticlesItem> {
        val newsBySrcSource = NewsBySrcSource(service, source)
        dataSourceLiveData.postValue(newsBySrcSource)
        return newsBySrcSource
    }
}