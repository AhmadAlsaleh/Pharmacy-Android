package com.crazy_iter.pharmacyapp.ProfileFragments

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.crazy_iter.pharmacyapp.Models.RateModel
import com.crazy_iter.pharmacyapp.R

class RatesAdapter(val context: Context, private val rates: ArrayList<RateModel>)
    : RecyclerView.Adapter<RatesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            ViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_rate_pharmacy, p0, false))

    override fun getItemCount() = rates.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = rates[position]

        holder.rateDateTV.text = item.date
        holder.rateRB.rating = item.rateNum.toFloat()

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rateLL = itemView.findViewById<LinearLayout>(R.id.rateLL)
        val rateIV = itemView.findViewById<ImageView>(R.id.rateIV)
        val rateDateTV = itemView.findViewById<TextView>(R.id.rateDateTV)
        val rateRemoveIV = itemView.findViewById<ImageView>(R.id.rateRemoveIV)
        val rateRB = itemView.findViewById<RatingBar>(R.id.rateRB)
    }

}