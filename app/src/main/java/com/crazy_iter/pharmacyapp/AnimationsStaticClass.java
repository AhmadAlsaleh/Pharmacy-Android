package com.crazy_iter.pharmacyapp;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationsStaticClass {

    public static Animation fadeIn(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.fade_in);
    }

    public static Animation fadeOut(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.fade_out);
    }

}
