package com.example.devanfriedchicken

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.devanfriedchicken.room.*
import kotlinx.android.synthetic.main.activity_detail_transaksi.*
import kotlinx.android.synthetic.main.activity_riwayat_transaksi.*

class DetailTransaksiActivity : AppCompatActivity() {
    lateinit var ViewModel: TransactionViewModel
    lateinit var list: List<TransactionItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_transaksi)

        val createdAtIntent = intent.getStringExtra("createdAtIntent").toString()

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


        // On click listener to export CSV/Excel
        buttonHapus.setOnClickListener {
            Toast.makeText(this, "Created $createdAtIntent", Toast.LENGTH_SHORT).show()
        }
    }
}