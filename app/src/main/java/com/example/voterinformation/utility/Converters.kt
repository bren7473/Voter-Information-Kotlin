package com.example.voterinformation.utility

import android.util.Log
import androidx.room.TypeConverter
import com.example.voterinformation.data.models.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Converters {

    private val officeJsonAdapter by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val officeList = Types.newParameterizedType(List::class.java, Office::class.java)
        return@lazy moshi.adapter<List<Office>>(officeList)
    }

    private val officialJsonAdapter by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val officialList = Types.newParameterizedType(List::class.java, Official::class.java)
        return@lazy moshi.adapter<List<Official>>(officialList)
    }

    private val divisionJsonAdapter by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val division = Types.newParameterizedType(Map::class.java, Division::class.java)
        return@lazy moshi.adapter<Map<String, Division>>(division)
    }

    private val divisionsJsonAdapter by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val divisions = Types.newParameterizedType(Division::class.java)
        return@lazy moshi.adapter<Divisions>(divisions)
    }

    private val normalizedInputAdapter by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val normalizedInput =
            Types.newParameterizedType(List::class.java, NormalizedInput::class.java)
        return@lazy moshi.adapter<NormalizedInput>(normalizedInput)
    }

    @TypeConverter
    fun fromOffice(office: List<Office>): String {
        return officeJsonAdapter.toJson(office)
    }

    @TypeConverter
    fun toOffice(json: String): List<Office>? {
        return officeJsonAdapter.fromJson(json)
    }

    @TypeConverter
    fun fromOfficial(official: List<Official>): String {
        return officialJsonAdapter.toJson(official)
    }

    @TypeConverter
    fun toOfficial(json: String): List<Official>? {
        return officialJsonAdapter.fromJson(json)
    }

    @TypeConverter
    fun fromDivision(division: Map<String, Division>): String {
        return divisionJsonAdapter.toJson(division)
    }

    @TypeConverter
    fun toDivision(json: String): Map<String, Division>? {
        return divisionJsonAdapter.fromJson(json)
    }

    @TypeConverter
    fun fromNormalizedInput(normalizedInput: NormalizedInput): String {
        return normalizedInputAdapter.toJson(normalizedInput)
    }

    @TypeConverter
    fun toNormalizedInput(json: String): NormalizedInput? {
        return normalizedInputAdapter.fromJson(json)
    }

}