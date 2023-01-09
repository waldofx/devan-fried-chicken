package com.example.devanfriedchicken

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devanfriedchicken.room.*
import kotlinx.android.synthetic.main.activity_detail_transaksi.*
import java.text.SimpleDateFormat

class DetailTransaksiActivity : AppCompatActivity() {
    lateinit var ViewModel: TransactionViewModel
    lateinit var list: List<TransactionItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_transaksi)

        val createdAtIntent = intent.getStringExtra("createdAtIntent").toString()
        val totalIntent = intent.getStringExtra("totalIntent").toString()

        //Text Created At Date + Total Price
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm")
        val createdAtDate = simpleDateFormat.format(createdAtIntent.toLong())
        txtItemDate.text = "TANGGAL TRANSAKSI: $createdAtDate"
        txtItemTotalCost.text = "TOTAL TRANSAKSI: Rp. $totalIntent"

        //Room
        val transactionRepository = TransactionRepository(TransactionDatabase(this))
        val factory = TransactionViewModelFactory(transactionRepository)

        // Initialised View Model
        ViewModel = ViewModelProvider(this, factory).get(TransactionViewModel::class.java)
        val transactionDetailAdapter = TransactionDetailAdapter(listOf(), ViewModel)
        recyclerview_list.layoutManager = LinearLayoutManager(this)
        recyclerview_list.adapter = transactionDetailAdapter

        // To display all items in recycler view
        ViewModel.allbygroupTransactionItems(createdAtIntent).observe(this, Observer {
            transactionDetailAdapter.list = it
            transactionDetailAdapter.notifyDataSetChanged()
        })


        // On click listener to delete transaction group
        buttonHapus.setOnClickListener {
            var deletes = ViewModel.deletebygroupTransactionItems(createdAtIntent).toString()
            if (deletes == "0") {
                Toast.makeText(this, "Item failed to delete...", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Item deleted...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}