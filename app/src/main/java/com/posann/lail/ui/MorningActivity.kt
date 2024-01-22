package com.posann.lail.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.posann.lail.MainViewModel
import com.posann.lail.R
import com.posann.lail.data.response.DataItem
import com.posann.lail.databinding.ActivityMorningBinding
import com.posann.lail.ui.adapter.MorningAdapter

class MorningActivity : AppCompatActivity() {

    private lateinit var morningBinding: ActivityMorningBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        morningBinding = ActivityMorningBinding.inflate(layoutInflater)
        setContentView(morningBinding.root)

        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)

        mainViewModel.getDzikirPagi()
        mainViewModel.getDzikirPetang()

        showAdapter()
    }

    private fun showAdapter() {
        val lm = LinearLayoutManager(this)
        morningBinding.rvItemMorning.layoutManager = lm

        val mode = intent.getStringExtra(MODE)

        if (mode == "evening"){
            mainViewModel.listDzikirPetang.observe(this) { result ->
                setData(result)
            }
        }

        else {
            mainViewModel.listDzikirPagi.observe(this) { result ->
                setData(result)
            }
        }
    }

    private fun setData(result: ArrayList<DataItem>) {
        val adapter = MorningAdapter(result)
        morningBinding.rvItemMorning.adapter = adapter
    }

    companion object {
        public val MODE = "MODE"
    }
}