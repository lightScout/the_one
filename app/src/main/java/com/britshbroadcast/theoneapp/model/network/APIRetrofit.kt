package com.britshbroadcast.theoneapp.model.network

import com.britshbroadcast.theoneapp.model.data.Books
import com.britshbroadcast.theoneapp.util.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIRetrofit {

    private val apiService = createAPIService(createTheOneRetrofit())

    private fun createTheOneRetrofit() : Retrofit =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
    private fun createAPIService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)

    fun getBooks() : Call<Books> = apiService.getBooks()
}