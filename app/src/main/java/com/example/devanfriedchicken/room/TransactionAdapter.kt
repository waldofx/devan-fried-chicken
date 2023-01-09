package com.example.devanfriedchicken.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devanfriedchicken.room.TransactionItems
import com.example.devanfriedchicken.R
import com.example.devanfriedchicken.room.TransactionViewModel
import kotlinx.android.synthetic.main.transactionadapter.view.*
import java.text.SimpleDateFormat

class TransactionAdapter(
    var list: List<TransactionItems>,
    val viewModel: TransactionViewModel,
    private val listener: OnItemClickListener
) :
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
//        holder.itemView.txtItemName.text = "${currentPosition.itemName},"
//        holder.itemView.txtItemPrice.text = "RP. ${currentPosition.itemPrice}"
//        holder.itemView.txtItemQuantity.text = "${currentPosition.itemQuantity}"
        holder.itemView.txtItemTotalCost.text = "TOTAL TRANSAKSI: Rp. ${currentPosition.itemPriceTotal}"

        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm")
        val createdAt= simpleDateFormat.format(currentPosition.createdAt)
        holder.itemView.txtItemDate.text = "TANGGAL TRANSAKSI: $createdAt"
    }

    // Inner class for viewHolder
    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val textView1: TextView = itemView.txtItemDate
        val textView2: TextView = itemView.txtItemTotalCost

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            var currentPosition = list[position]
            val createdAt = currentPosition.createdAt
            val total = currentPosition.itemPriceTotal
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, createdAt, total)
            }
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int, createdAt: Long?, total: Int)
    }
}