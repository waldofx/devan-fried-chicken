package com.example.devanfriedchicken

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.devanfriedchicken.R
import com.example.devanfriedchicken.room.*
import kotlinx.android.synthetic.main.fragment_test.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Test.newInstance] factory method to
 * create an instance of this fragment.
 */
class Test : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var ViewModel: TransactionViewModel
    lateinit var list: List<TransactionItems>

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
////        setContentView(R.layout.fragment_test)
//
//        val transactionRepository = TransactionRepository(TransactionDatabase(this))
//        val factory = TransactionViewModelFactory(transactionRepository)
//
//        // Initialised View Model
//        ViewModel = ViewModelProvider(this, factory).get(TransactionViewModel::class.java)
//        val transactionAdapter = TransactionAdapter(listOf(), ViewModel)
//        rvList.layoutManager = LinearLayoutManager(this)
//        rvList.adapter = transactionAdapter
//
//        // To display all items in recycler view
//        ViewModel.allTransactionItems().observe(this, Observer {
//            transactionAdapter.list = it
//            transactionAdapter.notifyDataSetChanged()
//        })
//
//        // on ClickListener on button to open dialog box
//        btnAdd.setOnClickListener {
//            TransactionItemDialog(this, object : DialogListener {
//                override fun onAddButtonClicked(item: TransactionItems) {
//                    ViewModel.insert(item)
//                }
//            }).show()
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Test.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Test().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}