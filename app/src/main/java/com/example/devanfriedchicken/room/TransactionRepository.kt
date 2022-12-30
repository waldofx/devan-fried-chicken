package com.example.devanfriedchicken.room

import com.example.devanfriedchicken.room.TransactionItems

class TransactionRepository(private val db: TransactionDatabase) {

    suspend fun insert(item: TransactionItems) = db.getTransactionDao().insert(item)
    suspend fun delete(item: TransactionItems) = db.getTransactionDao().delete(item)

    fun allTransactionItems() = db.getTransactionDao().getAllTransactionItems()
}