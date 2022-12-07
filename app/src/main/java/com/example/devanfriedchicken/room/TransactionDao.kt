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

//    TypeConverters(MyConverter::class)
//    @Query("SELECT * FROM [transaction]")
//    fun getTransactions(transaction: Transaction): List<Transaction>
}