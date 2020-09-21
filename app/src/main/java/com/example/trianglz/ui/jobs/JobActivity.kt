package com.example.trianglz.ui.jobs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trianglz.R
import com.example.trianglz.databinding.ActivityMainBinding
import com.example.trianglz.utils.network.Services.QueryValues.DESCRIPTION_Value
import com.example.trianglz.utils.network.Services.QueryValues.TOKEN_Value
import com.example.trianglz.utils.network.Services.QueryValues.PAGE_Value
import kotlinx.android.synthetic.main.activity_main.*

class JobActivity : AppCompatActivity() {
    lateinit var jobVIewModel : JobVIewModel
    private val adapter = JobAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        jobVIewModel = ViewModelProvider(this).get(JobVIewModel::class.java)

        binding.apply {
            this.vm = jobVIewModel
            lifecycleOwner = this@JobActivity
        }
        setupAdapter()
        setupObservers()
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(this)
        jobs_RV.layoutManager = layoutManager
        jobs_RV.adapter = adapter
    }

    private fun setupObservers() {
        jobVIewModel.error.observe(this, Observer { errorMsg ->
            Toast.makeText(this,errorMsg,Toast.LENGTH_LONG).show()
        })
    }
}