package com.britshbroadcast.theoneapp.presenter

import android.util.Log
import com.britshbroadcast.theoneapp.model.data.Books
import com.britshbroadcast.theoneapp.model.network.APIRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TheOnePresenter(val theOneView: TheOneContract.theOneView) : TheOneContract.theOnePresenter{

    private val apiRetrofit : APIRetrofit = APIRetrofit()
    override fun getBooks() {
        Thread{
            apiRetrofit.getBooks().enqueue(object : Callback<Books> {
                override fun onResponse(call: Call<Books>, response: Response<Books>) {
                    response.body()?.let {
                        if (it.docs.isNotEmpty())
                        theOneView.displayBooks(it.docs)
                        else
                            Log.d("TAG_J", "No results found")
                    } ?: Log.d("TAG_J", "Response was null")
                }

                override fun onFailure(call: Call<Books>, t: Throwable) {
                  theOneView.displayError("An error occurred. ${t.localizedMessage}")
                }

            })

        }.start()
    }
}