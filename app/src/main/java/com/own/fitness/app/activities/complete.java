package com.own.fitness.app.activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.own.fitness.app.R;
import com.own.fitness.app.allads.AdmobAds;
import com.own.fitness.app.aputils.CommonMethods;


public class complete extends AppCompatActivity {

    Context context;
    SharedPreferences r;
    String s;
    CommonMethods t;


    @Override
    public void onCreate(@Nullable Bundle bundle) {
        StringBuilder sb = null;
        String str;
        String str2;
        StringBuilder sb2;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.context = this;
        this.r = PreferenceManager.getDefaultSharedPreferences(this.context);
        this.s = this.r.getString("languageToLoad", "en");
        this.t = new CommonMethods(this.context);
        this.t.updateLocale(this.s);
        setContentView((int) R.layout.exc_completion_layout_new);
        int intExtra = getIntent().getIntExtra("totalExc", 0);
        int intExtra2 = getIntent().getIntExtra("totalTime", 0);


        ImageView imageView = (ImageView) findViewById(R.id.shareimage_Congrats);
        TextView textView = (TextView) findViewById(R.id.congrts_duration);
        TextView textView2 = (TextView) findViewById(R.id.congrts_ExNo);


        int i = intExtra2 / 60;
        int i2 = intExtra2 % 60;
        if (i < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i);
        String sb3 = sb.toString();
        if (i2 < 10) {
            sb2 = new StringBuilder();
            str2 = ":0";
        } else {
            sb2 = new StringBuilder();
            str2 = ":";
        }
        sb2.append(str2);
        sb2.append(i2);
        textView.setText(sb3.concat(sb2.toString()));
        textView2.setText(String.valueOf(intExtra));

        imageView.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getPackageName());
            intent.setType("text/plain");
            startActivity(intent);
        });

        findViewById(R.id.closeimage_Congrats).setOnClickListener(v -> finish());

        new AdmobAds(this.context, (LinearLayout) findViewById(R.id.nativeAdContainer))
                .refreshAd(getString(R.string.AdMob_Native_ID));


    }

    @Override
    public void onBackPressed() {

        finish();
    }
}
