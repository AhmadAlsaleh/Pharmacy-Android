package com.crazy_iter.pharmacyapp.ProfileFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crazy_iter.pharmacyapp.Models.RateModel

import com.crazy_iter.pharmacyapp.R

class RatesFragment : Fragment() {

    private lateinit var rateRV: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rates, container, false)

        rateRV = view.findViewById(R.id.rateRV)
        val rates = ArrayList<RateModel>()
        for (i in 0 .. 5) {
            rates.add(RateModel("", "", "${i+1}-12-2018", i))
        }
        rateRV.setHasFixedSize(true)
        rateRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rateRV.adapter = RatesAdapter(context!!, rates)

        return view
    }


}
