package com.example.trianglz.data.jobs

import com.google.gson.annotations.SerializedName

data class Job (
    @SerializedName("company_logo")
    var image: String,
    @SerializedName("company")
    val name: String,
    @SerializedName("title")
    val title: String)