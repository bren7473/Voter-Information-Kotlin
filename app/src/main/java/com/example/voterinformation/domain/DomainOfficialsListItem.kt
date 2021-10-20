package com.example.voterinformation.domain

import com.example.voterinformation.network.models.Division
import com.example.voterinformation.network.models.Office
import com.example.voterinformation.network.models.Official

data class DomainOfficialsListItem (
    val offices: List<Office>,
    val officials: List<Official>,
    val divisions: Map<String, Division>
)