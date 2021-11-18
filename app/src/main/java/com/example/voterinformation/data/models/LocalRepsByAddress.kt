package com.example.voterinformation.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class LocalRepsByAddress constructor(
    @PrimaryKey
    var nameKey: String,
    var division: String?,
    var office: String?,
    @Embedded
    var official: Official
)
