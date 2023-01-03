package com.example.devanfriedchicken.room

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.devanfriedchicken.room.TransactionItems
import com.example.devanfriedchicken.R
import kotlinx.android.synthetic.main.transactiondialog.*
import java.text.SimpleDateFormat
import java.util.*

class TransactionItemDialog(context: Context, var dialogListener: DialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.transactiondialog)

        // Click listener on Save button
        // to save all data.
        tvSave.setOnClickListener {

            // Take all three inputs in different variables from user
            // and add it in Transaction Items database
            val name = etItemName.text.toString()
            val quantity = etItemQuantity.text.toString().toInt()
            val price = etItemPrice.text.toString().toInt()
            val total = quantity * price
            val createdAtStr = Calendar.getInstance().time.toString()
            val time = getDateMillis(createdAtStr)

            // Toast to display enter items in edit text
            if (name.isEmpty()) {
                Toast.makeText(context, "Please Enter Item Name", Toast.LENGTH_SHORT).show()
            }

            val item = TransactionItems(name, quantity, price, total, time)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }

        // On click listener on cancel text to close dialog box
        tvCancel.setOnClickListener {
            cancel()
        }
    }

    private fun getDateMillis(rawDateString: String?): Long {
        if (rawDateString == null) {
            return 0
        } else {
            try {
                val formatter = SimpleDateFormat(
                    "EEE MMM dd HH:mm:ss zzz yyyy",
                    Locale.getDefault()
                )
                val rawDate = formatter.parse(rawDateString)
                return rawDate?.time ?: 0
            } catch (e: Exception) {
                e.printStackTrace()
                return 0
            }
        }
    }
}