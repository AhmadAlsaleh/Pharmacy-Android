package com.crazy_iter.pharmacyapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.crazy_iter.pharmacyapp.Models.PharmacyModel
import com.crazy_iter.pharmacyapp.PublicMethods.AnimationsStaticClass
import com.crazy_iter.pharmacyapp.PublicMethods.ProfileMethods
import com.crazy_iter.pharmacyapp.PublicMethods.StaticMethods
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
    private var pharmacies = ArrayList<PharmacyModel>()
    private lateinit var selectedPharmacy: PharmacyModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_maps)

        setSupportActionBar(mainTB)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        animationLogo()
        ratingBarListener()

        mainSettingIV.setOnClickListener(this)
        mainLayerIV.setOnClickListener(this)
        mainProfileIV.setOnClickListener(this)
        pharmacyPreviewLocationLL.setOnClickListener(this)
        pharmacyPreviewCallLL.setOnClickListener(this)
        pharmacyPreviewEmailLL.setOnClickListener(this)

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
                if (ProfileMethods.isLoggedIn(this) || true) {
                    startActivity(Intent(this, ProfileActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginRegisterActivity::class.java))
                }
            }
            R.id.pharmacyPreviewCallLL -> StaticMethods.makeCall(this, selectedPharmacy.mobile)
            R.id.pharmacyPreviewLocationLL ->
                StaticMethods.goToLocation(this,
                        selectedPharmacy.marker.position.latitude,
                        selectedPharmacy.marker.position.longitude)
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

    @SuppressLint("ResourceAsColor")
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

        mMap.setOnMarkerClickListener {
            pharmacyPreviewDataLL.startAnimation(AnimationsStaticClass.slideUp(this))
            Handler().postDelayed({
                pharmacyPreviewDataLL.visibility = View.VISIBLE
                pharmacyPreviewLL.setBackgroundResource(R.color.hideBlack)
                pharmacyPreviewLL.isClickable = true
                pharmacyPreviewLL.isFocusable = true

                for (pharmacy in pharmacies) {
                    if (pharmacy.marker.position.latitude == it.position.latitude
                        && pharmacy.marker.position.longitude == it.position.longitude) {
                        selectedPharmacy = pharmacy
                    }
                }

            }, 750)
            true
        }

    }

    @SuppressLint("ResourceAsColor")
    override fun onBackPressed() {
        if (pharmacyPreviewDataLL.visibility == View.VISIBLE) {
            pharmacyPreviewDataLL.startAnimation(AnimationsStaticClass.slideDown(this))
            Handler().postDelayed({
                pharmacyPreviewDataLL.visibility = View.GONE
                pharmacyPreviewLL.setBackgroundColor(android.R.color.transparent)
                pharmacyPreviewLL.isClickable = false
                pharmacyPreviewLL.isFocusable = false

            }, 750)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.itemAll -> {}
            R.id.itemOpened -> {}
            R.id.itemWeekend -> {}
            R.id.itemNearby -> {}
        }
        return super.onOptionsItemSelected(item)
    }

}
