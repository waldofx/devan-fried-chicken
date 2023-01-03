package com.example.devanfriedchicken.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devanfriedchicken.room.TransactionItems
import com.example.devanfriedchicken.R
import com.example.devanfriedchicken.room.TransactionViewModel
import kotlinx.android.synthetic.main.transactionadapter.view.*

class TransactionAdapter(var list: List<TransactionItems>, val viewModel: TransactionViewModel) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    // In this function we will add our transactionadapter.xml to kotlin class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transactionadapter, parent, false)
        return TransactionViewHolder(view)
    }

    // This function is used to return total number of size of list.
    override fun getItemCount(): Int {
        return list.size
    }

    // In onBindViewHolder we will bind our itemViews with adapter
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        var currentPosition = list[position]
        holder.itemView.txtItemName.text = currentPosition.itemName
        holder.itemView.txtItemPrice.text = "RP. ${currentPosition.itemPrice}"
        holder.itemView.txtItemQuantity.text = "${currentPosition.itemQuantity}"
        holder.itemView.txtItemTotalCost.text = "Rp. ${currentPosition.itemPriceTotal}"

        holder.itemView.ibDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }

//        // To get total cost
//        if (position == list.size - 1) {
//            var totalCost = 0
//            for (i in 0 until list.size) {
//                totalCost += list[i].itemPrice
//            }
//            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
//            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
//            holder.itemView.txtItemTotalCost.text = "Rp. $totalCost"
//        }
    }
    // Inner class for viewHolder
    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}