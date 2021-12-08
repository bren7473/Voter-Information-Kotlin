package com.example.voterinformation.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.voterinformation.data.models.LocalRepsByAddress
import com.example.voterinformation.data.models.RepsByAddress
import com.example.voterinformation.utility.Converters


@Dao
interface OfficialsDao {

        // item list
        @Query("select * from LocalRepsByAddress")
        fun getAllOfficials(): LiveData<List<LocalRepsByAddress>>

        // updates local storage if item is updated
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(items: List<LocalRepsByAddress>)
}

@Database(entities = [LocalRepsByAddress::class], version = 29, exportSchema = false)
@TypeConverters(Converters::class)
abstract class OfficialsDatabase : RoomDatabase() {
        abstract val officialsDao: OfficialsDao
}
