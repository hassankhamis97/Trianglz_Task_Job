package com.example.trianglz.data.jobs

import com.example.trianglz.R
import com.example.trianglz.application.BaseApplication
import com.example.trianglz.utils.network.*
import com.example.trianglz.utils.network.RetrofitBuilder.jobsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JobRepository() {

    suspend fun getJobs(description:String, page: Int, token: String) = withContext(Dispatchers.IO) {
        if (ConnectivityUtils(BaseApplication.appContext).isNetworkConnected) {
            try {
                Response.success(
                    data = jobsService.getJobs(
                        description = description,
                        page = page,
                        token = token
                    )
                )
            } catch (exception: Exception) {
                Response.error(data = null, message = exception.message ?: "An Error Occurred!")
            }
        } else {
            Response.error(data = null, message = BaseApplication.appContext.getString(R.string.error_no_internet_connection))
        }
    }
}