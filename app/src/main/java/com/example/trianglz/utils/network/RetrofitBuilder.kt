package com.example.trianglz.utils.network

import com.example.trianglz.data.jobs.remote.JobsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://jobs.github.com/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val jobsService: JobsService by lazy {
        getRetrofit().create(JobsService::class.java)
    }
}