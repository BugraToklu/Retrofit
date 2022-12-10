package com.bugratoklu.retrofit.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugratoklu.retrofit.R
import com.bugratoklu.retrofit.databinding.ActivityMainBinding
import com.bugratoklu.retrofit.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostViewModel
    private val postAdapter = PostAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        viewModel.refreshData()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }

        observeViewModel()

    }

    fun observeViewModel(){
        viewModel.posts.observe(this, Observer { postList ->
            postList?.let {
                postAdapter.updateList(postList)
            }
        })
    }

}