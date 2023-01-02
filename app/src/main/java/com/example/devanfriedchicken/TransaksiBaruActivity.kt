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

        //init quantities
        var quantity_pahabawah = 0
        var quantity_sayap = 0

        // Click listener on Save button to save all data.
        buttonCatat.setOnClickListener {

            // Take all three inputs in different variables from user
            // and add it in Transaction Items database
            if (quantity_pahabawah != 0) {
                val name_pahabawah = "Paha Bawah"
                quantity_pahabawah = etPahaBawahQuantity.text.toString().toInt()
                val price_pahabawah = 7000
                val item_pahabawah = TransactionItems(name_pahabawah, quantity_pahabawah, price_pahabawah)
                transactionViewModel.insert(item_pahabawah)
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
            }

            if (quantity_sayap != 0) {
                val name_sayap = "Sayap"
                quantity_sayap = etSayapQuantity.text.toString().toInt()
                val price_sayap = 7000
                val item_sayap = TransactionItems(name_sayap, quantity_sayap, price_sayap)
                transactionViewModel.insert(item_sayap) //don't know why can't import insert
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
            }
        }

        // On click listener on batal to clear
        buttonBatal.setOnClickListener {
            etPahaBawahQuantity.setText("")
            quantity_pahabawah = 0
            etSayapQuantity.setText("")
            quantity_sayap = 0
        }


        // On click listener on tambah kurang paha bawah
        tambah_pb.setOnClickListener {
            if(etPahaBawahQuantity.text.toString() == "") {
                etPahaBawahQuantity.setText(quantity_pahabawah.toString())
            } else{
                quantity_pahabawah++
                etPahaBawahQuantity.setText(quantity_pahabawah.toString())
            }
        }

        kurang_pb.setOnClickListener {
            if(etPahaBawahQuantity.text.toString() != "0"){
                if(etPahaBawahQuantity.text.toString() == "") {
                    etPahaBawahQuantity.setText(quantity_pahabawah.toString())
                } else{
                    quantity_pahabawah--
                    etPahaBawahQuantity.setText(quantity_pahabawah.toString())
                }
            }
        }

        tambah_s.setOnClickListener {
            if(etSayapQuantity.text.toString() == "") {
                etSayapQuantity.setText(quantity_sayap.toString())
            } else{
                quantity_sayap++
                etSayapQuantity.setText(quantity_sayap.toString())
            }
        }

        kurang_s.setOnClickListener {
            if(etSayapQuantity.text.toString() != "0"){
                if(etSayapQuantity.text.toString() == "") {
                    etSayapQuantity.setText(quantity_sayap.toString())
                } else{
                    quantity_sayap--
                    etSayapQuantity.setText(quantity_sayap.toString())
                }
            }
        }

    }
}