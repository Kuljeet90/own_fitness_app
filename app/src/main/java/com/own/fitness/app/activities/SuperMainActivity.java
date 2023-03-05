package com.own.fitness.app.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdLoader;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.formats.MediaView;
//import com.google.android.gms.ads.formats.NativeAdOptions;
//import com.google.android.gms.ads.formats.UnifiedNativeAd;
//import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.own.fitness.app.NotificationReceiver;
import com.own.fitness.app.R;
import com.own.fitness.app.all_about_men.database.DatabaseOperations1;
import com.own.fitness.app.all_about_men.database.activity.Advancedtip1;
import com.own.fitness.app.all_about_men.database.fragment.RoutinesFragment1;
import com.own.fitness.app.all_about_men.database.fragment.TrainingFragment1;
import com.own.fitness.app.aputils.AppUtils;
import com.own.fitness.app.aputils.CommonMethods;
import com.own.fitness.app.database.DatabaseOperations;
import com.own.fitness.app.fragments.AdvancedtipFragment;
import com.own.fitness.app.fragments.ProfileFragment;
import com.own.fitness.app.fragments.RoutinesFragment;
import com.own.fitness.app.fragments.TrainingFragment;
import com.own.fitness.app.sortnameclass.a.SupermainClick;
import com.own.fitness.app.sortnameclass.a.c0;
import com.own.fitness.app.sortnameclass.a.d0;
import com.own.fitness.app.sortnameclass.a.d0_main1;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Objects;

//import com.google.firebase.analytics.FirebaseAnalytics;


public class SuperMainActivity extends AppCompatActivity {
    RelativeLayout rellayout;
    ImageView imgview;
    boolean boleannn;
    SharedPreferences prefrenc;
    DatabaseOperations dboperation;
    DatabaseOperations1 dboperation1;
    BottomNavigationMenuView meuvie;
    BottomNavigationItemView meuviebottom;


    Context context;
    int height;
    BottomNavigationView l;
    TrainingFragment m;
    //    FirebaseAnalytics mFirebaseAnalytics;
//    InterstitialAd mInterstitialAdloading;
    RoutinesFragment n;
    ProfileFragment o;
    AdvancedtipFragment p;
    String q = null;
    String r = null;
    CommonMethods s;
    SharedPreferences t;
    SharedPreferences u;
    String v;
    ViewPager viewPager;
    TimePicker w;
    int width;
    int x;
    int y;
    SharedPreferences.Editor z;
    //    TextView women_workout;
//    TextView men_workout;
//    RelativeLayout top_bar;
    RelativeLayout women;
    RelativeLayout men;
    RelativeLayout select_gender_layout;
    RelativeLayout main_layout;


    private boolean loadFragment(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        return true;
    }

