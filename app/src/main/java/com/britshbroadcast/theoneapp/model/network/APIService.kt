package com.britshbroadcast.theoneapp.model.network

import com.britshbroadcast.theoneapp.model.data.Books
import com.britshbroadcast.theoneapp.util.Constants.Companion.API_PATH
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET(API_PATH)
    fun getBooks() : Call<Books>

}