package com.crazy_iter.pharmacyapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main_maps.*

class MainMapsActivity : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_maps)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        animationLogo()
        ratingBarListener()

        mainSettingIV.setOnClickListener(this)
        mainLayerIV.setOnClickListener(this)
        mainProfileIV.setOnClickListener(this)

    }

    private fun ratingBarListener() {
        mainRB.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mainSettingIV -> {}
            R.id.mainLayerIV -> {
                if (mMap.mapType == GoogleMap.MAP_TYPE_NORMAL) {
                    mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                } else {
                    mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                }
            }
            R.id.mainProfileIV -> {
                startActivity(Intent(this, LoginRegisterActivity::class.java))
            }
        }
    }


    private fun animationLogo() {
        Handler().postDelayed({
            try {
                mainLogoRL.startAnimation(AnimationsStaticClass.fadeOut(this))
            } catch (err: Exception) {}
            Handler().postDelayed({
                try {
                    mainLogoRL.visibility = View.GONE
                } catch (err: Exception) {}
            }, 1500)
        }, 2500)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        val latlng = LatLng(35.515565, 35.774404)
        mMap.addMarker(MarkerOptions()
                .position(latlng)
                .title("")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.mipmap.ic_launcher_round)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 18F))
    }
}
