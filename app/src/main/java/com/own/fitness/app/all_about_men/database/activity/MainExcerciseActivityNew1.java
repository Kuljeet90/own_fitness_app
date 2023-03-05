package com.own.fitness.app.all_about_men.database.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.facebook.ads.AdSize;
import com.getkeepsafe.android.multistateanimation.MultiStateAnimation;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdLoader;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.formats.MediaView;
//import com.google.android.gms.ads.formats.NativeAdOptions;
//import com.google.android.gms.ads.formats.UnifiedNativeAd;
//import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.own.fitness.app.R;
import com.own.fitness.app.activities.SuperMainActivity;
import com.own.fitness.app.activities.complete;
import com.own.fitness.app.adapters.WorkoutData;
//import com.own.fitness.app.allads.AdmobAds;
import com.own.fitness.app.aputils.AbsWomenApplication;
import com.own.fitness.app.aputils.AppUtils;
import com.own.fitness.app.aputils.CommonMethods;
import com.own.fitness.app.all_about_men.database.DatabaseOperations1;
import com.own.fitness.app.all_about_men.database.sortnameclass.i;
import com.own.fitness.app.all_about_men.database.sortnameclass.j;
import com.own.fitness.app.all_about_men.database.sortnameclass.k;
import com.own.fitness.app.all_about_men.database.sortnameclass.l;
import com.own.fitness.app.all_about_men.database.sortnameclass.m;
import com.own.fitness.app.all_about_men.database.sortnameclass.n;
import com.own.fitness.app.all_about_men.database.sortnameclass.o;
import com.own.fitness.app.all_about_men.database.sortnameclass.q;
import com.own.fitness.app.all_about_men.database.sortnameclass.r;
import com.own.fitness.app.all_about_men.database.sortnameclass.s;
import com.own.fitness.app.all_about_men.database.sortnameclass.t;
import com.own.fitness.app.all_about_men.database.sortnameclass.u;
import com.own.fitness.app.all_about_men.database.sortnameclass.v;
import com.own.fitness.app.all_about_men.database.sortnameclass.w;
import com.own.fitness.app.all_about_men.database.sortnameclass.x;
import com.own.fitness.app.all_about_men.database.sortnameclass.y;
import com.travijuu.numberpicker.library.NumberPicker;

import java.util.ArrayList;
import java.util.Objects;


public class MainExcerciseActivityNew1 extends AppCompatActivity {
    boolean boola;
    boolean boolb;
    boolean boolc;
    boolean boold;

    MultiStateAnimation.SectionBuilder secf;
    MultiStateAnimation.SectionBuilder secg;
    MultiStateAnimation animah;
    MultiStateAnimation animai;
    MultiStateAnimation animaj;
    AbsWomenApplication absWomenApplication;
//    AdRequest adRequest;
//    AdRequest adRequest1;
    TextView count;
    TextView countRestTimer;
    DatabaseOperations1 databaseOperations;
    String day;
    int excCouner;
    TextView excDescInReadyToGo;
    TextView excName;
    TextView excNameInReadyToGo;
    CountDownTimer excersiseTimer;
    int i = 0;
//    InterstitialAd interstitial;
    ImageView l;
    LinearLayout layoutprogress;
    String m = "";
//    InterstitialAd mInterstitialAdAtBackPress;
    int mainExcCounter = 1;
    long n = 10000;
    TextView nextExNumber;
    TextView nextExerciseCycles;
    TextView nextExerciseName;
    TextView o;
    ImageView p;
    boolean pauseClicked = false;
    ImageView pauseMainExcersise;
    ImageView pauseRestTime;
    FloatingActionButton playPause;
    double progress;
    RoundCornerProgressBar progressbar;
    ImageView q;
    float r = 1.0f;
    CountDownTimer readyToGoTimer;
    RelativeLayout redytogo;
    long timerrr;
    RelativeLayout restScreen;
    CountDownTimer restTimer;
    ProgressBar restTimerprogress;
    int prefresresttime;
    ImageView resumRestTime;
    ImageView resumeMainExcersise;
    long s;
    long t = 25000;
    ProgressBar timerprogress;
    ProgressBar topProgressBar;
    TextView tvProgress;
    TextView tvProgressMax;
//    AdmobAds u = null;
    Context v;
    Intent w;
    WorkoutData workoutData;
    ArrayList<WorkoutData> workoutDataList;
    SharedPreferences x;
    int y;
    boolean z;


    public static int e(MainExcerciseActivityNew1 mainExcerciseActivityNew) {
        int i2 = mainExcerciseActivityNew.excCouner;
        mainExcerciseActivityNew.excCouner = i2 + 1;
        return i2;
    }

