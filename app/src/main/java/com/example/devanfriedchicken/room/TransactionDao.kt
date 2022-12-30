package com.example.devanfriedchicken.room

import androidx.lifecycle.LiveData
import androidx.room.*
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
}