    public static void setHomeItem(Activity activity) {
        ((BottomNavigationView) activity.findViewById(R.id.bottom_navigation)).setSelectedItemId(R.id.training);
    }

//    private void setUpLoadingTimeAd() {
//        this.mInterstitialAdloading = new InterstitialAd(this);
//        this.mInterstitialAdloading.setAdUnitId(getString(R.string.AdMob_Full_ID));
//        this.mInterstitialAdloading.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                SuperMainActivity superMainActivity = SuperMainActivity.this;
//                if (!superMainActivity.boleannn) {
//                    SharedPreferences.Editor edit = superMainActivity.prefrenc.edit();
//                    edit.putBoolean("first_time", Boolean.TRUE.booleanValue());
//                    edit.apply();
//                    SuperMainActivity.this.rellayout.setVisibility(View.VISIBLE);
//                } else {
//                    superMainActivity.l.setVisibility(View.VISIBLE);
//                    SuperMainActivity.this.rellayout.setVisibility(View.GONE);
//                }
//                SuperMainActivity.this.b();
//            }
//
//            @Override
//            public void onAdFailedToLoad(int i) {
//                super.onAdFailedToLoad(i);
//                SuperMainActivity superMainActivity = SuperMainActivity.this;
//                if (!superMainActivity.boleannn) {
//                    SharedPreferences.Editor edit = superMainActivity.prefrenc.edit();
//                    edit.putBoolean("first_time", Boolean.TRUE.booleanValue());
//                    edit.apply();
//                    SuperMainActivity.this.rellayout.setVisibility(View.VISIBLE);
//                } else {
//                    superMainActivity.l.setVisibility(View.VISIBLE);
//                    SuperMainActivity.this.rellayout.setVisibility(View.GONE);
//                }
//                SuperMainActivity.this.b();
//            }
//
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                try {
//                    if (SuperMainActivity.this.mInterstitialAdloading != null && SuperMainActivity.this.mInterstitialAdloading.isLoaded()) {
//                        SuperMainActivity.this.mInterstitialAdloading.show();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        this.mInterstitialAdloading.loadAd(new AdRequest.Builder().build());
//    }


    public boolean a(MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.profile:
                fragment = new ProfileFragment();
                break;
            case R.id.routine:
                fragment = new RoutinesFragment();
                break;
            case R.id.tips_main:
                fragment = new Advancedtip();
                break;
            case R.id.training:
                fragment = new TrainingFragment();
                break;
            default:
                fragment = null;
                break;
        }
        return loadFragment(fragment);
    }


    public boolean a1(MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.profile:
                fragment = new ProfileFragment();
                break;
            case R.id.routine:
                fragment = new RoutinesFragment1();
                break;
            case R.id.tips_main:
                fragment = new Advancedtip1();


                break;
            case R.id.training:
                fragment = new TrainingFragment1();

                break;
            default:
                fragment = null;
                break;
        }
        return loadFragment(fragment);
    }

    public void b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.q = intent.getStringExtra(AppUtils.APP_PACKAGE_NAME);
            this.r = intent.getStringExtra(AppUtils.APP_BANNER_URL);
            Log.i("SuperMainActivity: " + this.r, "appPackageNameFromFCM: " + this.q);
            if (!(this.q == null || this.r == null)) {
                c();
                SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences(AppUtils.FCM_CROSS_PROMO_PREF, 0).edit();
                edit.putString("appPackageNameFromFCM", this.q);
                edit.apply();
            }
        }
        Log.d("onCreate", "appPackageUrlFromFCM: " + this.q);
    }

    public void b(Dialog dialog) {
        dialog.dismiss();
        super.onBackPressed();
    }

    public void c() {
        Dialog dialog = new Dialog(this, R.style.Theme_Dialog);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.FCMDialogAnimation;
        dialog.setContentView(R.layout.launch_fcm_dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.setCancelable(true);
        final ImageView imageView = (ImageView) dialog.findViewById(R.id.ad_close);
        imageView.setOnClickListener(new c0(dialog));
        FrameLayout frameLayout = (FrameLayout) dialog.findViewById(R.id.layoutContainer_dialog);
        frameLayout.setVisibility(View.VISIBLE);
        ImageView imageView2 = (ImageView) frameLayout.findViewById(R.id.image);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int i = this.width;
        layoutParams.width = i - (i / 10);
        imageView2.getLayoutParams().height = this.width;
        try {
            if (this.r != null) {
                Picasso.get().load(this.r).resize(this.width - (this.width / 10), this.width).placeholder((int) R.drawable.progress_animation).error((int) R.drawable.error).into(imageView2, new Callback() {


                    public void onSuccess() {
                        imageView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                        imageView.setVisibility(View.VISIBLE);
                    }
                });
            }
            imageView2.setOnClickListener(new SupermainClick(this, dialog));
        } catch (Exception e) {
            e.printStackTrace();
        }
        dialog.show();
    }

    public void c(Dialog dialog) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.q)));
        dialog.dismiss();
