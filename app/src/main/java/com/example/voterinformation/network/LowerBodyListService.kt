package com.example.voterinformation.network

import com.example.voterinformation.data.Constants
import com.example.voterinformation.network.models.Officials
import retrofit2.http.GET

interface LowerBodyListService {

    @GET(Constants.USER_LOWER_BODY)
    suspend fun getLowerBodyList(): List<Officials>
}