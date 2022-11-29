package com.example.devanfriedchicken.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Transaction::class],
    version = 1
)
abstract class TransactionDB : RoomDatabase(){

    abstract fun TransactionDao() : TransactionDao
    //    abstract fun productDao() : TransactionDao

    companion object {

        @Volatile private var instance : TransactionDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TransactionDB::class.java,
            "devanfriedchicken.db"
        ).build()

    }
}