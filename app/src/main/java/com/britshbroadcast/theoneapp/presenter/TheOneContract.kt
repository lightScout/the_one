package com.britshbroadcast.theoneapp.presenter

import com.britshbroadcast.theoneapp.model.data.Books
import com.britshbroadcast.theoneapp.model.data.Doc

interface TheOneContract {

    interface theOnePresenter{
        fun getBooks()
    }


    interface theOneView{
        fun displayBooks(booksList: List<Doc>)
        fun displayError(errorMessage: String)
    }

}