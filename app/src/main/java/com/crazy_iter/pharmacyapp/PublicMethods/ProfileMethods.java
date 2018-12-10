package com.crazy_iter.pharmacyapp.PublicMethods;

import android.content.Context;
import android.content.SharedPreferences;

public class ProfileMethods implements StaticVars {

    public static boolean isLoggedIn(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return preferences.getString("_id", "").length() != 0;
    }

    public static String getProfileID(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return preferences.getString("_id", "");
    }

}
