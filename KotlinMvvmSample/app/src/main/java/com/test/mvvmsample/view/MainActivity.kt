package com.test.mvvmsample.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.test.mvvmsample.R
import com.test.mvvmsample.databinding.ActivityMainBinding
import com.test.mvvmsample.model.Album
import com.test.mvvmsample.viewmodel.AlbumViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mAlbumViewModel: AlbumViewModel
    private lateinit var mActivityBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mAlbumViewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)


        initSetUpViews();
    }

    private fun initSetUpViews() {

        val mAlbumAdapter = AlbumAdapter()

        val mLinearLayoutManger = LinearLayoutManager(this)
        mLinearLayoutManger.orientation = LinearLayoutManager.VERTICAL
        mActivityBinding.albumRecyclerView.layoutManager = mLinearLayoutManger
        mActivityBinding.albumRecyclerView.adapter = mAlbumAdapter

        mAlbumViewModel.fetchAlbums().observe(this, Observer<List<Album>> { users ->
            // mAlbumAdapter.setData(users!!)
        })

        mAlbumViewModel.fetchAlbums().observe(this, Observer {
            it?.let {
                mAlbumAdapter.setData(it)
            }

        })
    }


}
