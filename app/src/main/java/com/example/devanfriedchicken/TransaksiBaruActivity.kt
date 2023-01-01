package com.example.devanfriedchicken

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devanfriedchicken.room.*
import kotlinx.android.synthetic.main.activity_transaksi_baru.*
import kotlinx.android.synthetic.main.transactiondialog.*

class TransaksiBaruActivity() : AppCompatActivity() {
    var dialogListener: DialogListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi_baru)

        // Click listener on Save button
        // to save all data.
        buttonCatat.setOnClickListener {

            // Take all three inputs in different variables from user
            // and add it in Transaction Items database
            val name = "Paha Bawah"
            val quantity = etPahaBawahQuantity.text.toString().toInt()
            val price = 7000

//            if (quantity != 0) {
                val item1 = TransactionItems(name, quantity, price)
//                TransactionViewModel.insert(item1) //don't know why can't import insert
                dialogListener?.onAddButtonClicked(item1) //fail to actually save
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
//            }
        }

        // On click listener on cancel text to close dialog box
        buttonBatal.setOnClickListener {
            etPahaBawahQuantity.setText("")
        }
    }
}