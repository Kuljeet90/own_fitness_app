package com.own.fitness.app.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.own.fitness.app.R;
import com.own.fitness.app.alarm.alarm_activities.AlarmMainActivity;
import com.own.fitness.app.aputils.CommonMethods;
import com.travijuu.numberpicker.library.Enums.ActionEnum;
import com.travijuu.numberpicker.library.Interface.ValueChangedListener;
import com.travijuu.numberpicker.library.NumberPicker;

import java.util.Objects;

public class ProfileFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {


    int f820a = 25;
    int b = 15;
    NumberPicker c;
    NumberPicker d;
    SharedPreferences e;
    CommonMethods f;
    Context g;
    String h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    TextView m;
    SharedPreferences mPreferences;
    TextView n;
    TextView o;
    TextView p;
    SharedPreferences.Editor prefsEditor;
    TextView q;
    TextView r;
    TextView s;
    TextView t;
    TextView u;
    int v;
    int w;
    private InterstitialAd interstitialAd;


    public void launchExerciseTimeFrag() {
        ExerciseTimeFragment exerciseTimeFragment = new ExerciseTimeFragment();
        FragmentTransaction beginTransaction = ((FragmentActivity) Objects.requireNonNull(getActivity())).getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.lang_frag, exerciseTimeFragment, (String) null);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }


    public void shareApp() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getContext().getPackageName());
        intent.setType("text/plain");
        startActivity(intent);
    }


    public void launchLanguageFrag() {
        LanguageFragmentNew languageFragmentNew = new LanguageFragmentNew();
        FragmentTransaction beginTransaction = ((FragmentActivity) Objects.requireNonNull(getActivity())).getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.lang_frag, languageFragmentNew, (String) null);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        if (compoundButton.getId() == R.id.sound_switch) {
            edit.putInt("sound", !z ? 0 : 1);
        }
        edit.apply();
    }


    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }


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
        this.g = getActivity();
        this.f = new CommonMethods(this.g);
        this.mPreferences = this.g.getSharedPreferences(getResources().getString(R.string.timer_fref_file_name), 0);
        this.e = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        this.h = this.e.getString("languageToLoad", "en");
        int i2 = this.mPreferences.getInt("sound", 1);
        this.f.updateLocale(this.h);
        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        showFullAd();
        SwitchCompat switchCompat = (SwitchCompat) inflate.findViewById(R.id.sound_switch);
        switchCompat.setOnCheckedChangeListener(this);
        if (i2 == 1) {
            switchCompat.setChecked(true);
        } else {
            switchCompat.setChecked(false);
        }
        this.f820a = this.mPreferences.getInt(getResources().getString(R.string.rest_time_key), 15);
        this.b = this.mPreferences.getInt(getResources().getString(R.string.counter_time_key), 10);
        this.d = (NumberPicker) inflate.findViewById(R.id.restTimeNumberPicker);
        this.d.setMax(60);
        this.d.setMin(10);
        this.d.setUnit(1);
        this.d.setValue(this.f820a);
        this.d.setValueChangedListener(new ValueChangedListener() {
            public void valueChanged(int i, ActionEnum actionEnum) {
                SharedPreferences.Editor edit = ProfileFragment.this.mPreferences.edit();
                edit.putInt(ProfileFragment.this.getResources().getString(R.string.rest_time_key), i);
                edit.apply();
            }
        });
        this.c = (NumberPicker) inflate.findViewById(R.id.countdownNumberPicker);
        this.c.setMax(35);
        this.c.setMin(5);
        this.c.setUnit(1);
        this.c.setValue(this.b);
        this.c.setValueChangedListener(new ValueChangedListener() {
            public void valueChanged(int i, ActionEnum actionEnum) {
                SharedPreferences.Editor edit = ProfileFragment.this.mPreferences.edit();
                edit.putInt(ProfileFragment.this.getResources().getString(R.string.counter_time_key), i);
                edit.apply();
            }
        });


        inflate.findViewById(R.id.rlRateUs).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    ProfileFragment.this.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + ((FragmentActivity) Objects.requireNonNull(ProfileFragment.this.getActivity())).getPackageName())));
                } catch (ActivityNotFoundException unused) {
                    FragmentActivity activity = ProfileFragment.this.getActivity();
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + ((FragmentActivity) Objects.requireNonNull(ProfileFragment.this.getActivity())).getPackageName())));
                }
            }
        });
        inflate.findViewById(R.id.rlShareApp).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileFragment.this.shareApp();
            }
        });


        inflate.findViewById(R.id.privacyapp).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Uri uri = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        inflate.findViewById(R.id.rlLanguage).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileFragment.this.launchLanguageFrag();
            }
        });


        inflate.findViewById(R.id.rLExerciseTime).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileFragment.this.launchExerciseTimeFrag();
            }
        });

        inflate.findViewById(R.id.rLExerciseTime_advance).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AlarmMainActivity.class);
                startActivity(intent);


            }
        });
        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("callback", "onResume: " + this.f820a + ":" + this.b);
        this.f820a = this.mPreferences.getInt(getResources().getString(R.string.rest_time_key), 25);
        this.b = this.mPreferences.getInt(getResources().getString(R.string.counter_time_key), 15);
        this.d.setValue(this.f820a);
        this.c.setValue(this.b);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("callback", "onStart: " + this.f820a + ":" + this.b);
        this.d.setValue(this.f820a);
        this.c.setValue(this.b);
    }


}
