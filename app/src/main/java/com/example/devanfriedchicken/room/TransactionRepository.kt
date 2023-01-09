package com.example.devanfriedchicken.room

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.devanfriedchicken.room.TransactionItems

class TransactionRepository(private val db: TransactionDatabase) {

    suspend fun insert(item: TransactionItems) = db.getTransactionDao().insert(item)
    suspend fun delete(item: TransactionItems) = db.getTransactionDao().delete(item)

    fun allTransactionItems() = db.getTransactionDao().getAllTransactionItems()
    fun groupTransactionItems() = db.getTransactionDao().getGroupTransactionItems()
    fun allbygroupTransactionItems(time: String) = db.getTransactionDao().getAllByGroupTransactionItems(time)

    suspend fun deletebygroupTransactionItems(time: String) = db.getTransactionDao().deleteAllByGroupTransactionItems(time)

}