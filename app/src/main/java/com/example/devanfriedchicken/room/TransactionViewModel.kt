package com.example.devanfriedchicken.room

import androidx.lifecycle.ViewModel
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() {

    // In coroutines thread insert item in insert function.
    fun insert(item: TransactionItems) = GlobalScope.launch {
        repository.insert(item)
    }

    // In coroutines thread delete item in delete function.
    fun delete(item: TransactionItems) = GlobalScope.launch {
        repository.delete(item)
    }

    //Here we initialized allTransactionItems function with repository
    fun allTransactionItems() = repository.allTransactionItems()

    //Here we initialized groupTransactionItems function with repository
    fun groupTransactionItems() = repository.groupTransactionItems()

    //Here we initialized allbygroupTransactionItems function with repository
    fun allbygroupTransactionItems(time: String) = repository.allbygroupTransactionItems(time)

    //Here we initialized deletebygroupTransactionItems function with repository
    fun deletebygroupTransactionItems(time: String) = GlobalScope.launch {
        repository.deletebygroupTransactionItems(time)
    }
}