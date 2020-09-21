package com.example.trianglz.data.jobs.remote

import com.example.trianglz.data.jobs.Job
import com.example.trianglz.utils.network.Services.EndPoints.MAIN_JOBS
import com.example.trianglz.utils.network.Services.QueryParams.DESCRIPTION
import com.example.trianglz.utils.network.Services.QueryParams.TOKEN
import com.example.trianglz.utils.network.Services.QueryParams.PAGE
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsService {
    @GET(MAIN_JOBS)
    suspend fun getJobs(@Query(DESCRIPTION) description: String, @Query(PAGE) page: Int, @Query(TOKEN) token:String): List<Job>
}