package id.asad.news.di

import id.asad.news.BuildConfig
import id.asad.news.ui.category.NewsByCategoryViewModel
import id.asad.news.data.INewsRepository
import id.asad.news.data.NewsRepository
import id.asad.news.data.remote.RemoteDataSource
import id.asad.news.data.remote.network.ApiService
import id.asad.news.ui.search.NewsBySearchViewModel
import id.asad.news.ui.source.NewsBySourceViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single <INewsRepository> {
        NewsRepository(get())
    }
}

val viewModelModule = module {
    viewModel { NewsByCategoryViewModel(NewsRepository(get())) }
    viewModel { NewsBySourceViewModel(NewsRepository(get())) }
    viewModel { NewsBySearchViewModel(NewsRepository(get())) }
}