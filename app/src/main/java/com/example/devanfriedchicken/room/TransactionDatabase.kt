package com.example.devanfriedchicken.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.devanfriedchicken.room.TransactionItems

@Database(
    entities = [TransactionItems::class],
    version = 1
)
abstract class TransactionDatabase : RoomDatabase(){

    abstract fun getTransactionDao(): TransactionDao

    companion object {
        @Volatile
        private var instance: TransactionDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, TransactionDatabase::class.java, "TransactionDatabase.db").build()
    }
}