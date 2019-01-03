package com.test.mvvmsample.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.mvvmsample.R
import com.test.mvvmsample.databinding.ListRowBinding
import com.test.mvvmsample.model.Album
import java.util.*


class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private val mAlbum = ArrayList<Album>()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(albumViewHolder: AlbumViewHolder, i: Int) {
        val mAlbumDetails = mAlbum[i]
        albumViewHolder.bindUser(mAlbumDetails)
    }

    override fun getItemCount(): Int {
        return mAlbum.size
    }

    fun setData(albums: List<Album>) {
        this.mAlbum.addAll(albums)
        notifyDataSetChanged()
    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ListRowBinding? = DataBindingUtil.bind(itemView)
        fun bindUser(user: Album) {
            binding!!.albums = user
        }
    }
}