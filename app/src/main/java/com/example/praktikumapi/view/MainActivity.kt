package com.example.praktikumapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikumapi.R
import com.example.praktikumapi.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //inisialisasi viewModel dan adapter
    lateinit var viewModel: ListViewModel
    private val photoListAdapter = PhotoListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fetch data
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        //apply data ke RecyclerView
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photoListAdapter
        }
        observeViewModel()
    }

    //update data misal muncul data baru
    fun observeViewModel() {
        viewModel.photos.observe(this, Observer { photos ->
            photos?.let {
                photoListAdapter.updatePhotos(it)
            }
        })
    }
}