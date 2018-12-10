package com.crazy_iter.pharmacyapp.PublicMethods;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class StaticMethods {

    public static void goToLocation(Context context, Double lat, Double lng) {
        String uri = "http://maps.google.com/maps?q=loc:" + lat.toString()
                + "," + lng.toString();
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
    }

    public static void makeCall(Context context, String phone) {
        context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone)));
    }

}
