package com.example.voterinformation.repository
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.voterinformation.data.models.LocalRepsByAddress
import com.example.voterinformation.data.models.RepsByAddress
import com.example.voterinformation.database.OfficialsDatabase
import com.example.voterinformation.network.LowerBodyListService
import java.util.*
import javax.inject.Inject
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities

class OfficialsListRepository @Inject constructor(
    private val lowerBodyListService: LowerBodyListService,
    private val database: OfficialsDatabase
) {

    val items: LiveData<List<LocalRepsByAddress>> = database.officialsDao.getAllOfficials()


    suspend fun refreshItemList() {

        try {
            var localOfficialArrayList: MutableList<LocalRepsByAddress> = mutableListOf<LocalRepsByAddress>()
            val items: RepsByAddress = lowerBodyListService.getLowerBodyList()

            var division = ""
            var office = ""
            var officeRole: List<String>?
            val offices = items.offices
            val officials = items.officials

            Log.d("items", items.toString())

            items.divisions.entries.forEach {
                division = it.value.name
                it.value.officeIndices?.forEach {
                    office = offices?.get(it)?.name.toString()
                    officeRole = offices?.get(it)?.roles
                    offices?.get(it)?.officialIndices?.forEach {

                        val localOfficial: LocalRepsByAddress? =
                            officials?.get(it)?.name?.let { it1 ->
                                officials?.get(it)?.let { it2 ->
                                    LocalRepsByAddress(
                                        it1, division, office,
                                        it2
                                    )
                                }
                            }

                        if (localOfficial != null) {
                            localOfficialArrayList.add(localOfficial)
                        }

                        Log.d("division", division)
                        Log.d("office", office)
                        Log.d("officials", officials?.get(it).toString())
                    }
                }
            }

            val localOfficialList = localOfficialArrayList.toList()

            Log.d("Items: ", items.toString())
            database.officialsDao.insert(localOfficialList)
        } catch (e: Exception) {
            Log.d("Exception: ", e.toString())
        }
    }
}