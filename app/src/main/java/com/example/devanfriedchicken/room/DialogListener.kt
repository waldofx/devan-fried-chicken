package com.example.devanfriedchicken.room

import com.example.devanfriedchicken.room.TransactionItems

interface DialogListener {
    
    // Create a function to add items
    // in TransactionItems on clicking
    fun onAddButtonClicked(item:TransactionItems)
}