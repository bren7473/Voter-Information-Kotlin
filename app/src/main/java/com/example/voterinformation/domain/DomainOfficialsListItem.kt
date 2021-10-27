package com.example.voterinformation.domain

import com.example.voterinformation.data.models.*

data class DomainOfficialsListItem (
    var divisions: Divisions,
    var kind: String,
    var normalizedInput: NormalizedInput,
    var offices: List<Office>,
    var officials: List<Official>
)