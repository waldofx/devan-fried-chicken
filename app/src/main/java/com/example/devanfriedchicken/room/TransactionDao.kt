package com.example.devanfriedchicken.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.devanfriedchicken.room.TransactionItems

@Dao
interface TransactionDao {

    // Insert function is used to
    // insert data in database.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: TransactionItems)

    // Delete function is used to
    // delete data in database.
    @Delete
    suspend fun delete(item: TransactionItems)

    // getAllTransactionItems function is used to get
    // all the data of database.
    @Query("SELECT * FROM transaction_items")
    fun getAllTransactionItems(): LiveData<List<TransactionItems>>

    // getGroupTransactionItems function is used to get
    // all the data of database grouped by created_at.
    @Query("SELECT *, SUM(itemPriceTotal) AS itemPriceTotal FROM transaction_items" +
            " GROUP BY created_at")
    fun getGroupTransactionItems(): LiveData<List<TransactionItems>>

    // getGroupTransactionItems function is used to get
    // all the data of database grouped by created_at.
    @Query("SELECT * FROM transaction_items WHERE created_at = :time")
    fun getAllByGroupTransactionItems(time: String): LiveData<List<TransactionItems>>
}