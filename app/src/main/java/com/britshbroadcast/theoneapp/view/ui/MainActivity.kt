package com.britshbroadcast.theoneapp.view.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.britshbroadcast.theoneapp.databinding.ActivityMainBinding
import com.britshbroadcast.theoneapp.model.data.Books
import com.britshbroadcast.theoneapp.model.data.Doc
import com.britshbroadcast.theoneapp.model.network.APIRetrofit
import com.britshbroadcast.theoneapp.presenter.TheOneContract
import com.britshbroadcast.theoneapp.presenter.TheOnePresenter
import com.britshbroadcast.theoneapp.view.adapter.TheOneAdapter
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), TheOneContract.theOneView {

    //view binding - 1st step
    private lateinit var viewBinding: ActivityMainBinding

    private lateinit var theOnePresenter: TheOnePresenter

    private lateinit var theOneAdapter: TheOneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //view binding - 2nd step
            viewBinding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(viewBinding.root)

            theOnePresenter = TheOnePresenter(this)
            theOneAdapter = TheOneAdapter(mutableListOf())
            viewBinding.mainRecyclerview.adapter = theOneAdapter
            theOnePresenter.getBooks()

    }

    override fun displayBooks(booksList: List<Doc>) {
        runOnUiThread {
            theOneAdapter.updateData(booksList)
        }
    }

    override fun displayError(errorMessage: String) {
        runOnUiThread {
            Snackbar.make(viewBinding.root,errorMessage, Snackbar.LENGTH_SHORT).show()
        }
    }
}