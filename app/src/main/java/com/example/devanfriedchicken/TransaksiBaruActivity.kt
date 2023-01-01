package com.example.devanfriedchicken

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.devanfriedchicken.room.*
import kotlinx.android.synthetic.main.activity_transaksi_baru.*

class TransaksiBaruActivity() : AppCompatActivity() {
    lateinit var transactionViewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi_baru)

        val transactionRepository = TransactionRepository(TransactionDatabase(this))
        val factory = TransactionViewModelFactory(transactionRepository)
        transactionViewModel = ViewModelProvider(this, factory).get(TransactionViewModel::class.java)

        // Click listener on Save button
        // to save all data.
        buttonCatat.setOnClickListener {

            // Take all three inputs in different variables from user
            // and add it in Transaction Items database
            val name_pahabawah = "Paha Bawah"
            val quantity_pahabawah = etPahaBawahQuantity.text.toString().toInt()
            val price_pahabawah = 7000

//            if (quantity != 0) {
                val item_pahabawah = TransactionItems(name_pahabawah, quantity_pahabawah, price_pahabawah)
                transactionViewModel.insert(item_pahabawah) //don't know why can't import insert
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
//            }
        }

        // On click listener on cancel text to close dialog box
        buttonBatal.setOnClickListener {
            etPahaBawahQuantity.setText("")
        }
    }
}