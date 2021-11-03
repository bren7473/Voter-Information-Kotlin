package com.example.voterinformation.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Office(
    val divisionId: String?,
    val levels: List<String>?,
    val name: String?,
    val officialIndices: List<Int>?,
    val roles: List<String>?
)