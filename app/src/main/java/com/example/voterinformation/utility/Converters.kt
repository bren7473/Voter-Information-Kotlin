package com.example.voterinformation.utility

import android.util.Log
import androidx.room.TypeConverter
import com.example.voterinformation.data.models.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Converters {

    private val baseMoshi: Moshi = Moshi.Builder()
        .build()

    private val officeJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val officeList = Types.newParameterizedType(List::class.java, Office::class.java)
        return@lazy moshi.adapter<List<Office>>(officeList)
    }

    private val officialJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val officialList = Types.newParameterizedType(List::class.java, Official::class.java)
        return@lazy moshi.adapter<List<Official>>(officialList)
    }

    private val divisionJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val division = Types.newParameterizedType(Map::class.java, String::class.java, Division::class.java)
        return@lazy moshi.adapter<Map<String, Division>>(division)
    }

    private val normalizedInputJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val normalizedInput = Types.newParameterizedType(NormalizedInput::class.java)
        return@lazy moshi.adapter<NormalizedInput>(normalizedInput)
    }

    @TypeConverter
    fun fromOffice(office: List<Office>?): String? {
        return officeJsonAdapter.toJson(office)
    }

    @TypeConverter
    fun toOffice(json: String?): List<Office>? {
        return json?.let {officeJsonAdapter.fromJson(json)}
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
    fun fromDivision(division: Map<String, Division>?): String? {
        return divisionJsonAdapter.toJson(division)
    }

    @TypeConverter
    fun toDivision(json: String?): Map<String, Division>? {
        return json?.let {divisionJsonAdapter.fromJson(json)}
    }

    @TypeConverter
    fun fromNormalizedInput(normalizedInput: NormalizedInput?): String? {
        return normalizedInputJsonAdapter.toJson(normalizedInput)
    }

    @TypeConverter
    fun toNormalizedInput(json: String?): NormalizedInput? {
        return json?.let {normalizedInputJsonAdapter.fromJson(json)}
    }
}