    private void exerciseInfo() {
        Dialog dialog = new Dialog(this.v, R.style.Theme_Dialog);
        try {
            ((Window) Objects.requireNonNull(dialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        dialog.requestWindowFeature(1);
        ((Window) Objects.requireNonNull(dialog.getWindow())).setFlags(1024, 1024);
        dialog.setContentView(R.layout.activity_excinfodialog);
        ((Window) Objects.requireNonNull(dialog.getWindow())).setLayout(-1, -1);
        dialog.setCancelable(true);
        ((TextView) dialog.findViewById(R.id.dialogexcName)).setText(this.m);
        this.animaj = new MultiStateAnimation.Builder((ImageView) dialog.findViewById(R.id.animation_exDetail)).addSection(this.secf).build(this);
        MultiStateAnimation multiStateAnimation = this.animaj;
        multiStateAnimation.transitionNow("loading" + this.excCouner);
        ((TextView) dialog.findViewById(R.id.description_exDetail)).setText(this.workoutDataList.get(this.excCouner).getExcDescResId());
        dialog.show();
    }

    private void exitConfirmDialog(boolean z2) {
        Dialog dialog = new Dialog(this.v, R.style.Theme_Dialog);
        dialog.requestWindowFeature(1);
        ((Window) Objects.requireNonNull(dialog.getWindow())).setFlags(1024, 1024);
        dialog.setContentView(R.layout.exit_confirm_addialog_layout);
        LinearLayout linearLayout = dialog.findViewById(R.id.layoutContainer_dialog);
//        if (z2) {
//            this.u.displayAdmobAdOnLoad_Dialog(linearLayout);
//        }
        ((Window) Objects.requireNonNull(dialog.getWindow())).setLayout(-1, -1);
        ((TextView) dialog.findViewById(R.id.btnYes)).setOnClickListener(new n(this, dialog));
        ((TextView) dialog.findViewById(R.id.btnNo)).setOnClickListener(new q(dialog));
        dialog.show();
    }

    private void initWorkoutdata(int i2) {
        String str;
        TextView textView;
        this.workoutData = this.workoutDataList.get(i2);
        this.secf = new MultiStateAnimation.SectionBuilder("loading" + this.excCouner);
        for (int addFrame : this.workoutData.getImageIdList()) {
            this.secf.addFrame(addFrame);
        }
        this.secf.setOneshot(false);
        this.secf.setFrameDuration(1000);
        this.animah = new MultiStateAnimation.Builder((ImageView) findViewById(R.id.animImageFull)).addSection(this.secf).build(this);
        this.animah.transitionNow("loading" + this.excCouner);
        this.progressbar.setMax(Float.parseFloat(String.valueOf((this.s / 1000) - 1)));
        this.topProgressBar = (ProgressBar) this.layoutprogress.findViewById(i2);
        this.topProgressBar.setProgress(0);
        this.topProgressBar.setMax((((int) this.s) / 1000) - 1);
        this.absWomenApplication.addEarCorn();
        this.m = this.workoutDataList.get(i2).getExcName().replace("_", " ").toUpperCase();
        this.excName.setText(this.m);
        if (this.workoutData.getImageIdList().length > 1) {
            textView = this.tvProgressMax;
            str = "/".concat(String.valueOf(this.workoutDataList.get(i2).getExcCycles()));
        } else {
            textView = this.tvProgressMax;
            str = "/".concat(String.valueOf(this.workoutDataList.get(i2).getExcCycles())).concat(" Sec");
        }
        textView.setText(str);
    }


    public void mainExcTimer(long j, int i2, float f) {
        try {
            initWorkoutdata(this.excCouner);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        final float f2 = f;
        final int i3 = i2;
        this.excersiseTimer = new CountDownTimer(j, 1000) {


            float f768a = f2;
            int b = i3;

            public void onFinish() {
                String str;
                StringBuilder sb;
                TextView textView;
                MainExcerciseActivityNew1 mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew.boola = false;
                RoundCornerProgressBar pbar = mainExcerciseActivityNew.progressbar;
                float f = this.f768a;
                this.f768a = f + 1.0f;
                pbar.setProgress(f);
                MainExcerciseActivityNew1.this.topProgressBar.setProgress(100);
                if (MainExcerciseActivityNew1.this.excCouner < MainExcerciseActivityNew1.this.workoutDataList.size()) {
                    for (int i2 = 0; i2 < MainExcerciseActivityNew1.this.excCouner; i2++) {
                        MainExcerciseActivityNew1 mainExcerciseActivityNew2 = MainExcerciseActivityNew1.this;
                        mainExcerciseActivityNew2.topProgressBar = (ProgressBar) mainExcerciseActivityNew2.layoutprogress.findViewById(i2);
                        MainExcerciseActivityNew1.this.topProgressBar.setMax(((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getImageIdList().length * ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles());
                        MainExcerciseActivityNew1.this.topProgressBar.setProgress(((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getImageIdList().length * ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles());
                    }
                }
                MainExcerciseActivityNew1.e(MainExcerciseActivityNew1.this);
                TextView textView1 = MainExcerciseActivityNew1.this.nextExNumber;
                textView1.setText(MainExcerciseActivityNew1.this.getResources().getString(R.string.next) + " " + (MainExcerciseActivityNew1.this.excCouner + 1) + "/" + MainExcerciseActivityNew1.this.workoutDataList.size());
                if (MainExcerciseActivityNew1.this.excCouner < MainExcerciseActivityNew1.this.workoutDataList.size()) {
                    MainExcerciseActivityNew1.this.restScreen.setVisibility(View.VISIBLE);
                    MainExcerciseActivityNew1.this.pauseRestTime.setVisibility(View.VISIBLE);
                    MainExcerciseActivityNew1.this.resumRestTime.setVisibility(View.GONE);
                    MainExcerciseActivityNew1.this.progressbar.setMax((float) ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles());
                    TextView h = MainExcerciseActivityNew1.this.tvProgress;
                    int i3 = this.b;
                    this.b = i3 + 1;
                    h.setText(String.valueOf(i3));
                    if (MainExcerciseActivityNew1.this.workoutData.getImageIdList().length > 1) {
                        textView = MainExcerciseActivityNew1.this.tvProgressMax;
                        sb = new StringBuilder();
                        sb.append(((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles());
                        str = "";
                    } else {
                        textView = MainExcerciseActivityNew1.this.tvProgressMax;
                        sb = new StringBuilder();
                        sb.append(((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles());
                        str = " Sec";
                    }
                    sb.append(str);
                    textView.setText(sb.toString());
                    this.f768a = 1.0f;
                    this.b = 1;
                    MainExcerciseActivityNew1 mainExcerciseActivityNew3 = MainExcerciseActivityNew1.this;
                    if (!mainExcerciseActivityNew3.boolb) {
                        mainExcerciseActivityNew3.a(mainExcerciseActivityNew3.t);
                    }
                    MainExcerciseActivityNew1 mainExcerciseActivityNew4 = MainExcerciseActivityNew1.this;
                    if (mainExcerciseActivityNew4.y == 1) {
                        mainExcerciseActivityNew4.absWomenApplication.speak(MainExcerciseActivityNew1.this.getString(R.string.takerestspeak));
                    }
                } else {
                    Intent intent = new Intent(MainExcerciseActivityNew1.this, complete.class);
                    intent.putExtra("daynumber", ((Bundle) Objects.requireNonNull(MainExcerciseActivityNew1.this.getIntent().getExtras())).getInt("day_value_number"));
                    intent.putExtra("day", MainExcerciseActivityNew1.this.day);
                    int size = MainExcerciseActivityNew1.this.workoutDataList.size();
                    int i4 = 0;
                    for (int i5 = 0; i5 < MainExcerciseActivityNew1.this.workoutDataList.size(); i5++) {
                        i4 = i4 + ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(i5)).getImageIdList().length + 30;
                    }
                    intent.putExtra("totalExc", size);
                    intent.putExtra("totalTime", i4);
                    MainExcerciseActivityNew1.this.startActivity(intent);
//                    if (MainExcerciseActivityNew1.this.interstitial.isLoaded()) {
//                        MainExcerciseActivityNew1.this.interstitial.show();
//                    }
                    finish();
                }
                MainExcerciseActivityNew1 mainExcerciseActivityNew5 = MainExcerciseActivityNew1.this;
                double excDayProgress = (double) mainExcerciseActivityNew5.databaseOperations.getExcDayProgress(MainExcerciseActivityNew1.this.day);
                double size2 = (double) ((float) MainExcerciseActivityNew1.this.workoutDataList.size());
                Double.isNaN(size2);
                Double.isNaN(excDayProgress);
                mainExcerciseActivityNew5.progress = excDayProgress + (100.0d / size2);
                MainExcerciseActivityNew1 mainExcerciseActivityNew6 = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew6.dataBaseProgressUpdate(mainExcerciseActivityNew6.progress);
                MainExcerciseActivityNew1 mainExcerciseActivityNew7 = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew7.r = 1.0f;
                mainExcerciseActivityNew7.mainExcCounter = 1;
            }

            public void onTick(long j) {
                MainExcerciseActivityNew1 mainExcerciseActivityNew;
                TextView h = null;
                String valueOf = null;
                MainExcerciseActivityNew1 mainExcerciseActivityNew2 = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew2.boola = true;
                mainExcerciseActivityNew2.boolc = false;
                try {
                    if (((WorkoutData) mainExcerciseActivityNew2.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getImageIdList().length > 2) {
                        if (this.b <= ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles()) {
                            if (this.f768a == 1.0f) {
                                h = MainExcerciseActivityNew1.this.tvProgress;
                                valueOf = String.valueOf(1);
                                h.setText(valueOf);
                            } else if (this.f768a % ((float) ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getImageIdList().length) == 0.0f) {
                                h = MainExcerciseActivityNew1.this.tvProgress;
                                int jk = this.b;
                                this.b = jk + 1;
                                valueOf = String.valueOf(jk);
                                h.setText(valueOf);
                            }
                        }
                        if (this.b == ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles() + 1) {
                            MainExcerciseActivityNew1.this.tvProgress.setText(String.valueOf(((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles()));
                        }
                        RoundCornerProgressBar i2 = MainExcerciseActivityNew1.this.progressbar;
                        float f = this.f768a;
                        this.f768a = 1.0f + f;
                        i2.setProgress(f);
                        MainExcerciseActivityNew1.this.topProgressBar.setProgress((int) this.f768a);
                        MainExcerciseActivityNew1.this.timerrr = j;
                        MainExcerciseActivityNew1.this.mainExcCounter = this.b;
                        mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                        mainExcerciseActivityNew.r = this.f768a;
                        if (mainExcerciseActivityNew.y == 1) {
                            mainExcerciseActivityNew.absWomenApplication.playEarCorn();


                        }
                        return;
                    }
                    if (this.b <= ((WorkoutData) MainExcerciseActivityNew1.this.workoutDataList.get(MainExcerciseActivityNew1.this.excCouner)).getExcCycles()) {
                        h = MainExcerciseActivityNew1.this.tvProgress;
                        int i3 = this.b;
                        this.b = i3 + 1;
                        valueOf = String.valueOf(i3);
                        h.setText(valueOf);
                    }


                    RoundCornerProgressBar i22 = MainExcerciseActivityNew1.this.progressbar;
                    float f2 = this.f768a;
                    this.f768a = 1.0f + f2;
                    i22.setProgress(f2);
                    MainExcerciseActivityNew1.this.topProgressBar.setProgress((int) this.f768a);
                    MainExcerciseActivityNew1.this.timerrr = j;
                    MainExcerciseActivityNew1.this.mainExcCounter = this.b;
                    mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                    mainExcerciseActivityNew.r = this.f768a;


                } catch (IndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                }
                RoundCornerProgressBar i222 = MainExcerciseActivityNew1.this.progressbar;
                float f22 = this.f768a;
                this.f768a = 1.0f + f22;
                i222.setProgress(f22);
                MainExcerciseActivityNew1.this.topProgressBar.setProgress((int) this.f768a);
                MainExcerciseActivityNew1.this.timerrr = j;
                MainExcerciseActivityNew1.this.mainExcCounter = this.b;
                mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew.r = this.f768a;


            }


        }.start();
    }

    private void resumeExerciseAgain() {
        this.pauseMainExcersise.setVisibility(View.VISIBLE);
        this.resumeMainExcersise.setVisibility(View.GONE);
        mainExcTimer(this.timerrr - 1000, this.mainExcCounter, this.r);
    }

//    private void setAdmodAds() {
////        this.u = new AdmobAds(this.v);
//        this.interstitial = new InterstitialAd(this);
//        this.interstitial.setAdUnitId(getString(R.string.AdMob_Full_ID));
//        this.mInterstitialAdAtBackPress = new InterstitialAd(this);
//        this.mInterstitialAdAtBackPress.setAdUnitId(getString(R.string.AdMob_Full_ID));
//        this.adRequest = new AdRequest.Builder().build();
//        this.interstitial.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                MainExcerciseActivityNew1.this.interstitial.loadAd(MainExcerciseActivityNew1.this.adRequest);
//            }
//        });
//        this.interstitial.loadAd(this.adRequest);
//        this.adRequest = new AdRequest.Builder().build();
//        this.adRequest1 = new AdRequest.Builder().build();
//        this.mInterstitialAdAtBackPress.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                MainExcerciseActivityNew1.this.mInterstitialAdAtBackPress.loadAd(MainExcerciseActivityNew1.this.adRequest1);
//            }
//        });
//        this.mInterstitialAdAtBackPress.loadAd(this.adRequest1);
//    }

    public void a(int i2) {
        this.prefresresttime = i2;
    }

    public void a(long j) {
        TextView textView;
        String concat;
        try {
            this.m = this.workoutDataList.get(this.excCouner).getExcName().replace("_", " ").toUpperCase();
            this.nextExerciseName.setText(this.m);
            if (this.workoutDataList.get(this.excCouner).getImageIdList().length > 1) {
                textView = this.nextExerciseCycles;
                concat = "x".concat(String.valueOf(this.workoutDataList.get(this.excCouner).getExcCycles()));
            } else {
                textView = this.nextExerciseCycles;
                concat = String.valueOf(this.workoutDataList.get(this.excCouner).getExcCycles()).concat(" Sec");
            }
            textView.setText(concat);
            this.secg = new MultiStateAnimation.SectionBuilder("loading_" + this.excCouner);
            for (int addFrame : this.workoutDataList.get(this.excCouner).getImageIdList()) {
                this.secg.addFrame(addFrame);
            }
            this.secg.setOneshot(false);
            this.secg.setFrameDuration(1000);
            this.animai = new MultiStateAnimation.Builder((ImageView) findViewById(R.id.nextExercisAnimation)).addSection(this.secg).build(this);
            this.animai.transitionNow("loading_" + this.excCouner);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        this.restTimerprogress.setMax((int) (this.t / 1000));
        this.restTimer = new CountDownTimer(j, 1000) {
            public void onFinish() {
                MainExcerciseActivityNew1 mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew.boolb = false;
                mainExcerciseActivityNew.countRestTimer.setText(String.valueOf(MainExcerciseActivityNew1.this.t / 1000));
                MainExcerciseActivityNew1.this.restScreen.setVisibility(View.GONE);
                MainExcerciseActivityNew1.this.pauseMainExcersise.setVisibility(View.VISIBLE);
                MainExcerciseActivityNew1.this.resumeMainExcersise.setVisibility(View.GONE);
                MainExcerciseActivityNew1 mainExcerciseActivityNew2 = MainExcerciseActivityNew1.this;
                long calculateExTime = mainExcerciseActivityNew2.calculateExTime(mainExcerciseActivityNew2.excCouner);
                MainExcerciseActivityNew1 mainExcerciseActivityNew3 = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew3.s = calculateExTime;
                if (!mainExcerciseActivityNew3.boola) {
                    mainExcerciseActivityNew3.mainExcTimer(calculateExTime, mainExcerciseActivityNew3.mainExcCounter, MainExcerciseActivityNew1.this.r);
                }
            }

            public void onTick(long j) {
                MainExcerciseActivityNew1 mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew.boold = false;
                mainExcerciseActivityNew.boolb = true;
                long j2 = (j - 1000) / 1000;
                mainExcerciseActivityNew.restTimerprogress.setProgress((int) j2);
                MainExcerciseActivityNew1.this.countRestTimer.setText(String.valueOf(j2));
                MainExcerciseActivityNew1.this.timerrr = j;
                if (j2 < 4) {
                    MainExcerciseActivityNew1 mainExcerciseActivityNew2 = MainExcerciseActivityNew1.this;
                    if (mainExcerciseActivityNew2.y == 1) {
                        if (j2 == 3) {
                            mainExcerciseActivityNew2.absWomenApplication.speak("3");
                        }
                        if (j2 == 2) {
                            MainExcerciseActivityNew1.this.absWomenApplication.speak("2");
                        }
                        if (j2 == 1) {
                            MainExcerciseActivityNew1.this.absWomenApplication.speak("1");
                            MainExcerciseActivityNew1.this.absWomenApplication.speak(MainExcerciseActivityNew1.this.getString(R.string.start));
                        }
                    }
                }
            }
        }.start();
    }

    public void a(Dialog dialog) {
        this.t = (long) ((this.prefresresttime * 1000) + 2000);
        SharedPreferences.Editor edit = this.x.edit();
        edit.putInt(getResources().getString(R.string.rest_time_key), this.prefresresttime);
        edit.apply();
        dialog.dismiss();
    }

    public void a() {
        if (!this.boolc) {
            this.boolc = true;
            this.topProgressBar.setProgress(100);
            this.excersiseTimer.cancel();
            this.excersiseTimer.onFinish();
        }
    }


    public void dialogg() {
        Dialog dialog = new Dialog(this.v, R.style.AppTheme);
        ((Window) Objects.requireNonNull(dialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.getWindow().setLayout(-1, -1);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.activity_customdialog_cycles);
        dialog.setCancelable(false);
        dialog.setCancelable(true);
        NumberPicker numberPicker = (NumberPicker) dialog.findViewById(R.id.countdownNumberPicker);
        this.prefresresttime = this.x.getInt(getResources().getString(R.string.rest_time_key), 25);
        numberPicker.setValue(this.prefresresttime);
        numberPicker.setValueChangedListener(new t(this));
        ((TextView) dialog.findViewById(R.id.calculate)).setOnClickListener(new l(this, dialog));
        dialog.show();
    }

    public void b(Dialog dialog) {
        cancelTimers();
        try {
            Intent intent = new Intent(this, SuperMainActivity.class);

            startActivity(intent);
            dialog.dismiss();
            super.onBackPressed();
//            if (this.mInterstitialAdAtBackPress.isLoaded()) {
//                this.mInterstitialAdAtBackPress.show();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        TextView textView;
        String str;
        if (this.excCouner > 0) {
            this.topProgressBar.setProgress(0);
            this.excersiseTimer.cancel();
            this.excCouner--;
            this.progressbar.setMax((float) this.workoutDataList.get(this.excCouner).getExcCycles());
            if (this.workoutData.getImageIdList().length > 1) {
                textView = this.tvProgressMax;
                str = String.valueOf(this.workoutDataList.get(this.excCouner).getExcCycles());
            } else {
                textView = this.tvProgressMax;
                str = this.workoutDataList.get(this.excCouner).getExcCycles() + " Sec";
            }
            textView.setText(str);
            long calculateExTime = calculateExTime(this.excCouner);
            this.s = calculateExTime;
            this.pauseMainExcersise.setVisibility(View.VISIBLE);
            this.resumeMainExcersise.setVisibility(View.GONE);
            double excDayProgress = (double) this.databaseOperations.getExcDayProgress(this.day);
            double size = (double) ((float) this.workoutDataList.size());
            Double.isNaN(size);
            Double.isNaN(excDayProgress);
            this.progress = excDayProgress - (100.0d / size);
            dataBaseProgressUpdate(this.progress);
            mainExcTimer(calculateExTime, 1, 1.0f);
            return;
        }
        Toast.makeText(this.absWomenApplication, "This is first exercise", Toast.LENGTH_SHORT).show();
    }

    public void c() {
        CountDownTimer countDownTimer = this.excersiseTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.boola = false;
        }
        this.resumeMainExcersise.setVisibility(View.VISIBLE);
        this.pauseMainExcersise.setVisibility(View.GONE);
        exerciseInfo();
    }

    public long calculateExTime(int i2) {
        return this.workoutDataList.get(i2).getImageIdList().length > 2 ? (long) (((this.workoutDataList.get(i2).getImageIdList().length * this.workoutDataList.get(i2).getExcCycles()) + 1) * 1000) : (long) ((this.workoutDataList.get(i2).getExcCycles() + 1) * 1000);
    }

    public void cancelTimers() {
        try {
            if (this.readyToGoTimer != null) {
                this.readyToGoTimer.cancel();
            }
            if (this.excersiseTimer != null) {
                this.excersiseTimer.cancel();
                this.boola = false;
            }
            if (this.restTimer != null) {
                this.restTimer.cancel();
                this.boolb = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        CountDownTimer countDownTimer = this.excersiseTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.boola = false;
        }
        this.resumeMainExcersise.setVisibility(View.VISIBLE);
        this.pauseMainExcersise.setVisibility(View.GONE);
        dialogg();
    }

    public void dataBaseProgressUpdate(double d) {
        this.databaseOperations.insertExcDayData(this.day, (float) d);
        this.databaseOperations.insertExcCounter(this.day, this.excCouner);
        Log.d("CounterValue", this.excCouner + "");
        try {
            this.w = new Intent(AppUtils.WORKOUT_BROADCAST_FILTER);
            this.w.putExtra(AppUtils.KEY_PROGRESS, d);
            sendBroadcast(this.w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e() {
        if (!this.boold) {
            this.boold = true;
            this.restTimer.cancel();
            this.restTimer.onFinish();
            this.pauseRestTime.setVisibility(View.VISIBLE);
            this.resumRestTime.setVisibility(View.GONE);
        }
    }

    public void f() {
        this.readyToGoTimer.cancel();
        this.readyToGoTimer.onFinish();
    }

    public void g() {
        onBackPressed();
    }

    public void h() {
        if (this.i % 2 == 0) {
            this.playPause.setImageResource(R.drawable.play_icon);
            this.z = true;
            this.readyToGoTimer.cancel();
        } else {
            this.z = false;
            this.playPause.setImageResource(R.drawable.pause_icon);
            readyToGoFun(this.timerrr);
        }
        this.i++;
    }

    public void i() {
        this.pauseRestTime.setVisibility(View.GONE);
        this.resumRestTime.setVisibility(View.VISIBLE);
        this.restTimer.cancel();
        this.boolb = false;
    }

    public void j() {
        this.pauseRestTime.setVisibility(View.VISIBLE);
        this.resumRestTime.setVisibility(View.GONE);
        a(this.timerrr);
    }

    public void k() {
        this.pauseMainExcersise.setVisibility(View.GONE);
        this.resumeMainExcersise.setVisibility(View.VISIBLE);
        this.excersiseTimer.cancel();
        this.boola = false;
    }

    public void l() {
        resumeExerciseAgain();
    }


    @Override
    public void onBackPressed() {
        this.pauseClicked = false;
//        exitConfirmDialog(this.u.refreshAd_dialog(getString(R.string.ADMOB_Unit_ID)));
        exitConfirmDialog(false);
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

//    private void refreshAd() {
//        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.AdMob_Native_ID));
//
//        builder.forUnifiedNativeAd(unifiedNativeAd -> {
//
//            if (nativeAd != null) {
//                nativeAd.destroy();
//            }
//            nativeAd = unifiedNativeAd;
//            FrameLayout frameLayout = findViewById(R.id.f2_adplaceholderr);
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

//    private void refreshAd1() {
//        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.AdMob_Native_ID));
//
//        builder.forUnifiedNativeAd(unifiedNativeAd -> {
//
//            if (nativeAd != null) {
//                nativeAd.destroy();
//            }
//            nativeAd = unifiedNativeAd;
//            FrameLayout frameLayout = findViewById(R.id.f2_adplaceholderr1);
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
//            }
//        }).build();
//        adLoader.loadAd(new AdRequest.Builder().build());
//
//    }

    RelativeLayout rel;
    RelativeLayout tltl;
    RelativeLayout t1;
    TextView rest_counting;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.v = this;
        new CommonMethods(this).updateLocale(PreferenceManager.getDefaultSharedPreferences(this.v).getString("languageToLoad", "en"));
        setContentView((int) R.layout.mainexcercise_layout1);

        rel = (RelativeLayout) findViewById(R.id.r1);
        rel.setBackgroundColor(getResources().getColor(R.color.men_color));


        tltl = (RelativeLayout) findViewById(R.id.tltl);
        tltl.setBackgroundColor(getResources().getColor(R.color.men_color));

        t1 = (RelativeLayout) findViewById(R.id.t1);
        t1.setBackgroundColor(getResources().getColor(R.color.men_color));

        rest_counting = (TextView) findViewById(R.id.rest_counting);
        rest_counting.setTextColor(getResources().getColor(R.color.men_color));


        this.nextExerciseName = (TextView) findViewById(R.id.nextExerciseName);
        nextExerciseName.setTextColor(getResources().getColor(R.color.men_color));



        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.myad_fb);
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getString(R.string.fb_banner), AdSize.BANNER_HEIGHT_50);
        adViewContainer.addView(adView);
        adView.loadAd();


        this.databaseOperations = new DatabaseOperations1(this);
//        setAdmodAds();
//        refreshAd();
//        refreshAd1();
        Bundle extras = getIntent().getExtras();
        this.x = this.v.getSharedPreferences(getResources().getString(R.string.timer_fref_file_name), 0);
        this.prefresresttime = this.x.getInt(getResources().getString(R.string.rest_time_key), 25);
        this.t = (long) ((this.prefresresttime * 1000) + 2000);
        this.n = (long) ((this.x.getInt(getResources().getString(R.string.counter_time_key), 10) * 1000) + 2000);
        this.y = this.x.getInt("sound", 1);
        this.workoutDataList = (ArrayList) extras.getSerializable("workoutDataList");
        this.day = ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getString("day");
        this.absWomenApplication = AbsWomenApplication.getInstance();
        this.excCouner = this.databaseOperations.getDayExcCounter(this.day);

        this.progressbar = (RoundCornerProgressBar) findViewById(R.id.progress_one);
        this.progressbar.setProgressColor(getResources().getColor(R.color.men_color));


        this.tvProgress = (TextView) findViewById(R.id.tv_progress);
        this.tvProgressMax = (TextView) findViewById(R.id.tv_progress_max);
        this.restScreen = (RelativeLayout) findViewById(R.id.restScreen);
        this.excName = (TextView) findViewById(R.id.excName);
        this.pauseMainExcersise = (ImageView) findViewById(R.id.pauseMainExcersise);
        this.resumeMainExcersise = (ImageView) findViewById(R.id.resumeMainExcersise);
        this.p = (ImageView) findViewById(R.id.next_exercise);
        this.q = (ImageView) findViewById(R.id.pre_exercise);
        this.w = new Intent(AppUtils.WORKOUT_BROADCAST_FILTER);
        this.o = (TextView) findViewById(R.id.skip);
        this.timerprogress = (ProgressBar) findViewById(R.id.timer);
        this.l = (ImageView) findViewById(R.id.backImage);
        this.count = (TextView) findViewById(R.id.counting);
        this.playPause = (FloatingActionButton) findViewById(R.id.floating_action_button);
        this.excDescInReadyToGo = (TextView) findViewById(R.id.excDescInReadyToGo);
        this.excNameInReadyToGo = (TextView) findViewById(R.id.excNameInReadyToGo);
        this.pauseRestTime = (ImageView) findViewById(R.id.pauseRestTime);
        this.resumRestTime = (ImageView) findViewById(R.id.resumeRestTime);
        this.restTimerprogress = (ProgressBar) findViewById(R.id.rest_timer);
        this.countRestTimer = (TextView) findViewById(R.id.rest_counting);
        this.nextExerciseName = (TextView) findViewById(R.id.nextExerciseName);
        nextExerciseCycles = (TextView) findViewById(R.id.nextExerciseCycles);
        this.nextExNumber = (TextView) findViewById(R.id.nextExerciseNumber);
        this.layoutprogress = (LinearLayout) findViewById(R.id.hLayoutprogress);
        this.redytogo = (RelativeLayout) findViewById(R.id.readytogo_layout);
        this.progressbar.setMax(10.0f);

        this.p.setOnClickListener(new x(this));
        this.q.setOnClickListener(new o(this));
        ((TextView) findViewById(R.id.skipRestTime)).setOnClickListener(new m(this));
        this.o.setOnClickListener(new w(this));
        this.l.setOnClickListener(new k(this));
        this.playPause.setOnClickListener(new j(this));
        this.pauseRestTime.setOnClickListener(new y(this));
        this.resumRestTime.setOnClickListener(new v(this));
        this.pauseMainExcersise.setOnClickListener(new s(this));
        this.resumeMainExcersise.setOnClickListener(new r(this));


        ((ImageView) findViewById(R.id.help_exercise)).setOnClickListener(new i(this));
        ((ImageView) findViewById(R.id.rest_exercise_counter)).setOnClickListener(new u(this));
        if (this.y == 1) {
            this.absWomenApplication.speak(getString(R.string.ready_to_go));
        }
        readyToGoFun(this.n);
        this.timerprogress.setMax((int) (this.n / 1000));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        for (int i2 = 0; i2 < this.workoutDataList.size(); i2++) {
            this.topProgressBar = new ProgressBar(this, (AttributeSet) null, 16842872);
            layoutParams.rightMargin = 2;
            layoutParams.leftMargin = 2;
            if (Build.VERSION.SDK_INT < 21) {
                this.topProgressBar.setProgressDrawable(getDrawable(R.drawable.launch_progressbar));
            }
            this.topProgressBar.setPadding(0, 0, 0, 0);
            this.topProgressBar.setIndeterminate(false);
            this.topProgressBar.setLayoutParams(layoutParams);
            this.topProgressBar.setId(i2);
            this.topProgressBar.setScaleY(2.5f);
            this.layoutprogress.addView(this.topProgressBar);
        }
        for (int i3 = 0; i3 < this.excCouner; i3++) {
            this.topProgressBar = (ProgressBar) this.layoutprogress.findViewById(i3);
            this.topProgressBar.setMax(this.workoutDataList.get(this.excCouner).getImageIdList().length * this.workoutDataList.get(this.excCouner).getExcCycles());
            this.topProgressBar.setProgress(this.workoutDataList.get(this.excCouner).getImageIdList().length * this.workoutDataList.get(this.excCouner).getExcCycles());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.workoutDataList != null) {
            this.workoutDataList = null;
            Log.d("workoutdata", "null");
        }
        if (this.databaseOperations != null) {
            this.databaseOperations = null;
        }
        if (this.absWomenApplication != null) {
            this.absWomenApplication = null;
        }
        CountDownTimer countDownTimer = this.excersiseTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.excersiseTimer = null;
        }
        CountDownTimer countDownTimer2 = this.readyToGoTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.readyToGoTimer = null;
        }
        CountDownTimer countDownTimer3 = this.restTimer;
        if (countDownTimer3 != null) {
            countDownTimer3.cancel();
            this.restTimer = null;
        }
        if (this.v != null) {
            this.v = null;
        }
//        if (this.interstitial != null) {
//            this.interstitial = null;
//        }
//        if (this.mInterstitialAdAtBackPress != null) {
//            this.mInterstitialAdAtBackPress = null;
//        }
        MultiStateAnimation multiStateAnimation = this.animaj;
        if (multiStateAnimation != null) {
            multiStateAnimation.clearAnimation();
        }
        MultiStateAnimation multiStateAnimation2 = this.animai;
        if (multiStateAnimation2 != null) {
            multiStateAnimation2.clearAnimation();
        }
        MultiStateAnimation multiStateAnimation3 = this.animah;
        if (multiStateAnimation3 != null) {
            multiStateAnimation3.clearAnimation();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
        cancelTimers();
        if (!this.z) {
            this.i--;
        }
        this.playPause.setImageResource(R.drawable.play_icon);
        this.resumeMainExcersise.setVisibility(View.VISIBLE);
        this.pauseMainExcersise.setVisibility(View.GONE);
        this.resumRestTime.setVisibility(View.VISIBLE);
        this.pauseRestTime.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (this.absWomenApplication == null) {
            this.absWomenApplication = AbsWomenApplication.getInstance();
        }
    }

    public void readyToGoFun(long j) {
        this.excDescInReadyToGo.setText(getResources().getString(this.workoutDataList.get(this.excCouner).getExcDescResId()).concat("\n\n\n"));
        this.m = this.workoutDataList.get(this.excCouner).getExcName().replace("_", " ").toUpperCase();
        this.excNameInReadyToGo.setText(this.m);
        this.readyToGoTimer = new CountDownTimer(j, 1000) {
            public void onFinish() {
                MainExcerciseActivityNew1.this.timerprogress.setProgress(0);
                MainExcerciseActivityNew1.this.redytogo.setVisibility(View.GONE);
                MainExcerciseActivityNew1.this.pauseMainExcersise.setVisibility(View.VISIBLE);
                MainExcerciseActivityNew1.this.resumeMainExcersise.setVisibility(View.GONE);
                MainExcerciseActivityNew1 mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                long calculateExTime = mainExcerciseActivityNew.calculateExTime(mainExcerciseActivityNew.excCouner);
                MainExcerciseActivityNew1 mainExcerciseActivityNew2 = MainExcerciseActivityNew1.this;
                mainExcerciseActivityNew2.s = calculateExTime;
                if (!mainExcerciseActivityNew2.boola) {
                    mainExcerciseActivityNew2.mainExcTimer(calculateExTime, mainExcerciseActivityNew2.mainExcCounter, MainExcerciseActivityNew1.this.r);
                }
            }

            public void onTick(long j) {
                long j2 = j - 1000;
                MainExcerciseActivityNew1.this.timerprogress.setProgress(((int) j2) / 1000);
                long j3 = j2 / 1000;
                MainExcerciseActivityNew1.this.count.setText(String.valueOf(j3));
                MainExcerciseActivityNew1.this.timerrr = j;
                if (j3 < 4) {
                    MainExcerciseActivityNew1 mainExcerciseActivityNew = MainExcerciseActivityNew1.this;
                    if (mainExcerciseActivityNew.y == 1) {
                        if (j3 == 3) {
                            mainExcerciseActivityNew.absWomenApplication.speak("3");
                        }
                        if (j3 == 2) {
                            MainExcerciseActivityNew1.this.absWomenApplication.speak("2");
                        }
                        if (j3 == 1) {
                            MainExcerciseActivityNew1.this.absWomenApplication.speak("1");
                        }
                    }
                }
            }
        }.start();

    }


}
