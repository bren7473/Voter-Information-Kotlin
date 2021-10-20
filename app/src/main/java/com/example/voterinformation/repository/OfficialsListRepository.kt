package com.example.voterinformation.repository

import com.example.voterinformation.network.LowerBodyListService
import javax.inject.Inject

class OfficialsListRepository @Inject constructor(
    private val lowerBodyListService: LowerBodyListService,
) {

}