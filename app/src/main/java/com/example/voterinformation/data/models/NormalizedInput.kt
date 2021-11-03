package com.example.voterinformation.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NormalizedInput(
    val line1: String?,
    val city: String?,
    val state: String?,
    val zip: Int?
)