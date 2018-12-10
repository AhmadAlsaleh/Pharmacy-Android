package com.crazy_iter.pharmacyapp.PublicMethods;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.crazy_iter.pharmacyapp.R;

public class AnimationsStaticClass {

    public static Animation fadeIn(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.fade_in);
    }

    public static Animation fadeOut(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.fade_out);
    }

    public static Animation slideUp(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.slide_up);
    }

    public static Animation slideDown(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.slide_down);
    }

}