//        try {
//            Bundle bundle = new Bundle();
//            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, this.q);
//            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "clicked");
//            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
//            this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
//    private UnifiedNativeAd nativeAd;

//    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
//
//        MediaView mediaView = adView.findViewById(R.id.ad_media);
//        adView.setMediaView(mediaView);
//
//        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
//        adView.setBodyView(adView.findViewById(R.id.ad_body));
//        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
//        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
//        adView.setPriceView(adView.findViewById(R.id.ad_price));
//        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
//        adView.setStoreView(adView.findViewById(R.id.ad_store));
//        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
//
//
//        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
//
//
//        if (nativeAd.getBody() == null) {
//            adView.getBodyView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getBodyView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
//        }
//
//        if (nativeAd.getCallToAction() == null) {
//            adView.getCallToActionView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getCallToActionView().setVisibility(View.VISIBLE);
//            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
//        }
//
//        if (nativeAd.getIcon() == null) {
//            adView.getIconView().setVisibility(View.GONE);
//        } else {
//            ((ImageView) adView.getIconView()).setImageDrawable(
//                    nativeAd.getIcon().getDrawable());
//            adView.getIconView().setVisibility(View.VISIBLE);
//        }
//
//        if (nativeAd.getPrice() == null) {
//            adView.getPriceView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getPriceView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
//        }
//
//        if (nativeAd.getStore() == null) {
//            adView.getStoreView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getStoreView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
//        }
//
//        if (nativeAd.getStarRating() == null) {
//            adView.getStarRatingView().setVisibility(View.INVISIBLE);
//        } else {
//            ((RatingBar) adView.getStarRatingView())
//                    .setRating(nativeAd.getStarRating().floatValue());
//            adView.getStarRatingView().setVisibility(View.VISIBLE);
//        }
//
//        if (nativeAd.getAdvertiser() == null) {
//            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
//        } else {
//            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
//            adView.getAdvertiserView().setVisibility(View.VISIBLE);
//        }
//
//        adView.setNativeAd(nativeAd);
//
//
//    }

