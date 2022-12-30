package com.example.devanfriedchicken

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devanfriedchicken.databinding.ActivityMainBinding
import com.example.devanfriedchicken.room.*
import kotlinx.android.synthetic.main.fragment_test.*
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var ViewModel: TransactionViewModel
    lateinit var list: List<TransactionItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


        //Room?
        val transactionRepository = TransactionRepository(TransactionDatabase(this))
        val factory = TransactionViewModelFactory(transactionRepository)


        //TODO: Recycler View & Floating should be on test
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}