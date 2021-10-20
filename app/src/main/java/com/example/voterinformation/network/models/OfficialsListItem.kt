package com.example.voterinformation.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Officials (
    val offices: List<Office>,
    val officials: List<Official>,
    val divisions: Map<String, Division>
)

@JsonClass(generateAdapter = true)
data class Division (
    val name: String,
    val officeIndices: List<Long>
)

@JsonClass(generateAdapter = true)
data class Office (
    val name: String,

    @Json(name = "divisionId")
    val divisionID: String,

    val levels: List<String>,
    val roles: List<String>,
    val officialIndices: List<Long>
)

@JsonClass(generateAdapter = true)
data class Official (
    val name: String,
    val address: List<Address>,
    val party: String,
    val phones: List<String>,
    val urls: List<String>,
    val channels: List<Channel>? = null,

    @Json(name = "photoUrl")
    val photoURL: String? = null,

    val emails: List<String>? = null
)

@JsonClass(generateAdapter = true)
data class Address (
    val line1: String,
    val city: String,
    val state: String,
    val zip: String
)


@JsonClass(generateAdapter = true)
data class Channel (
    val type: String,
    val id: String
)