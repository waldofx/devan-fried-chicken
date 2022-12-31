package com.example.devanfriedchicken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devanfriedchicken.room.*
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    lateinit var ViewModel: TransactionViewModel
    lateinit var list: List<TransactionItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        //Room?
        val transactionRepository = TransactionRepository(TransactionDatabase(this))
        val factory = TransactionViewModelFactory(transactionRepository)

        // Initialised View Model
        ViewModel = ViewModelProvider(this, factory).get(TransactionViewModel::class.java)
        val transactionAdapter = TransactionAdapter(listOf(), ViewModel)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = transactionAdapter

        // To display all items in recycler view
        ViewModel.allTransactionItems().observe(this, Observer {
            transactionAdapter.list = it
            transactionAdapter.notifyDataSetChanged()
        })

        // on ClickListener on button to open dialog box
        btnAdd.setOnClickListener {
            TransactionItemDialog(this, object : DialogListener {
                override fun onAddButtonClicked(item: TransactionItems) {
                    ViewModel.insert(item)
                }
            }).show()
        }
    }
}