package com.own.fitness.app.activities;

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
import com.own.fitness.app.sortnameclass.a.g;
import com.own.fitness.app.sortnameclass.a.h;
import com.own.fitness.app.adapters.IndividualDayAdapter;
import com.own.fitness.app.adapters.WorkoutData;
import com.own.fitness.app.database.DatabaseOperations;
import com.own.fitness.app.aputils.CommonMethods;
import com.thekhaeng.pushdownanim.PushDownAnim;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DayActivity extends AppCompatActivity {
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
    IndividualDayAdapter p;
    float progress;
    RecyclerView q;
    LinearLayoutManager r;
    DatabaseOperations s;
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
                DayActivity dayActivity = DayActivity.this;
                dayActivity.startActivity(dayActivity.intentMainExcerciseActivity);
                DayActivity.this.requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }

    public void a(View view) {
        if (view == this.o) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    DayActivity dayActivity = DayActivity.this;
                    dayActivity.intentMainExcerciseActivity = new Intent(dayActivity, MainExcerciseActivityNew.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("workoutDataList", DayActivity.this.workoutDataList);
                    DayActivity.this.intentMainExcerciseActivity.putExtras(bundle);
                    DayActivity.this.intentMainExcerciseActivity.putExtra("excercise_type", DayActivity.this.excercisetype);
                    DayActivity.this.intentMainExcerciseActivity.putExtra("progress", DayActivity.this.progress);
                    if (DayActivity.this.interstitial.isLoaded()) {
                        DayActivity.this.interstitial.show();
                        return;
                    }
                    DayActivity dayActivity2 = DayActivity.this;
                    dayActivity2.startActivity(dayActivity2.intentMainExcerciseActivity);
                }
            }, 10);
        }
    }


    public void b() {
        finish();
    }


    public void i() {
        this.hashMapExcTypes = new HashMap<>();
        this.hashMapExcTypes.put("abs", Integer.valueOf(R.array.abs));
        this.hashMapExcTypes.put("abs_cycles", Integer.valueOf(R.array.abs_cycles));
        this.hashMapExcTypes.put("buttock", Integer.valueOf(R.array.buttock));
        this.hashMapExcTypes.put("buttock_cycles", Integer.valueOf(R.array.buttock_cycles));
        this.hashMapExcTypes.put("morning", Integer.valueOf(R.array.morning));
        this.hashMapExcTypes.put("morning_cycles", Integer.valueOf(R.array.morning_cycle));
        this.hashMapExcTypes.put("evening", Integer.valueOf(R.array.evening));
        this.hashMapExcTypes.put("evening_cycles", Integer.valueOf(R.array.evening_cycle));
        this.hashMapExcTypes.put("fatburn", Integer.valueOf(R.array.fatburn));
        this.hashMapExcTypes.put("fatburn_cycles", Integer.valueOf(R.array.fatburn_cycles));
        this.hashMapExcTypes.put("weightloss", Integer.valueOf(R.array.weightloss));
        this.hashMapExcTypes.put("weightloss_cycles", Integer.valueOf(R.array.weightloss_cycles));
    }


    AppBarLayout appBarLayout;
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
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.women_color));

        bottom_rel = (RelativeLayout) findViewById(R.id.bottom_rel);
        bottom_rel.setBackground(getResources().getDrawable(R.drawable.women_round));

        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.myad_fb);
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getString(R.string.fb_banner), AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();


        this.q = (RecyclerView) findViewById(R.id.recyclerAllDaysList);
        this.o = (TextView) findViewById(R.id.buttonTwo);
        this.s = new DatabaseOperations(this);
        this.r = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        setAdmodAds();
        this.m = (Toolbar) findViewById(R.id.mtoolbar);
        this.l = (TextView) this.m.findViewById(R.id.mtoolbar_title);
        this.m.setNavigationIcon((int) R.drawable.back_pink);
        this.m.setNavigationOnClickListener(new g(this));
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
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.trunk_rotation), Integer.valueOf(R.array.trunk_rotation));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.mountain_climber), Integer.valueOf(R.array.mountain_climber));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.clapping_crunches), Integer.valueOf(R.array.clapping_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.swimming_and_superman), Integer.valueOf(R.array.swimming_and_superman));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.butt_bridge), Integer.valueOf(R.array.butt_bridge));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.flutter_kicks), Integer.valueOf(R.array.flutter_kicks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.plank), Integer.valueOf(R.array.plank));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.reverse_crunches), Integer.valueOf(R.array.reverse_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.bent_leg_twist), Integer.valueOf(R.array.bent_leg_twist));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.bicycle_crunches), Integer.valueOf(R.array.bicycle_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.russian_twist), Integer.valueOf(R.array.russian_twist));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.reclined_oblique_twist), Integer.valueOf(R.array.reclined_oblique_twist));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.cross_arm_crunches), Integer.valueOf(R.array.cross_arm_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.standing_bicycle), Integer.valueOf(R.array.standing_bicycle));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.leg_drops), Integer.valueOf(R.array.leg_drops));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.side_leg_rise_left), Integer.valueOf(R.array.side_leg_rise_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.side_leg_rise_right), Integer.valueOf(R.array.side_leg_rise_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.long_arm_crunches), Integer.valueOf(R.array.long_arm_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.dead_bug), Integer.valueOf(R.array.dead_bug));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.trunk_rotation), Integer.valueOf(R.string.trunk_rotation_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.mountain_climber), Integer.valueOf(R.string.mountain_climber_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.clapping_crunches), Integer.valueOf(R.string.clapping_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.swimming_and_superman), Integer.valueOf(R.string.swimming_and_superman_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.butt_bridge), Integer.valueOf(R.string.butt_bridge_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.flutter_kicks), Integer.valueOf(R.string.flutter_kicks_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.plank), Integer.valueOf(R.string.plank_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.reverse_crunches), Integer.valueOf(R.string.reverse_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.bent_leg_twist), Integer.valueOf(R.string.bent_leg_twist_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.bicycle_crunches), Integer.valueOf(R.string.bicycle_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.russian_twist), Integer.valueOf(R.string.russian_twist_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.reclined_oblique_twist), Integer.valueOf(R.string.reclined_oblique_twist_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.cross_arm_crunches), Integer.valueOf(R.string.cross_arm_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.standing_bicycle), Integer.valueOf(R.string.standing_bicycle_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.leg_drops), Integer.valueOf(R.string.leg_drops_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.side_leg_rise_left), Integer.valueOf(R.string.side_leg_rise_left_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.side_leg_rise_right), Integer.valueOf(R.string.side_leg_rise_right_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.long_arm_crunches), Integer.valueOf(R.string.long_arm_crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.dead_bug), Integer.valueOf(R.string.dead_bug_desc));


        } else if (this.excercisetype.equalsIgnoreCase("buttock")) {
            this.l.setText(getResources().getString(R.string.buttocks_title));
            this.day = "Day 1";

            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.SQUATS), Integer.valueOf(R.array.squats));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.DONKEYKICKSLEFT), Integer.valueOf(R.array.donkeykickleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.DONKEYKICKSRIGHT), Integer.valueOf(R.array.donkeykickright));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.PLIESQUATS), Integer.valueOf(R.array.pliesquats));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.butt_bridge), Integer.valueOf(R.array.buttbridge));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_heeltouch), Integer.valueOf(R.array.heeltouch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_lunges), Integer.valueOf(R.array.lunges));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.mountain_climber), Integer.valueOf(R.array.mountainclimber));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.flutter_kicks), Integer.valueOf(R.array.flutterkicks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_adductor_strect_in_standing), Integer.valueOf(R.array.aductorstretch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.CURTSYLUNGES), Integer.valueOf(R.array.curstylunges));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.RIGHTLUNGESKNEEHOPS), Integer.valueOf(R.array.rightlungeskneehops));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.LEFTLUNGESKNEEHOPS), Integer.valueOf(R.array.leftlungeskneehops));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.FIREHYDRANTLEFT), Integer.valueOf(R.array.firehydrantleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.FIREHYDRANTRIGHT), Integer.valueOf(R.array.firehydrantright));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.SPLITSQUATLEFT), Integer.valueOf(R.array.splitsquatleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.SPLITSQUATRIGHT), Integer.valueOf(R.array.splitsquatright));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.SQUATS), Integer.valueOf(R.string.SQUATSDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.DONKEYKICKSLEFT), Integer.valueOf(R.string.DONKEYKICKSLEFTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.DONKEYKICKSRIGHT), Integer.valueOf(R.string.DONKEYKICKSRIGHTDESCIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.PLIESQUATS), Integer.valueOf(R.string.PLIESQUATSDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.butt_bridge), Integer.valueOf(R.string.BUTTBRIDGEDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_heeltouch), Integer.valueOf(R.string.HEELTOUCHDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_lunges), Integer.valueOf(R.string.LUNGESDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.mountain_climber), Integer.valueOf(R.string.MOUNTAINCLIMBERDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.flutter_kicks), Integer.valueOf(R.string.FLUTTERKICKSDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_adductor_strect_in_standing), Integer.valueOf(R.string.ADDUCTORSTRECHINSTANDINGDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.CURTSYLUNGES), Integer.valueOf(R.string.CURTSYLUNGESDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.RIGHTLUNGESKNEEHOPS), Integer.valueOf(R.string.RIGHTLUNGESKNEEHOPSDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.LEFTLUNGESKNEEHOPS), Integer.valueOf(R.string.LEFTLUNGESKNEEHOPSDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.FIREHYDRANTLEFT), Integer.valueOf(R.string.FIREHYDRANTLEFTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.FIREHYDRANTRIGHT), Integer.valueOf(R.string.FIREHYDRANTRIGHTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.SPLITSQUATLEFT), Integer.valueOf(R.string.SPLITSQUATLEFTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.SPLITSQUATRIGHT), Integer.valueOf(R.string.SPLITSQUATRIGHTDESCRIPTION));


        } else if (this.excercisetype.equalsIgnoreCase("morning")) {
            this.l.setText(getResources().getString(R.string.morning_title));
            this.day = "Day 5";

            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.JUMPINGJACKS), Integer.valueOf(R.array.jumpingjacks_morning));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.SHOULDERSTRETCH), Integer.valueOf(R.array.shoulderstretch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.BRIDGE), Integer.valueOf(R.array.bridge));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.REVERSECRUNCHES), Integer.valueOf(R.array.reversecrunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.BUTTBRIDGE), Integer.valueOf(R.array.buttbridge));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.ABDOMINALCRUNCHES), Integer.valueOf(R.array.abdominalcrunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.BIRDDOG), Integer.valueOf(R.array.birddog));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.COBRASTRETCH), Integer.valueOf(R.array.cobrastretch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.HEELTOUCH), Integer.valueOf(R.array.heeltouch));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.JUMPINGJACKS), Integer.valueOf(R.string.JUMPINGJACKSDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.SHOULDERSTRETCH), Integer.valueOf(R.string.SHOULDERSTRETCHDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.BRIDGE), Integer.valueOf(R.string.BRIDGEDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.REVERSECRUNCHES), Integer.valueOf(R.string.REVERSECRUNCHESDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.BUTTBRIDGE), Integer.valueOf(R.string.BUTTBRIDGEDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.ABDOMINALCRUNCHES), Integer.valueOf(R.string.ABDOMINALCRUNCHESDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.BIRDDOG), Integer.valueOf(R.string.BIRDDOGDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.COBRASTRETCH), Integer.valueOf(R.string.COBRASTRETCHDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.HEELTOUCH), Integer.valueOf(R.string.HEELTOUCHDESCRIPTION));


        } else if (this.excercisetype.equalsIgnoreCase("evening")) {
            this.l.setText(getResources().getString(R.string.evening_title));
            this.day = "Day 6";
            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.TRICEPSSTRETCHLEFT), Integer.valueOf(R.array.tricepsstretchleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.TRICEPSSTRETCHRIGHT), Integer.valueOf(R.array.tricepsstretchright));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.LEFTQUADSTRETCHWITHWALL), Integer.valueOf(R.array.leftquadstretchwithwall));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.RIGHTQUADSTRETCHWITHWALL), Integer.valueOf(R.array.rightquadstretchwithwall));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.CALFSTRETCHLEFT), Integer.valueOf(R.array.calfstretchleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.CALFSTRETCHRIGHT), Integer.valueOf(R.array.calfstretchright));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.COBRASTRETCH), Integer.valueOf(R.array.cobrastretch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.CHILDPOSE), Integer.valueOf(R.array.childpose));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.CATCOWPOSE), Integer.valueOf(R.array.catcowpose));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.LYINGBUTTERFLYSTRETCH), Integer.valueOf(R.array.lyingbutterflystretch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.BRIDGE), Integer.valueOf(R.array.bridge));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.TRICEPSSTRETCHLEFT), Integer.valueOf(R.string.TRICEPSSTRETCHLEFTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.TRICEPSSTRETCHRIGHT), Integer.valueOf(R.string.TRICEPSSTRETCHRIGHTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.LEFTQUADSTRETCHWITHWALL), Integer.valueOf(R.string.LEFTQUADSTRETCHWITHWALLDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.RIGHTQUADSTRETCHWITHWALL), Integer.valueOf(R.string.RIGHTQUADSTRETCHWITHWALLDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.CALFSTRETCHLEFT), Integer.valueOf(R.string.CALFSTRETCHLEFTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.CALFSTRETCHRIGHT), Integer.valueOf(R.string.CALFSTRETCHRIGHTDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.COBRASTRETCH), Integer.valueOf(R.string.COBRASTRETCHDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.CHILDPOSE), Integer.valueOf(R.string.CHILDPOSEDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.CATCOWPOSE), Integer.valueOf(R.string.CATCOWPOSEDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.LYINGBUTTERFLYSTRETCH), Integer.valueOf(R.string.LYINGBUTTERFLYSTRETCHDESCRIPTION));
            this.hashMapExcDescription.put(getResources().getString(R.string.BRIDGE), Integer.valueOf(R.string.BRIDGEDESCRIPTION));


        } else if (this.excercisetype.equalsIgnoreCase("fatburn")) {
            this.day = "Day 4";
            this.l.setText(getResources().getString(R.string.fatburn_title));

            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.burpees), Integer.valueOf(R.array.burpees));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.crunches), Integer.valueOf(R.array.crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.dips), Integer.valueOf(R.array.dips));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.firehydrantleft), Integer.valueOf(R.array.fatburn_firehydrantleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.firehydrantright), Integer.valueOf(R.array.fatburn_firehydrantright));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.jumpingjacks), Integer.valueOf(R.array.jumpingjacks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.legliftleft), Integer.valueOf(R.array.legliftleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.legliftright), Integer.valueOf(R.array.legliftright));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.mountainclimbing), Integer.valueOf(R.array.mountainclimbing));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.plank), Integer.valueOf(R.array.fatburn_plank));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.pushups), Integer.valueOf(R.array.pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.russiantwists), Integer.valueOf(R.array.russiantwists));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.scissors), Integer.valueOf(R.array.scissors));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.squats), Integer.valueOf(R.array.fatburn_squats));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.burpees), Integer.valueOf(R.string.burpees_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.crunches), Integer.valueOf(R.string.crunches_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.dips), Integer.valueOf(R.string.dips_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.firehydrantleft), Integer.valueOf(R.string.firehydrantleft_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.firehydrantright), Integer.valueOf(R.string.firehydrantright_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.jumpingjacks), Integer.valueOf(R.string.jumpingjacks_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.legliftleft), Integer.valueOf(R.string.legliftleft_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.legliftright), Integer.valueOf(R.string.legliftright_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.mountainclimbing), Integer.valueOf(R.string.mountainclimbing_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.plank), Integer.valueOf(R.string.plank_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.pushups), Integer.valueOf(R.string.pushups_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.russiantwists), Integer.valueOf(R.string.russiantwists_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.scissors), Integer.valueOf(R.string.scissors_desc));
            this.hashMapExcDescription.put(getResources().getString(R.string.squats), Integer.valueOf(R.string.squats_desc));


        } else if (this.excercisetype.equalsIgnoreCase("weightloss")) {
            this.day = "Day 2";
            this.l.setText(getResources().getString(R.string.weightloss_title));
            this.hashMapExcAnimResIds = new HashMap<>();
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_swimming_and_superman), Integer.valueOf(R.array.swimming_and_superman));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_side_lunges), Integer.valueOf(R.array.side_lunges));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_lunges), Integer.valueOf(R.array.lunges));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_plie_squats), Integer.valueOf(R.array.plie_squats));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_wallpushups), Integer.valueOf(R.array.wall_pushups));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_squats), Integer.valueOf(R.array.squats));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_side_lying_leg_lift_right), Integer.valueOf(R.array.side_lying_leg_lift_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_side_lying_leg_lift_left), Integer.valueOf(R.array.side_lying_leg_lift_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_clapsoverhead), Integer.valueOf(R.array.clapsoverhead));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_butt_bridge), Integer.valueOf(R.array.butt_bridge));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_plank), Integer.valueOf(R.array.plank));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_standing_bicycle_crunches), Integer.valueOf(R.array.standing_bicycle_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_fire_hydrant_left), Integer.valueOf(R.array.fire_hydrant_left));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_fire_hydrant_right), Integer.valueOf(R.array.fire_hydrant_right));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_clapping_crunches), Integer.valueOf(R.array.clapping_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_heeltouch), Integer.valueOf(R.array.heeltouch));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_donkeykicksright), Integer.valueOf(R.array.donkeykicksright));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_donkeykicksleft), Integer.valueOf(R.array.donkeykicksleft));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_bicycle_crunches), Integer.valueOf(R.array.bicycle_crunches));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_flutter_kicks), Integer.valueOf(R.array.flutter_kicks));
            this.hashMapExcAnimResIds.put(getResources().getString(R.string.wl_adductor_strect_in_standing), Integer.valueOf(R.array.adductor_strect_in_standing));


            this.hashMapExcDescription = new HashMap<>();
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_swimming_and_superman), Integer.valueOf(R.string.desc_swimming_and_superman));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_side_lunges), Integer.valueOf(R.string.desc_side_lunges));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_lunges), Integer.valueOf(R.string.desc_lunges));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_plie_squats), Integer.valueOf(R.string.desc_plie_squats));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_wallpushups), Integer.valueOf(R.string.desc_wall_pushups));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_squats), Integer.valueOf(R.string.desc_squats));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_side_lying_leg_lift_right), Integer.valueOf(R.string.desc_side_leg_rise_right));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_side_lying_leg_lift_left), Integer.valueOf(R.string.desc_side_leg_rise_left));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_clapsoverhead), Integer.valueOf(R.string.desc_clapsoverhead));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_butt_bridge), Integer.valueOf(R.string.desc_butt_bridge));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_plank), Integer.valueOf(R.string.desc_plank));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_standing_bicycle_crunches), Integer.valueOf(R.string.desc_standing_bicycle_crunches));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_fire_hydrant_left), Integer.valueOf(R.string.desc_fire_hydrant_left));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_fire_hydrant_right), Integer.valueOf(R.string.desc_fire_hydrant_right));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_clapping_crunches), Integer.valueOf(R.string.desc_clapping_crunches));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_heeltouch), Integer.valueOf(R.string.desc_heeltouch));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_donkeykicksright), Integer.valueOf(R.string.desc_donkeykicksright));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_donkeykicksleft), Integer.valueOf(R.string.desc_donkeykicksleft));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_bicycle_crunches), Integer.valueOf(R.string.desc_bicycle_crunches));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_flutter_kicks), Integer.valueOf(R.string.desc_flutter_kicks));
            this.hashMapExcDescription.put(getResources().getString(R.string.wl_adductor_strect_in_standing), Integer.valueOf(R.string.desc_adductor_strect_in_standing));


        }
        this.workoutDataList = q();
        this.p = new IndividualDayAdapter(this.n, this.day, this.workoutDataList, 200);
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
        this.p = new IndividualDayAdapter(this.n, this.day, this.workoutDataList, 200);
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
        Log.e("DayCheck", "Day exc cycles DayActivity: " + dayExcCycles);
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
