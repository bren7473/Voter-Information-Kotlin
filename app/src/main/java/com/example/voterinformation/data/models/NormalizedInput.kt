package com.example.voterinformation.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NormalizedInput(
    var city: String?,
    var line1: String?,
    var state: String?,
    var zip: String?
)