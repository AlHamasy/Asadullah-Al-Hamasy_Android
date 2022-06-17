package id.asad.news.data.remote.category

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.asad.news.data.remote.network.ApiService
import id.asad.news.data.remote.network.ArticlesItem

class NewsByCategoryFactory(private val service : ApiService, private val category : String) : DataSource.Factory<Int, ArticlesItem>() {

    private val dataSourceLiveData = MutableLiveData<NewsByCategorySource>()

    override fun create(): DataSource<Int, ArticlesItem> {
        val newsByCategorySource = NewsByCategorySource(service, category)
        dataSourceLiveData.postValue(newsByCategorySource)
        return newsByCategorySource
    }
}