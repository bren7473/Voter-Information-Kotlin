package com.example.voterinformation.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    val city: String?,
    val line1: String?,
    val line2: String?,
    val state: String?,
    val zip: Int?
)