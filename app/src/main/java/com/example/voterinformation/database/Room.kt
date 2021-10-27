package com.example.voterinformation.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.voterinformation.data.models.RepsByAddress
import com.example.voterinformation.utility.Converters


@Dao
interface OfficialsDao {

        // item list
        @Query("select * from RepsByAddress")
        fun getAllOfficials(): LiveData<RepsByAddress>

        // updates local storage if item is updated
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertAll(items: RepsByAddress)
}

@Database(entities = [RepsByAddress::class], version = 40, exportSchema = false)
@TypeConverters(Converters::class)
abstract class OfficialsDatabase : RoomDatabase() {
        abstract val officialsDao: OfficialsDao
}
