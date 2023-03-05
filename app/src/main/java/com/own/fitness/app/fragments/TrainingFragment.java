package com.own.fitness.app.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.MobileAds;
import com.own.fitness.app.R;
import com.own.fitness.app.activities.DayActivity;
import com.own.fitness.app.aputils.CommonMethods;
import com.own.fitness.app.sortnameclass.c.g;
import com.own.fitness.app.sortnameclass.c.h;
import com.own.fitness.app.sortnameclass.c.i;
import com.own.fitness.app.sortnameclass.c.j;
import com.own.fitness.app.sortnameclass.c.k;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class TrainingFragment extends Fragment {


    SharedPreferences f836a;
    String b;
    ImageView c;
    CommonMethods commonMethods;
    ImageView d;
    ImageView e;
    String exctype;
    ImageView f;


    private View.OnClickListener getClickListener() {
        return new g(this);
    }


    public void a() {
        this.exctype = "abs";
        Intent intent = new Intent(getActivity(), DayActivity.class);
        intent.putExtra("excercise_type", "abs");
        startActivity(intent);
    }

    public void a(View view) {
        Handler handler;
        Runnable jVar;
        if (view == this.c) {
            handler = new Handler();
            jVar = new k(this);
        } else if (view == this.d) {
            handler = new Handler();
            jVar = new i(this);
        } else if (view == this.e) {
            handler = new Handler();
            jVar = new h(this);
        } else if (view == this.f) {
            handler = new Handler();
            jVar = new j(this);
        } else {
            return;
        }
        handler.postDelayed(jVar, 20);
    }

    public void b() {
        this.exctype = "buttock";
        Intent intent = new Intent(getActivity(), DayActivity.class);
        intent.putExtra("excercise_type", "buttock");
        startActivity(intent);
    }

    public void c() {
        this.exctype = "weightloss";
        Intent intent = new Intent(getActivity(), DayActivity.class);
        intent.putExtra("excercise_type", "weightloss");
        startActivity(intent);
    }

    public void d() {
        this.exctype = "fatburn";
        Intent intent = new Intent(getActivity(), DayActivity.class);
        intent.putExtra("excercise_type", "fatburn");
        startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        MobileAds.initialize((Context) getActivity(), getString(R.string.ADMOB_Unit_ID));


    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.commonMethods = new CommonMethods(getActivity());
        this.f836a = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.b = this.f836a.getString("languageToLoad", "en");
        this.commonMethods.updateLocale(this.b);
        View inflate = layoutInflater.inflate(R.layout.fragment_workout, viewGroup, false);
        this.c = (ImageView) inflate.findViewById(R.id.abs_workout);
        this.d = (ImageView) inflate.findViewById(R.id.butt_workout);
        this.e = (ImageView) inflate.findViewById(R.id.weightloss);
        this.f = (ImageView) inflate.findViewById(R.id.fatburn_workout);


        return inflate;
    }

    @Override
    public void onResume() {

        PushDownAnim.setPushDownAnimTo(this.c, this.f, this.d, this.e)
                .setScale(PushDownAnim.MODE_STATIC_DP, 4.0f).setDurationPush(50)
                .setDurationRelease(50).setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR).setOnClickListener(getClickListener());
        super.onResume();
    }
}
