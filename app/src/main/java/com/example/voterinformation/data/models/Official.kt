package com.example.voterinformation.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Official(
    var address: List<Address>?,
    var channels: List<Channel>?,
    var emails: List<String>?,
    val name: String,
    val party: String,
    val phones: List<String>,
    var photoUrl: String?,
    val urls: List<String>
)