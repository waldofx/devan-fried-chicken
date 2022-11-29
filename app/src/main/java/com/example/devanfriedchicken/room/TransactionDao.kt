package com.example.devanfriedchicken.room

import androidx.room.*

@Dao
interface TransactionDao {

    @Insert
    suspend fun addTransaction(transaction: Transaction)

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM `transaction`")
    suspend fun getTransactions(transaction: Transaction): List<Transaction>
}