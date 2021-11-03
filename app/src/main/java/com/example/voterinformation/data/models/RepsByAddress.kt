package com.example.voterinformation.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass


@Entity
@JsonClass(generateAdapter = true)
data class RepsByAddress constructor(
    val kind: String?,
    @PrimaryKey
    val divisions: Map<String, Division>,
    val offices: List<Office>?,
    val officials: List<Official>?,
    @Embedded
    val normalizedInput: NormalizedInput?,
)

