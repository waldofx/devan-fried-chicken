package com.example.devanfriedchicken.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Transaction (
    @PrimaryKey(autoGenerate = true)
    val id_transaction: Int,
    val total_price: Int,
    val date: Date,
)