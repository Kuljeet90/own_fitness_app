package com.own.fitness.app.all_about_men.database.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.AdSize;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.appbar.AppBarLayout;
import com.own.fitness.app.R;

import com.own.fitness.app.adapters.WorkoutData;
import com.own.fitness.app.all_about_men.database.DatabaseOperations1;
import com.own.fitness.app.all_about_men.database.adapter.IndividualDayAdapter1;
import com.own.fitness.app.aputils.CommonMethods;


import com.thekhaeng.pushdownanim.PushDownAnim;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class DayActivity1 extends AppCompatActivity {
    AdRequest adRequest;
    String day;

    String excercisetype;
    HashMap<String, Integer> hashMapExcAnimResIds;
    HashMap<String, Integer> hashMapExcDescription;
    HashMap<String, Integer> hashMapExcTypes;
    Intent intentMainExcerciseActivity;
    InterstitialAd interstitial;
    TextView l;
    Toolbar m;
    Context n;
    TextView o;
    IndividualDayAdapter1 p;
    float progress;
    RecyclerView q;
    LinearLayoutManager r;
    DatabaseOperations1 s;
    ArrayList<WorkoutData> workoutDataList;

    private View.OnClickListener getClickListener() {
        return new h(this);
    }


    public void requestNewInterstitial() {
        this.interstitial.loadAd(this.adRequest);
    }

    private void setAdmodAds() {
        this.interstitial = new InterstitialAd(this);
        this.interstitial.setAdUnitId(getString(R.string.AdMob_Full_ID));
        this.adRequest = new AdRequest.Builder().build();
        this.interstitial.setAdListener(new AdListener() {


            @Override
            public void onAdClosed() {
                super.onAdClosed();
                DayActivity1 dayActivity = DayActivity1.this;
                dayActivity.startActivity(dayActivity.intentMainExcerciseActivity);
                DayActivity1.this.requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }

    public void a(View view) {
        if (view == this.o) {
            new Handler().postDelayed(() -> {
                DayActivity1 dayActivity = DayActivity1.this;
                dayActivity.intentMainExcerciseActivity = new Intent(dayActivity, MainExcerciseActivityNew1.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("workoutDataList", DayActivity1.this.workoutDataList);
                DayActivity1.this.intentMainExcerciseActivity.putExtras(bundle);
                DayActivity1.this.intentMainExcerciseActivity.putExtra("excercise_type", DayActivity1.this.excercisetype);
                DayActivity1.this.intentMainExcerciseActivity.putExtra("progress", DayActivity1.this.progress);
                if (DayActivity1.this.interstitial.isLoaded()) {
                    DayActivity1.this.interstitial.show();
                    return;
                }
                DayActivity1 dayActivity2 = DayActivity1.this;
                dayActivity2.startActivity(dayActivity2.intentMainExcerciseActivity);
            }, 10);
        }
    }


    public void n() {
        this.hashMapExcAnimResIds = new HashMap<>();
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest), Integer.valueOf(R.array.atomic));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest1), Integer.valueOf(R.array.clap));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest2), Integer.valueOf(R.array.elevated_hands));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest3), Integer.valueOf(R.array.eccentric));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest4), Integer.valueOf(R.array.feet_elivated));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest5), Integer.valueOf(R.array.narrow_grip));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest6), Integer.valueOf(R.array.pike));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest7), Integer.valueOf(R.array.single_arm_left));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest8), Integer.valueOf(R.array.single_arm_right));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest9), Integer.valueOf(R.array.single_leg_left));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest10), Integer.valueOf(R.array.single_leg_right));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest11), Integer.valueOf(R.array.spiderman));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest12), Integer.valueOf(R.array.standard_grip));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest13), Integer.valueOf(R.array.wide_grip));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.chest14), Integer.valueOf(R.array.with_jump));
    }

    public void f() {
        this.hashMapExcDescription = new HashMap<>();
        this.hashMapExcDescription.put(getResources().getString(R.string.chest), Integer.valueOf(R.string.atomic_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest1), Integer.valueOf(R.string.clap_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest2), Integer.valueOf(R.string.elevated_hands_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest3), Integer.valueOf(R.string.eccentric_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest4), Integer.valueOf(R.string.feet_elevated_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest5), Integer.valueOf(R.string.narrow_grip_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest6), Integer.valueOf(R.string.pike_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest7), Integer.valueOf(R.string.single_arm_left_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest8), Integer.valueOf(R.string.single_arm_right_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest9), Integer.valueOf(R.string.single_leg_left_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest10), Integer.valueOf(R.string.single_leg_right_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest11), Integer.valueOf(R.string.spiderman_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest12), Integer.valueOf(R.string.standard_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest13), Integer.valueOf(R.string.wide_grip_desc));
        this.hashMapExcDescription.put(getResources().getString(R.string.chest14), Integer.valueOf(R.string.with_jump_desc));
    }

    public void p() {
        this.hashMapExcAnimResIds = new HashMap<>();
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose), Integer.valueOf(R.array.vertical_leg_crunches));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose1), Integer.valueOf(R.array.v_crunches));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose2), Integer.valueOf(R.array.lunge));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose3), Integer.valueOf(R.array.squats1));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose4), Integer.valueOf(R.array.pushups1));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose5), Integer.valueOf(R.array.leg_up_crunches));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose6), Integer.valueOf(R.array.jumping_jacks));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose7), Integer.valueOf(R.array.plank_with_leg_lift));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose8), Integer.valueOf(R.array.high_knees));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose9), Integer.valueOf(R.array.basic_crunches));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose10), Integer.valueOf(R.array.alternater_heeltouch));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose11), Integer.valueOf(R.array.bicycle_crunches1));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose12), Integer.valueOf(R.array.flutter_kicks1));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose13), Integer.valueOf(R.array.arm_crunches));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose14), Integer.valueOf(R.array.bench_dips));
        this.hashMapExcAnimResIds.put(getResources().getString(R.string.lose15), Integer.valueOf(R.array.leg_raise));

    }

    public void h() {
        this.hashMapExcDescription = new HashMap<>();
        this.hashMapExcDescription.put(getResources().getString(R.string.lose), Integer.valueOf(R.string.desc_vertical_leg_crunches));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose1), Integer.valueOf(R.string.desc_v_crunches));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose2), Integer.valueOf(R.string.desc_lunge));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose3), Integer.valueOf(R.string.desc_squats));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose4), Integer.valueOf(R.string.desc_pushups));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose5), Integer.valueOf(R.string.desc_leg_up_crunches));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose6), Integer.valueOf(R.string.desc_jumping_jacks));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose7), Integer.valueOf(R.string.desc_plank_with_leg_lift));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose8), Integer.valueOf(R.string.desc_high_knees));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose9), Integer.valueOf(R.string.desc_basic_crunches));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose10), Integer.valueOf(R.string.desc_alternater_heeltouch));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose11), Integer.valueOf(R.string.desc_bicycle_crunches));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose12), Integer.valueOf(R.string.desc_flutter_kicks));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose13), Integer.valueOf(R.string.desc_arm_crunches));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose14), Integer.valueOf(R.string.desc_bench_dips));
        this.hashMapExcDescription.put(getResources().getString(R.string.lose15), Integer.valueOf(R.string.desc_leg_raise));
    }

    public void i() {
        this.hashMapExcTypes = new HashMap<>();


        this.hashMapExcTypes.put("morning", Integer.valueOf(R.array.morning1));
        this.hashMapExcTypes.put("morning_cycles", Integer.valueOf(R.array.morning_cycle1));

        this.hashMapExcTypes.put("evening", Integer.valueOf(R.array.evening1));
        this.hashMapExcTypes.put("evening_cycles", Integer.valueOf(R.array.evening_cycle1));

        this.hashMapExcTypes.put("abs", Integer.valueOf(R.array.abs1));
        this.hashMapExcTypes.put("abs_cycles", Integer.valueOf(R.array.abs_cycles1));

        this.hashMapExcTypes.put("buttock", Integer.valueOf(R.array.buttock1));
        this.hashMapExcTypes.put("buttock_cycles", Integer.valueOf(R.array.buttock_cycles1));

        this.hashMapExcTypes.put("fatburn", Integer.valueOf(R.array.fatburn1));
        this.hashMapExcTypes.put("fatburn_cycles", Integer.valueOf(R.array.fatburn_cycles1));

        this.hashMapExcTypes.put("weightloss", Integer.valueOf(R.array.weightloss1));
        this.hashMapExcTypes.put("weightloss_cycles", Integer.valueOf(R.array.weightloss_cycles1));
    }
    AppBarLayout appBarLayout ;
    RelativeLayout bottom_rel;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.n = this;
        new CommonMethods(this.n).updateLocale(PreferenceManager.getDefaultSharedPreferences(this.n).getString("languageToLoad", "en"));
        setContentView((int) R.layout.day_layout_new);

        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.men_color));

        bottom_rel = (RelativeLayout) findViewById(R.id.bottom_rel);
        bottom_rel.setBackground(getResources().getDrawable(R.drawable.men_round));


        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.myad_fb);
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getString(R.string.fb_banner), AdSize.BANNER_HEIGHT_50);
        adViewContainer.addView(adView);
        adView.loadAd();


        this.q = (RecyclerView) findViewById(R.id.recyclerAllDaysList);
        this.o = (TextView) findViewById(R.id.buttonTwo);
        this.s = new DatabaseOperations1(this);
        this.r = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        setAdmodAds();
        this.m = (Toolbar) findViewById(R.id.mtoolbar);
        this.l = (TextView) this.m.findViewById(R.id.mtoolbar_title);
        this.m.setNavigationIcon((int) R.drawable.back_pink);

        this.m.setNavigationOnClickListener(v -> finish());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.excercisetype = extras.getString("excercise_type");
        }
        i();
        String str = this.excercisetype;
        if (str != null && str.equalsIgnoreCase("abs")) {
            this.l.setText(getResources().getString(R.string.abs_title));
            this.day = "Day 3";

            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs), Integer.valueOf(R.array.abs_v_crunch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs1), Integer.valueOf(R.array.abs_clapping_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs2), Integer.valueOf(R.array.abs_flutter_kicks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs3), Integer.valueOf(R.array.abs_plank));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs4), Integer.valueOf(R.array.abs_reverse_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs5), Integer.valueOf(R.array.abs_bent_leg_twist));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs6), Integer.valueOf(R.array.abs_bicycle_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs7), Integer.valueOf(R.array.abs_cross_arm_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs8), Integer.valueOf(R.array.abs_x_man_crunch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs9), Integer.valueOf(R.array.abs_dumbbell_paddle_boats));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs10), Integer.valueOf(R.array.abs_dumbbell_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs11), Integer.valueOf(R.array.abs_dumbbell_crunch_and_punches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs12), Integer.valueOf(R.array.abs_side_leg_rise_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs13), Integer.valueOf(R.array.abs_side_leg_rise_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs14), Integer.valueOf(R.array.abs_lying_twist_stretch_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs15), Integer.valueOf(R.array.abs_one_down_two_ups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs16), Integer.valueOf(R.array.abs_dumbbell_toe_touch_crunch_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs17), Integer.valueOf(R.array.abs_dumbbell_toe_touch_crunch_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs18), Integer.valueOf(R.array.abs_v_hold));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs19), Integer.valueOf(R.array.abs_dumbbell_bicycle_passes));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs20), Integer.valueOf(R.array.abs_dumbbell_torture_tucks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs21), Integer.valueOf(R.array.abs_seated_abs_counterclockwise));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs22), Integer.valueOf(R.array.abs_seated_abs_clockwise));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs23), Integer.valueOf(R.array.abs_ninty_crunch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs24), Integer.valueOf(R.array.abs_dumbbell_side_bend_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs25), Integer.valueOf(R.array.abs_dumbbell_side_bend_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs26), Integer.valueOf(R.array.abs_cross_knee_plank));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs27), Integer.valueOf(R.array.abs_oblique_v_ups_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs28), Integer.valueOf(R.array.abs_oblique_v_ups_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs29), Integer.valueOf(R.array.abs_crunches_with_legs_raised));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs30), Integer.valueOf(R.array.abs_alt_v_up));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs31), Integer.valueOf(R.array.abs_lying_twist_stretch_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs32), Integer.valueOf(R.array.abs_childs_pose));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs33), Integer.valueOf(R.array.abs_cobra_stretch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs34), Integer.valueOf(R.array.abs_side_plank_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs35), Integer.valueOf(R.array.abs_side_plank_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs36), Integer.valueOf(R.array.abs_dumbbell_russian_twist));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs37), Integer.valueOf(R.array.abs_v_up));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs38), Integer.valueOf(R.array.abs_side_crunches_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs39), Integer.valueOf(R.array.abs_side_crunches_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs40), Integer.valueOf(R.array.abs_sit_up_twist));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs41), Integer.valueOf(R.array.abs_heels_to_the_heaven));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.abs42), Integer.valueOf(R.array.abs_heel_touch));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.abs), Integer.valueOf(R.string.v_crunch_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs1), Integer.valueOf(R.string.clapping_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs2), Integer.valueOf(R.string.side_crunches_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs3), Integer.valueOf(R.string.side_crunches_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs4), Integer.valueOf(R.string.flutter_kicks_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs5), Integer.valueOf(R.string.plank_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs6), Integer.valueOf(R.string.reverse_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs7), Integer.valueOf(R.string.bent_leg_twist_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs8), Integer.valueOf(R.string.bicycle_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs9), Integer.valueOf(R.string.cross_arm_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs10), Integer.valueOf(R.string.x_man_crunch_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs11), Integer.valueOf(R.string.dumbbell_paddle_boats_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs12), Integer.valueOf(R.string.dumbbell_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs13), Integer.valueOf(R.string.dumbbell_crunch_and_punches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs14), Integer.valueOf(R.string.side_leg_rise_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs15), Integer.valueOf(R.string.side_leg_rise_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs16), Integer.valueOf(R.string.lying_twist_stretch_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs17), Integer.valueOf(R.string.one_down_two_ups_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs18), Integer.valueOf(R.string.dumbbell_toe_touch_crunch_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs19), Integer.valueOf(R.string.dumbbell_toe_touch_crunch_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs20), Integer.valueOf(R.string.v_hold_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs21), Integer.valueOf(R.string.dumbbell_bicycle_passes_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs22), Integer.valueOf(R.string.dumbbell_torture_tucks_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs23), Integer.valueOf(R.string.seated_abs_counterclockwise_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs24), Integer.valueOf(R.string.seated_abs_clockwise_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs25), Integer.valueOf(R.string.ninty_crunch_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs26), Integer.valueOf(R.string.dumbbell_side_bend_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs27), Integer.valueOf(R.string.dumbbell_side_bend_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs28), Integer.valueOf(R.string.cross_knee_plank_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs29), Integer.valueOf(R.string.oblique_v_ups_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs30), Integer.valueOf(R.string.oblique_v_ups_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs31), Integer.valueOf(R.string.crunches_with_legs_raised_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs32), Integer.valueOf(R.string.alt_v_up_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs33), Integer.valueOf(R.string.lying_twist_stretch_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs34), Integer.valueOf(R.string.childs_pose_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs35), Integer.valueOf(R.string.cobra_stretch_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs36), Integer.valueOf(R.string.side_plank_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs37), Integer.valueOf(R.string.side_plank_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs38), Integer.valueOf(R.string.sit_up_twist_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs39), Integer.valueOf(R.string.dumbbell_russian_twist_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs40), Integer.valueOf(R.string.heels_to_the_heaven_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs41), Integer.valueOf(R.string.v_up_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.abs42), Integer.valueOf(R.string.heel_touch_desc));

        } else if (this.excercisetype.equalsIgnoreCase("buttock")) {
            this.l.setText(getResources().getString(R.string.buttocks_title1));
            this.day = "Day 1";

            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm), Integer.valueOf(R.array.triceps_dips));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm1), Integer.valueOf(R.array.pushups1));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm2), Integer.valueOf(R.array.decline_pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm3), Integer.valueOf(R.array.incline_pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm4), Integer.valueOf(R.array.army_pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm5), Integer.valueOf(R.array.arm_scissors));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm6), Integer.valueOf(R.array.triceps_stretch_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm7), Integer.valueOf(R.array.triceps_stretch_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm8), Integer.valueOf(R.array.standing_biceps_stretch_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm9), Integer.valueOf(R.array.standing_biceps_stretch_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm10), Integer.valueOf(R.array.elbow_back));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm11), Integer.valueOf(R.array.arm_crunches_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm12), Integer.valueOf(R.array.arm_crunches_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm13), Integer.valueOf(R.array.wall_pushups1));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm14), Integer.valueOf(R.array.jumping_jacks1));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm15), Integer.valueOf(R.array.plank_taps));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm16), Integer.valueOf(R.array.punches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm17), Integer.valueOf(R.array.knee_pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm18), Integer.valueOf(R.array.pushup_low_hold));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm19), Integer.valueOf(R.array.wide_arm_pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm20), Integer.valueOf(R.array.diamond_pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm21), Integer.valueOf(R.array.plank1));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm22), Integer.valueOf(R.array.shoulder_gators));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm23), Integer.valueOf(R.array.skip_the_rope));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm24), Integer.valueOf(R.array.plank_alternate_reach));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.arm), Integer.valueOf(R.string.desc_triceps_dips));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm1), Integer.valueOf(R.string.desc_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm2), Integer.valueOf(R.string.desc_decline_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm3), Integer.valueOf(R.string.desc_incline_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm4), Integer.valueOf(R.string.desc_army_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm5), Integer.valueOf(R.string.desc_arm_scissors));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm6), Integer.valueOf(R.string.desc_triceps_stretch_left));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm7), Integer.valueOf(R.string.desc_triceps_stretch_right));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm8), Integer.valueOf(R.string.desc_standing_biceps_stretch_left));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm9), Integer.valueOf(R.string.desc_standing_biceps_stretch_right));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm10), Integer.valueOf(R.string.desc_elbow_back));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm11), Integer.valueOf(R.string.desc_arm_crunches_left));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm12), Integer.valueOf(R.string.desc_arm_crunches_right));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm13), Integer.valueOf(R.string.desc_wall_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm14), Integer.valueOf(R.string.desc_jumping_jacks));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm15), Integer.valueOf(R.string.desc_plank_taps));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm16), Integer.valueOf(R.string.desc_punches));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm17), Integer.valueOf(R.string.desc_knee_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm18), Integer.valueOf(R.string.desc_pushup_low_hold));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm19), Integer.valueOf(R.string.desc_wide_arm_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm20), Integer.valueOf(R.string.desc_diamond_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm21), Integer.valueOf(R.string.desc_plank));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm22), Integer.valueOf(R.string.desc_shoulder_gators));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm23), Integer.valueOf(R.string.desc_skip_the_rope));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm24), Integer.valueOf(R.string.desc_plank_alternate_reach));


        } else if (this.excercisetype.equalsIgnoreCase("morning")) {
            this.l.setText(getResources().getString(R.string.morning_title));
            this.day = "Day 5";

            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.jumping_jacks), Integer.valueOf(R.array.jumping_jacks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm_crunches), Integer.valueOf(R.array.arm_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.high_knees), Integer.valueOf(R.array.high_knees));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.basic_crunches), Integer.valueOf(R.array.basic_crunches));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.jumping_jacks), Integer.valueOf(R.string.desc_jumping_jacks));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm_crunches), Integer.valueOf(R.string.desc_arm_crunches));
            this.hashMapExcDescription.put(getResources().getString(R.string.high_knees), Integer.valueOf(R.string.desc_high_knees));
            this.hashMapExcDescription.put(getResources().getString(R.string.basic_crunches), Integer.valueOf(R.string.desc_basic_crunches));

        } else if (this.excercisetype.equalsIgnoreCase("evening")) {
            this.l.setText(getResources().getString(R.string.evening_title));
            this.day = "Day 6";
            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.jumping_jacks), Integer.valueOf(R.array.jumping_jacks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.arm_crunches), Integer.valueOf(R.array.arm_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.high_knees), Integer.valueOf(R.array.high_knees));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.basic_crunches), Integer.valueOf(R.array.basic_crunches));
            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.jumping_jacks), Integer.valueOf(R.string.desc_jumping_jacks));
            this.hashMapExcDescription.put(getResources().getString(R.string.arm_crunches), Integer.valueOf(R.string.desc_arm_crunches));
            this.hashMapExcDescription.put(getResources().getString(R.string.high_knees), Integer.valueOf(R.string.desc_high_knees));
            this.hashMapExcDescription.put(getResources().getString(R.string.basic_crunches), Integer.valueOf(R.string.desc_basic_crunches));


        } else if (this.excercisetype.equalsIgnoreCase("fatburn")) {
            this.day = "Day 4";
            this.l.setText(getResources().getString(R.string.fatburn_title1));
            n();
            f();
        } else if (this.excercisetype.equalsIgnoreCase("weightloss")) {
            this.day = "Day 2";
            this.l.setText(getResources().getString(R.string.weightloss_title));
            p();
            h();
        }
        this.workoutDataList = q();
        this.p = new IndividualDayAdapter1(this.n, this.day, this.workoutDataList, 200);
        this.q.setLayoutManager(this.r);
        this.q.setAdapter(this.p);

        this.q.setLayoutManager(this.r);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        PushDownAnim.setPushDownAnimTo((View) this.o).setScale(PushDownAnim.MODE_STATIC_DP, 4.0f).setDurationPush(50).setDurationRelease(50).setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR).setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR).setOnClickListener(getClickListener());
        this.workoutDataList = q();
        this.p = new IndividualDayAdapter1(this.n, this.day, this.workoutDataList, 200);
        this.q.setLayoutManager(this.r);
        this.q.setAdapter(this.p);
        this.p.notifyDataSetChanged();
    }


    public ArrayList<WorkoutData> q() {
        ArrayList<WorkoutData> arrayList = new ArrayList<>();
        String[] stringArray = getResources().getStringArray(this.hashMapExcTypes.get(this.excercisetype).intValue());
        Log.d("DayCheck", "Day Exercise Name");
        Resources resources = getResources();
        HashMap<String, Integer> hashMap = this.hashMapExcTypes;
        resources.getIntArray(hashMap.get(this.excercisetype + "_cycles").intValue());
        String dayExcCycles = this.s.getDayExcCycles(this.day);
        Log.e("DayCheck", "Day exc cycles DayActivity1: " + dayExcCycles);
        int[] iArr = new int[0];
        JSONObject jSONObject = null;
        if (dayExcCycles != null) {
            try {
                jSONObject = new JSONObject(dayExcCycles);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        assert jSONObject != null;
        iArr = new int[jSONObject.length()];
        for (int i = 0; i < stringArray.length; i++) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(this.hashMapExcAnimResIds.get(stringArray[i]).intValue());
            int length = obtainTypedArray.length();
            int[] iArr2 = new int[length];
            WorkoutData workoutData = new WorkoutData();
            for (int i2 = 0; i2 < length; i2++) {
                iArr2[i2] = obtainTypedArray.getResourceId(i2, -1);
            }
            workoutData.setExcName(stringArray[i]);
            workoutData.setExcDescResId(this.hashMapExcDescription.get(stringArray[i]).intValue());
            try {
                iArr[i] = jSONObject.getInt(String.valueOf(i));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            workoutData.setExcCycles(iArr[i]);
            workoutData.setPosition(i);
            workoutData.setImageIdList(iArr2);
            arrayList.add(workoutData);
        }
        return arrayList;
    }
}
