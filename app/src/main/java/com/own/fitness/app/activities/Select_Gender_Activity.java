package com.own.fitness.app.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdLoader;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.formats.MediaView;
//import com.google.android.gms.ads.formats.NativeAdOptions;
//import com.google.android.gms.ads.formats.UnifiedNativeAd;
//import com.google.android.gms.ads.formats.UnifiedNativeAdView;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.own.fitness.app.R;
import com.own.fitness.app.aputils.CommonMethods;
import com.onesignal.OneSignal;

import java.util.Objects;

public class Select_Gender_Activity extends AppCompatActivity {

    RelativeLayout women;
    RelativeLayout men;
    RelativeLayout select_gender_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__gender);

        select_gender_layout = (RelativeLayout) findViewById(R.id.select_gender_layout);
        if (select_gender_layout.getVisibility() == View.GONE)
        {
            select_gender_layout.setVisibility(View.VISIBLE);
        }

//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
        new CommonMethods(getApplicationContext()).updateLocale(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("languageToLoad", "en"));


        //        ---------------------------------------------------------------------------------------------
//        OneSignal Initialization

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

//        ----------------------------------------------------------------------------------------------


        women = (RelativeLayout) findViewById(R.id.women);
        men = (RelativeLayout) findViewById(R.id.men);

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select_Gender_Activity.this, SuperMainActivity.class);
                intent.putExtra("select", "women");
                startActivity(intent);





            }
        });

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Select_Gender_Activity.this, SuperMainActivity.class);
                intent1.putExtra("select", "men");
                startActivity(intent1);


            }
        });


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
////            populateUnifiedNativeAdView(unifiedNativeAd, adView);
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

                Select_Gender_Activity.super.onBackPressed();
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



    @Override
    public void onBackPressed() {
        exitConfirmDialog();
    }


}