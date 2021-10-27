package com.example.voterinformation.repository
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.voterinformation.data.models.RepsByAddress
import com.example.voterinformation.database.OfficialsDatabase
import com.example.voterinformation.network.LowerBodyListService
import javax.inject.Inject

class OfficialsListRepository @Inject constructor(
    private val lowerBodyListService: LowerBodyListService,
    private val database: OfficialsDatabase
) {

    val items: LiveData<RepsByAddress> = database.officialsDao.getAllOfficials()


    suspend fun refreshItemList() {
        try {
            val items = lowerBodyListService.getLowerBodyList()
            Log.d("Items: ", items.toString())
            database.officialsDao.insertAll(items)
        } catch (e: Exception) {
            Log.d("Exception: ", e.message.toString() + "::" + e.cause.toString() + "::" + e.localizedMessage)
        }
    }
}