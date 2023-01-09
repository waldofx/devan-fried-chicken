package com.example.devanfriedchicken.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devanfriedchicken.R
import kotlinx.android.synthetic.main.transactiondetailadapter.view.*
import java.text.SimpleDateFormat

class TransactionDetailAdapter(var list: List<TransactionItems>, val viewModel: TransactionViewModel):
    RecyclerView.Adapter<TransactionDetailAdapter.TransactionViewHolder>() {

    // In this function we will add our transactiondetailadapter.xml to kotlin class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transactiondetailadapter, parent, false)
        return TransactionViewHolder(view)
    }

    // This function is used to return total number of size of list.
    override fun getItemCount(): Int {
        return list.size
    }

    // In onBindViewHolder we will bind our itemViews with adapter
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        var currentPosition = list[position]
        holder.itemView.txtItemName.text = "${currentPosition.itemName},"
        holder.itemView.txtItemPrice.text = "RP. ${currentPosition.itemPrice}"
        holder.itemView.txtItemQuantity.text = "${currentPosition.itemQuantity}"
        holder.itemView.txtItemTotalCost.text = "TOTAL TRANSAKSI: Rp. ${currentPosition.itemPriceTotal}"

        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm")
        val createdAt= simpleDateFormat.format(currentPosition.createdAt)
        holder.itemView.txtItemDate.text = "TANGGAL TRANSAKSI: $createdAt"
    }

    // Inner class for viewHolder
    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}