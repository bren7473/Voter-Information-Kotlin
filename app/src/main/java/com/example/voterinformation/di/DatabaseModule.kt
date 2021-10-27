package com.example.voterinformation.di

import android.content.Context
import androidx.room.Room
import com.example.voterinformation.database.OfficialsDao
import com.example.voterinformation.database.OfficialsDatabase
import com.example.voterinformation.utility.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): OfficialsDatabase {
        return Room.databaseBuilder(
            appContext,
            OfficialsDatabase::class.java,
            "Items"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideChannelDao(officialsDatabase: OfficialsDatabase): OfficialsDao {
        return officialsDatabase.officialsDao
    }
}