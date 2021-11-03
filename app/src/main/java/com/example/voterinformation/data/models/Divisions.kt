package com.example.voterinformation.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Divisions(
    val divisions: Map<String, Division>?
)