@file:Suppress("LocalVariableName")

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
        var quantity_pahaatas = 0
        var quantity_dada = 0
        var quantity_kepala = 0

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
                transactionViewModel.insert(item_sayap)
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
            }
            if (quantity_pahaatas != 0) {
                val name_pahaatas = "Paha Atas"
                quantity_pahaatas = etPahaAtasQuantity.text.toString().toInt()
                val price_pahaatas = 9000
                val item_pahaatas = TransactionItems(name_pahaatas, quantity_pahaatas, price_pahaatas)
                transactionViewModel.insert(item_pahaatas)
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
            }
            if (quantity_dada != 0) {
                val name_dada = "Dada"
                quantity_dada = etDadaQuantity.text.toString().toInt()
                val price_dada = 9000
                val item_dada = TransactionItems(name_dada, quantity_dada, price_dada)
                transactionViewModel.insert(item_dada)
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
            }
            if (quantity_kepala != 0) {
                val name_kepala = "Kepala"
                quantity_kepala = etKepalaQuantity.text.toString().toInt()
                val price_kepala = 3000
                val item_kepala = TransactionItems(name_kepala, quantity_kepala, price_kepala)
                transactionViewModel.insert(item_kepala)
                Toast.makeText(applicationContext, "Item inserted...", Toast.LENGTH_SHORT).show()
            }
        }

        // On click listener on batal to clear
        buttonBatal.setOnClickListener {
            etPahaBawahQuantity.setText("")
            quantity_pahabawah = 0
            etSayapQuantity.setText("")
            quantity_sayap = 0
            etPahaAtasQuantity.setText("")
            quantity_pahaatas = 0
            etDadaQuantity.setText("")
            quantity_dada = 0
            etKepalaQuantity.setText("")
            quantity_kepala = 0
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

        tambah_pa.setOnClickListener {
            if(etPahaAtasQuantity.text.toString() == "") {
                etPahaAtasQuantity.setText(quantity_pahaatas.toString())
            } else{
                quantity_pahaatas++
                etPahaAtasQuantity.setText(quantity_pahaatas.toString())
            }
        }
        kurang_pa.setOnClickListener {
            if(etPahaAtasQuantity.text.toString() != "0"){
                if(etPahaAtasQuantity.text.toString() == "") {
                    etPahaAtasQuantity.setText(quantity_pahaatas.toString())
                } else{
                    quantity_pahaatas--
                    etPahaAtasQuantity.setText(quantity_pahaatas.toString())
                }
            }
        }

        tambah_d.setOnClickListener {
            if(etDadaQuantity.text.toString() == "") {
                etDadaQuantity.setText(quantity_dada.toString())
            } else{
                quantity_dada++
                etDadaQuantity.setText(quantity_dada.toString())
            }
        }
        kurang_d.setOnClickListener {
            if(etDadaQuantity.text.toString() != "0"){
                if(etDadaQuantity.text.toString() == "") {
                    etDadaQuantity.setText(quantity_dada.toString())
                } else{
                    quantity_dada--
                    etDadaQuantity.setText(quantity_dada.toString())
                }
            }
        }

        tambah_k.setOnClickListener {
            if(etKepalaQuantity.text.toString() == "") {
                etKepalaQuantity.setText(quantity_kepala.toString())
            } else{
                quantity_kepala++
                etKepalaQuantity.setText(quantity_kepala.toString())
            }
        }
        kurang_k.setOnClickListener {
            if(etKepalaQuantity.text.toString() != "0"){
                if(etKepalaQuantity.text.toString() == "") {
                    etKepalaQuantity.setText(quantity_kepala.toString())
                } else{
                    quantity_kepala--
                    etKepalaQuantity.setText(quantity_kepala.toString())
                }
            }
        }
    }
}