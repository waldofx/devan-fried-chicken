package com.example.devanfriedchicken

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devanfriedchicken.room.*
import kotlinx.android.synthetic.main.activity_riwayat_transaksi.*
import kotlinx.android.synthetic.main.activity_riwayat_transaksi.rvList
import java.io.File
import java.io.FileWriter

class RiwayatTransaksiActivity : AppCompatActivity() {
    lateinit var ViewModel: TransactionViewModel
    lateinit var list: List<TransactionItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_transaksi)

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

        // On click listener to export CSV/Excel
        buttonExcel.setOnClickListener {
            val exportDir = File(getExternalFilesDir(null) , "/CSV")// your path where you want save your file
            Log.e("error", exportDir.toString());
            if (!exportDir.exists()) {
                Log.e("error", "Directory doesn't exist");
                if (exportDir.mkdir()) {
                    Log.e("message", "Directory created successfully");
                } else {
                    Log.e("error", "Directory creation failed");
                }
            }

            val TABLE_NAME = "transaction_items"
            val file = File(exportDir, "$TABLE_NAME.csv")//$TABLE_NAME.csv is like user.csv or any name you want to save
            try {
                file.createNewFile()
                val database: TransactionDatabase = TransactionDatabase.invoke(this)
                val csvWrite = CSVWriter(FileWriter(file))
                val curCSV = database.query("SELECT * FROM $TABLE_NAME", null)// query for get all data of your database table
                csvWrite.writeNext(curCSV.columnNames)
                while (curCSV.moveToNext()) {
                    //Which column you want to export
                    val arrStr = arrayOfNulls<String>(curCSV.columnCount)
                    for (i in 0 until curCSV.columnCount - 1) {
                        when (i) {
                            20, 22 -> {
                            }
                            else -> arrStr[i] = curCSV.getString(i)
                        }
                    }
                    csvWrite.writeNext(arrStr)
                }
                csvWrite.close()
                curCSV.close()
                Toast.makeText(applicationContext, "Exported SuccessFully", Toast.LENGTH_SHORT).show()
            } catch (sqlEx: Exception) {
                Log.e("error", "exception", sqlEx);
            }
        }

    }
}