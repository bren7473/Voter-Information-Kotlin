package com.example.voterinformation.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Office(
    @PrimaryKey
    val divisionId: String,
    val levels: List<String>,
    val name: String,
    val officialIndices: List<Int>,
    val roles: List<String>
)