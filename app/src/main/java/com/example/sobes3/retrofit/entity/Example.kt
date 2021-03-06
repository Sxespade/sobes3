package com.example.sobes3.retrofit.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Example (
    @SerializedName("page")
    @Expose
    var page: Int? = null,

    @SerializedName("results")
    @Expose
    var results: List<Picture>? = null,

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null,

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
)