//    private void refreshAd(final  Dialog dialog) {
//        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.AdMob_Native_ID));
//
//        builder.forUnifiedNativeAd(unifiedNativeAd -> {
//
//            if (nativeAd != null) {
//                nativeAd.destroy();
//            }
//            nativeAd = unifiedNativeAd;
//            FrameLayout frameLayout = dialog.findViewById(R.id.f2_adplaceholderr);
//            UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater()
//                    .inflate(R.layout.ad_unified2, null);
//            populateUnifiedNativeAdView(unifiedNativeAd, adView);
//            frameLayout.removeAllViews();
//            frameLayout.addView(adView);
//        });
//
//
//        NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
//        builder.withNativeAdOptions(adOptions);
//
//        AdLoader adLoader = builder.withAdListener(new AdListener() {
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                Log.e("", "hello");
//
//            }
//        }).build();
//        adLoader.loadAd(new AdRequest.Builder().build());
//
//    }


    TextView sub_title_text;

    private void exitConfirmDialog() {
        Dialog dialog = new Dialog(this, R.style.Theme_Dialog);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.setContentView(R.layout.exit_confirm_addialog_layout);

        sub_title_text = (TextView) dialog.findViewById(R.id.sub_title_text);
        sub_title_text.setText(getString(R.string.exit_app_msg));

//        refreshAd(dialog);

        ((Window) Objects.requireNonNull(dialog.getWindow())).setLayout(-1, -1);
        ((TextView) dialog.findViewById(R.id.btnYes)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialog.dismiss();

                SuperMainActivity.super.onBackPressed();
            }
        });
        ((TextView) dialog.findViewById(R.id.btnNo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    int counter = 0;

    @Override
    public void onBackPressed() {
        counter++;



        if (this.rellayout.getVisibility() == View.VISIBLE) {
            this.rellayout.setVisibility(View.GONE);
            return;
        }
        int selectedItemId = this.l.getSelectedItemId();
        Log.i("selectedId: " + selectedItemId, "onBackPressed: " + selectedItemId);
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (R.id.training == selectedItemId) {


            if (select_gender_layout.getVisibility() == View.GONE)
            {
                select_gender_layout.setVisibility(View.VISIBLE);
            }else {
                exitConfirmDialog();
            }

        } else if (backStackEntryCount == 0) {

            setHomeItem(this);
        } else {

            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onCreate(Bundle bundle) {

        int i;
        super.onCreate(bundle);

        this.context = this;
        this.u = PreferenceManager.getDefaultSharedPreferences(this.context);
        this.v = this.u.getString("languageToLoad", "en");
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.s = new CommonMethods(this.context);
        this.s.updateLocale(this.v);

        setContentView((int) R.layout.super_activity_main);


        select_gender_layout = (RelativeLayout) findViewById(R.id.select_gender_layout);
        main_layout = (RelativeLayout) findViewById(R.id.main_layout);

//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        if (!isTaskRoot()) {
            finish();
            return;
        }


        this.dboperation1 = new DatabaseOperations1(this);
        this.dboperation1.insertExcALLDayData();

//        if (!this.u.getBoolean("daysInserted", false) && this.dboperation1.CheckDBEmpty() == 0) {
//            this.dboperation1.insertExcALLDayData();
//            SharedPreferences.Editor edit = this.u.edit();
//            edit.putBoolean("daysInserted", true);
//            edit.apply();
//        }

        this.dboperation = new DatabaseOperations(this);
        this.dboperation.insertExcALLDayData();
//        if (!this.u.getBoolean("daysInserted", false) && this.dboperation.CheckDBEmpty() == 0) {
//            this.dboperation.insertExcALLDayData();
//            SharedPreferences.Editor edit = this.u.edit();
//            edit.putBoolean("daysInserted", true);
//            edit.apply();
//        }


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;
//        setUpLoadingTimeAd();


        this.l = (BottomNavigationView) findViewById(R.id.bottom_navigation);


//        loadFragment(new TrainingFragment());
//        this.l.setOnNavigationItemSelectedListener(new d0(this));

//        String select_data = getIntent().getStringExtra("select");


//        if (select_data.equals("women")) {
//            this.l.setOnNavigationItemSelectedListener(new d0(this));
//            loadFragment(new TrainingFragment());
//            Toast.makeText(SuperMainActivity.this, "Welcome", Toast.LENGTH_LONG).show();
//        } else if (select_data.equals("men")) {
//            this.l.setOnNavigationItemSelectedListener(new d0_main1(this));
//            loadFragment(new TrainingFragment1());
//            Toast.makeText(SuperMainActivity.this, "Welcome1", Toast.LENGTH_LONG).show();
//        }


        women = (RelativeLayout) findViewById(R.id.women);
        men = (RelativeLayout) findViewById(R.id.men);

        if (select_gender_layout.getVisibility() == View.GONE) {
            select_gender_layout.setVisibility(View.VISIBLE);

        } else {
            select_gender_layout.setVisibility(View.GONE);

        }

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new TrainingFragment());
                dboperation = new DatabaseOperations(SuperMainActivity.this);
                if (!u.getBoolean("daysInserted", false) && dboperation.CheckDBEmpty() == 0) {
                    dboperation.insertExcALLDayData();
                    SharedPreferences.Editor edit = u.edit();
                    edit.putBoolean("daysInserted", true);
                    edit.apply();
                }

                l.setOnNavigationItemSelectedListener(new d0(SuperMainActivity.this));
                l.getMenu().getItem(3).setIcon(R.drawable.women);
//                l.setItemTextColor(ColorStateList.valueOf(Color.parseColor("#ff416c")));
//                l.setItemIconTintList(ColorStateList.valueOf(Color.parseColor("#ff416c")));
                select_gender_layout.setVisibility(View.GONE);


            }
        });

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new TrainingFragment1());
                dboperation1 = new DatabaseOperations1(SuperMainActivity.this);
                if (!u.getBoolean("daysInserted", false) && dboperation1.CheckDBEmpty() == 0) {
                    dboperation1.insertExcALLDayData();
                    SharedPreferences.Editor edit = u.edit();
                    edit.putBoolean("daysInserted", true);
                    edit.apply();
                }
                l.setOnNavigationItemSelectedListener(new d0_main1(SuperMainActivity.this));
                l.getMenu().getItem(3).setIcon(R.drawable.men);
