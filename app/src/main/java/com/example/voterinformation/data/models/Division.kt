package com.example.voterinformation.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Division(
    val name: String,
    var officeIndices: List<Int>?
)