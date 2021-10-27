package com.example.voterinformation.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    val city: String,
    val line1: String,
    val line2: String = "your moms house",
    val state: String,
    val zip: String
)