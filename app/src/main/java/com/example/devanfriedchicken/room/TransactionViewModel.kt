package com.example.devanfriedchicken.room

import androidx.lifecycle.ViewModel
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

}