package com.example.trianglz.ui.jobs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trianglz.data.jobs.Job
import com.example.trianglz.data.jobs.JobRepository
import com.example.trianglz.utils.network.Services
import com.example.trianglz.utils.network.Status
import kotlinx.coroutines.launch

class JobVIewModel: ViewModel() {

    val jobs = MutableLiveData<List<Job>>()
    val error = MutableLiveData<String>()
    val isLoadingData = MutableLiveData<Boolean>()
    private val repository by lazy {
        JobRepository()
    }
    init {
        /**
         * i called getJobs here for if i make rotation don't call again
         */
        getJobs(
            Services.QueryValues.DESCRIPTION_Value,
            Services.QueryValues.PAGE_Value,
            Services.QueryValues.TOKEN_Value
        )
    }
    private fun getJobs(description:String, page: Int, token: String) {
        viewModelScope.launch {
            isLoadingData.postValue(true)
            val response = repository.getJobs(description, page, token)
            when (response.status) {
                Status.SUCCESS -> {
                    isLoadingData.postValue(false)
                    jobs.postValue(response.data)
                }
                else -> {
                    isLoadingData.postValue(false)
                    error.postValue(response.message)
                }
            }
        }

    }
}