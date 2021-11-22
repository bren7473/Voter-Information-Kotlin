package com.example.voterinformation.utility

import android.provider.ContactsContract
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
        val official = Types.newParameterizedType(Official::class.java)
        return@lazy moshi.adapter<Official>(official)
    }

    private val addressJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val address = Types.newParameterizedType(List::class.java, Address::class.java)
        return@lazy moshi.adapter<List<Address>>(address)
    }

    private val channelJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val channel = Types.newParameterizedType(List::class.java, Channel::class.java)
        return@lazy moshi.adapter<List<Channel>>(channel)
    }

    private val emailJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val email = Types.newParameterizedType(List::class.java, String::class.java)
        return@lazy moshi.adapter<List<String>>(email)
    }
    private val phoneJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val phone = Types.newParameterizedType(List::class.java, String::class.java)
        return@lazy moshi.adapter<List<String>>(phone)
    }
    private val urlJsonAdapter by lazy {
        val moshi = baseMoshi.newBuilder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val url = Types.newParameterizedType(List::class.java, String::class.java)
        return@lazy moshi.adapter<List<String>>(url)
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
    fun fromAddress(address: List<Address>?): String? {
        return addressJsonAdapter.toJson(address)
    }

    @TypeConverter
    fun toAddress(json: String?): List<Address>? {
        return json?.let {addressJsonAdapter.fromJson(json)}
    }

    @TypeConverter
    fun fromEmail(email: List<String>?): String? {
        return emailJsonAdapter.toJson(email)
    }

    @TypeConverter
    fun toEmail(json: String?): List<String>? {
        return json?.let {emailJsonAdapter.fromJson(json)}
    }

    @TypeConverter
    fun fromChannel(channel: List<Channel>?): String? {
        return channelJsonAdapter.toJson(channel)
    }

    @TypeConverter
    fun toChannel(json: String?): List<Channel>? {
        return json?.let {channelJsonAdapter.fromJson(json)}
    }

    @TypeConverter
    fun fromOfficial(official: Official?): String {
        return officialJsonAdapter.toJson(official)
    }

    @TypeConverter
    fun toOfficial(json: String): Official? {
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