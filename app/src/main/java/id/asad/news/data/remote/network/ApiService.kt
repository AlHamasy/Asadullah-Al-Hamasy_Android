package id.asad.news.data.remote.network

import id.asad.news.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    fun getNewsByCategory(@Query("apiKey") apiKey : String = BuildConfig.API_KEY,
                          @Query("category") category : String,
                          @Query("page") page : Int = 0) : Call<ResponseNews>

    @GET("everything")
    fun getNewsBySource(@Query("apiKey") apiKey : String = BuildConfig.API_KEY,
                        @Query("sources") sources : String,
                        @Query("page") page : Int = 0) : Call<ResponseNews>


    @GET("everything")
    fun getNewsBySearch(@Query("apiKey") apiKey : String = BuildConfig.API_KEY,
                        @Query("q") search : String,
                        @Query("page") page : Int = 0) : Call<ResponseNews>

}