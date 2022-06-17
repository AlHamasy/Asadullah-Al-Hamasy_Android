package id.asad.news.ui.category

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import id.asad.news.data.NewsRepository
import id.asad.news.data.remote.network.ArticlesItem
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsByCategoryViewModelTest {

    private lateinit var viewModel : NewsByCategoryViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository : NewsRepository

    @Mock
    private lateinit var observer : Observer<PagedList<ArticlesItem>>

    @Mock
    private lateinit var pagedList: PagedList<ArticlesItem>

    @Before
    fun setUp() {
        viewModel = NewsByCategoryViewModel(repository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getAllNewsByCategory() {

        val dummyNews = pagedList
        `when`(dummyNews.size).thenReturn(10)
        val news = MutableLiveData<PagedList<ArticlesItem>>()
        news.value = dummyNews

        `when`(repository.getAllNewsByCategory("health")).thenReturn(news)
        val movieEntity = viewModel.getAllNewsByCategory("health").value
        verify(repository).getAllNewsByCategory("health")
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(10, movieEntity?.size)

        viewModel.getAllNewsByCategory("health").observeForever(observer)
        verify(observer).onChanged(dummyNews)
    }

}