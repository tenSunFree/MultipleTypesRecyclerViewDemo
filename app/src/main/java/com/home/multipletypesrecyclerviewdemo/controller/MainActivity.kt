package com.home.multipletypesrecyclerviewdemo.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.home.multipletypesrecyclerviewdemo.R
import com.home.multipletypesrecyclerviewdemo.model.MainBean
import com.home.multipletypesrecyclerviewdemo.model.MainModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
    }

    private fun initializeView() {
        val mainModel = MainModel()
        mainModel.getMainData(object : MainModel.OnMainDataListener {
            override fun onSuccess(mainData: MainBean) {
                val adapter = MainRecyclerViewAdapter()
                adapter.setMainData(mainData)
                recycler_view.adapter = adapter
            }
        })
    }
}
