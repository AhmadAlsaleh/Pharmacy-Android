package com.crazy_iter.pharmacyapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.crazy_iter.pharmacyapp.ProfileFragments.OrdersFragment
import com.crazy_iter.pharmacyapp.ProfileFragments.ProfileViewPagerAdapter
import com.crazy_iter.pharmacyapp.ProfileFragments.RatesFragment
import com.crazy_iter.pharmacyapp.R.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_profile)

        setSupportActionBar(profileTB)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewPager()

    }

    private fun setupViewPager() {
        val adapter = ProfileViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OrdersFragment(), "Orders")
        adapter.addFragment(RatesFragment(), "Rates")
        profileVP.adapter = adapter
        profileTL.setupWithViewPager(profileVP)
    }

}
