package com.own.fitness.app.all_about_men.database.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.own.fitness.app.R;

import com.own.fitness.app.all_about_men.database.activity.DayActivity1;
import com.own.fitness.app.aputils.CommonMethods;

public class RoutinesFragment1 extends Fragment {


     SharedPreferences f829a;
     String b;
     CommonMethods c;
     Context d;
    private InterstitialAd interstitialAd;






    private void showFullAd() {
        interstitialAd = new InterstitialAd(getContext(),getString(R.string.fb_full));

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {


            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };


        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = getActivity();
        this.c = new CommonMethods(this.d);
        this.f829a = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.b = this.f829a.getString("languageToLoad", "en");
        this.c.updateLocale(this.b);
        View inflate = layoutInflater.inflate(R.layout.fragment_routine1, viewGroup, false);



        showFullAd();

        inflate.findViewById(R.id.morning_workout).setOnClickListener(view -> {
            Intent intent = new Intent(RoutinesFragment1.this.getActivity(), DayActivity1.class);
            intent.putExtra("excercise_type", "morning");
            RoutinesFragment1.this.startActivity(intent);
        });
        inflate.findViewById(R.id.evening_workout).setOnClickListener(view -> {
            Intent intent = new Intent(RoutinesFragment1.this.getActivity(), DayActivity1.class);
            intent.putExtra("excercise_type", "evening");
            RoutinesFragment1.this.startActivity(intent);
        });
        return inflate;
    }
}
