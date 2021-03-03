package com.britshbroadcast.theoneapp.model.data

data class Books(
    val docs: List<Doc>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)