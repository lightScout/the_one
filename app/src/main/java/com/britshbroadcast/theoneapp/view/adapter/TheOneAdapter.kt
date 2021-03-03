package com.britshbroadcast.theoneapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.britshbroadcast.theoneapp.databinding.TheOneItemLayoutBinding
import com.britshbroadcast.theoneapp.model.data.Doc
import com.britshbroadcast.theoneapp.util.Constants.Companion.FIRST_BOOK
import com.britshbroadcast.theoneapp.util.Constants.Companion.SECOND_BOOK
import com.bumptech.glide.Glide

class TheOneAdapter(var theOneList : List<Doc>) : RecyclerView.Adapter<TheOneAdapter.TheOneViewHolder>() {

    fun updateData(theOneList: List<Doc>){
        this.theOneList = theOneList
        notifyDataSetChanged()
    }

    inner class TheOneViewHolder(val binding: TheOneItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheOneViewHolder {
        val binding = TheOneItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
        parent,
                false
        )
        return TheOneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TheOneViewHolder, position: Int) {

        var bookCover : String = ""
            theOneList[position].apply {
                bookCover = when (this.name) {
                    FIRST_BOOK -> "https://images-na.ssl-images-amazon.com/images/I/A1EHTS9qSVL.jpg"
                    SECOND_BOOK -> "https://images-na.ssl-images-amazon.com/images/I/A1y0jd28riL.jpg"
                    else -> "https://images-na.ssl-images-amazon.com/images/I/91tZn9CjAwL.jpg"
                }
                holder.binding.apply {
                       Glide.with(holder.itemView.context)
                               .load(bookCover)
                               .into(bookCoverImageview)
                    titleTextview.text = name
                }
            }
    }

    override fun getItemCount(): Int = theOneList.size
}