//                l.setItemTextColor(ColorStateList.valueOf(Color.parseColor("#429FDA")));
//                l.setItemIconTintList(ColorStateList.valueOf(Color.parseColor("#429FDA")));
                select_gender_layout.setVisibility(View.GONE);


            }
        });

//        women_workout = (TextView) findViewById(R.id.women_workout);
//        women_workout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFragment(new TrainingFragment());
//                dboperation = new DatabaseOperations(SuperMainActivity.this);
//                if (!u.getBoolean("daysInserted", false) && dboperation.CheckDBEmpty() == 0) {
//                    dboperation.insertExcALLDayData();
//                    SharedPreferences.Editor edit = u.edit();
//                    edit.putBoolean("daysInserted", true);
//                    edit.apply();
//                }
//                l.setOnNavigationItemSelectedListener(new d0(SuperMainActivity.this));
//
//            }
//        });
//
//        men_workout = (TextView) findViewById(R.id.men_workout);
//        men_workout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFragment(new TrainingFragment1());
//                dboperation1 = new DatabaseOperations1(SuperMainActivity.this);
//                if (!u.getBoolean("daysInserted", false) && dboperation1.CheckDBEmpty() == 0) {
//                    dboperation1.insertExcALLDayData();
//                    SharedPreferences.Editor edit = u.edit();
//                    edit.putBoolean("daysInserted", true);
//                    edit.apply();
//                }
//                l.setOnNavigationItemSelectedListener(new d0_main1(SuperMainActivity.this));
//
//            }
//        });


        this.meuvie = (BottomNavigationMenuView) this.l.getChildAt(0);
        this.meuviebottom = (BottomNavigationItemView) this.meuvie.getChildAt(2);


        this.t = PreferenceManager.getDefaultSharedPreferences(this);
        this.rellayout = (RelativeLayout) findViewById(R.id.notification_layout);
        this.w = (TimePicker) findViewById(R.id.datePicker1);
        Button button = (Button) findViewById(R.id.set);
        this.t = PreferenceManager.getDefaultSharedPreferences(this.context);
        this.z = this.t.edit();
        if (Build.VERSION.SDK_INT >= 23) {
            this.x = this.w.getHour();
            i = this.w.getMinute();
        } else {
            this.x = this.w.getCurrentHour().intValue();
            i = this.w.getCurrentMinute().intValue();
        }
        this.y = i;
        this.z.putInt("notification_hour", this.x);
        this.z.putInt("notification_minute", this.y);
        this.prefrenc = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        this.boleannn = this.prefrenc.getBoolean("first_time", false);
        button.setOnClickListener(view -> {
            SuperMainActivity superMainActivity;
            int i1;
            if (Build.VERSION.SDK_INT >= 23) {
                SuperMainActivity superMainActivity2 = SuperMainActivity.this;
                superMainActivity2.x = superMainActivity2.w.getHour();
                superMainActivity = SuperMainActivity.this;
                i1 = superMainActivity.w.getMinute();
            } else {
                SuperMainActivity superMainActivity3 = SuperMainActivity.this;
                superMainActivity3.x = superMainActivity3.w.getCurrentHour().intValue();
                superMainActivity = SuperMainActivity.this;
                i1 = superMainActivity.w.getCurrentMinute().intValue();
            }
            superMainActivity.y = i1;
            SuperMainActivity.this.z.putBoolean("user_selection", true);
            SuperMainActivity superMainActivity4 = SuperMainActivity.this;
            superMainActivity4.z.putInt("notification_hour", superMainActivity4.x);
            SuperMainActivity superMainActivity5 = SuperMainActivity.this;
            superMainActivity5.z.putInt("notification_minute", superMainActivity5.y);
            Log.d("ReminderCheck", "Reminder set in Main page");
            SuperMainActivity.this.z.apply();
            StringBuilder sb = new StringBuilder();
            sb.append("Reminder set in ");
            SuperMainActivity superMainActivity6 = SuperMainActivity.this;
            sb.append(superMainActivity6.t.getInt("notification_hour", superMainActivity6.x));
            sb.append(":");
            SuperMainActivity superMainActivity7 = SuperMainActivity.this;
            sb.append(superMainActivity7.t.getInt("notification_minute", superMainActivity7.y));
            sb.append(":");
            sb.append(0);
            Log.d("ReminderCheck", sb.toString());
            SuperMainActivity superMainActivity8 = SuperMainActivity.this;
            int i2 = superMainActivity8.t.getInt("notification_hour", superMainActivity8.x);
            SuperMainActivity superMainActivity9 = SuperMainActivity.this;
            superMainActivity8.setAlarm(i2, superMainActivity9.t.getInt("notification_minute", superMainActivity9.y), 0);
            SuperMainActivity.this.rellayout.setVisibility(View.GONE);
            SuperMainActivity.this.l.setVisibility(View.VISIBLE);
        });
        this.imgview = (ImageView) findViewById(R.id.close_notification);
        this.imgview.setOnClickListener(view -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Reminder set in ");
            SuperMainActivity superMainActivity = SuperMainActivity.this;
            sb.append(superMainActivity.t.getInt("notification_hour", superMainActivity.x));
            sb.append(":");
            SuperMainActivity superMainActivity2 = SuperMainActivity.this;
            sb.append(superMainActivity2.t.getInt("notification_minute", superMainActivity2.y));
            sb.append(":");
            sb.append(0);
            Log.d("ReminderCheck", sb.toString());
            SuperMainActivity superMainActivity3 = SuperMainActivity.this;
            int i12 = superMainActivity3.t.getInt("notification_hour", superMainActivity3.x);
            SuperMainActivity superMainActivity4 = SuperMainActivity.this;
            superMainActivity3.setAlarm(i12, superMainActivity4.t.getInt("notification_minute", superMainActivity4.y), 0);
            SuperMainActivity.this.rellayout.setVisibility(View.GONE);
            SuperMainActivity.this.l.setVisibility(View.VISIBLE);
        });
    }


    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("type")) {
                Objects.equals(extras.getString("type"), "test type");
            }
            extras.getString(AppUtils.APP_PACKAGE_NAME);
            this.q = intent.getStringExtra(AppUtils.APP_PACKAGE_NAME);
            this.r = intent.getStringExtra(AppUtils.APP_BANNER_URL);
            Log.d("onNewIntent", "appPackageNameFromFCM: " + this.q);
            if (this.q != null && this.r != null) {
                SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences(AppUtils.FCM_CROSS_PROMO_PREF, 0).edit();
                edit.putString("appPackageNameFromFCM", this.q);
                edit.apply();
                c();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
//        this.mInterstitialAdloading = null;
    }


    @SuppressLint("WrongConstant")
    public void setAlarm(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, i);
        instance.set(Calendar.MINUTE, i2);
        instance.set(Calendar.SECOND, i3);
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(AlarmManager.RTC_WAKEUP, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(getApplicationContext(), 100, new Intent(getApplicationContext(), NotificationReceiver.class), 134217728));
    }

}
