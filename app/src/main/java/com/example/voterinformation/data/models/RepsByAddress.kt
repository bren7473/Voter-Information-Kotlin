package com.example.voterinformation.data.models

import androidx.lifecycle.Transformations.map
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.voterinformation.domain.DomainOfficialsListItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@Entity
@JsonClass(generateAdapter = true)
data class RepsByAddress constructor(
    @PrimaryKey
    val divisions: Map<String, Division>,
    val kind: String,
    val normalizedInput: NormalizedInput,
    val offices: List<Office>,
    val officials: List<Official>
)

@Entity
data class repsByAddressDivisions constructor(
    val divisions: Map<String, Division>
)

@Entity
data class repsByAddressOffices constructor(
    val offices: List<Office>
)

