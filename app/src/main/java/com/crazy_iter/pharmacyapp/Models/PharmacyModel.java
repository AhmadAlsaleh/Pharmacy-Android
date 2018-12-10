package com.crazy_iter.pharmacyapp.Models;

import com.google.android.gms.maps.model.Marker;

public class PharmacyModel {

    private String name;
    private String phone;
    private String mobile;
    private String address;
    private String username;
    private String password;
    private String openDateTime;
    private String ownerName;
    private Marker marker;

    public PharmacyModel() {
        this.name = "";
        this.phone = "";
        this.mobile = "";
        this.address = "";
        this.username = "";
        this.password = "";
        this.openDateTime = "";
        this.ownerName = "";
        this.marker = null;
    }

    public PharmacyModel(String name, String phone, String mobile, String address, String username, String password, String openDateTime, String ownerName, Marker marker) {
        this.name = name;
        this.phone = phone;
        this.mobile = mobile;
        this.address = address;
        this.username = username;
        this.password = password;
        this.openDateTime = openDateTime;
        this.ownerName = ownerName;
        this.marker = marker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(String openDateTime) {
        this.openDateTime = openDateTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
