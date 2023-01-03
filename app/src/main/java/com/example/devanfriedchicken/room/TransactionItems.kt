package com.example.devanfriedchicken.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

// This is a data class which store data.
// Entities class create a table in database,

@Entity(tableName = "transaction_items")

data class TransactionItems (

    // create itemName variable to
    // store transaction items.
    @ColumnInfo(name = "itemName")
    var itemName: String,

    // create itemQuantity variable
    // to store transaction quantity.
    @ColumnInfo(name = "itemQuantity")
    var itemQuantity: Int,

    // create itemPrice variable to
    // store transaction price.
    @ColumnInfo(name = "itemPrice")
    var itemPrice: Int,

    // create itemPriceTotal variable to
    // store transaction price.
    @ColumnInfo(name = "itemPriceTotal")
    var itemPriceTotal: Int,

) {
    // Primary key is a unique key
    // for different database.
    @PrimaryKey(autoGenerate = true)
    var id_transaction: Int? = null
}