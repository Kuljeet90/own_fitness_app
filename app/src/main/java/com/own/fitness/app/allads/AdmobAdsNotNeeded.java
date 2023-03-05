package com.own.fitness.app.allads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.own.fitness.app.R;

public class AdmobAdsNotNeeded {

    boolean adloadddoalog;
    Context context;
    LinearLayout linnative;

    UnifiedNativeAd unifindadd;
    String adunitid = String.valueOf(R.string.ADMOB_Unit_ID);

    public AdmobAdsNotNeeded(Context context2) {
        this.context = context2;
        MobileAds.initialize(context2, this.adunitid);
    }

    public AdmobAdsNotNeeded(Context context2, LinearLayout linearLayout) {
        this.context = context2;
        this.linnative = linearLayout;
        MobileAds.initialize(context2, this.adunitid);
    }


//    public void displayAdmobAdOnLoad_Dialog(LinearLayout linearLayout) {
//        linearLayout.setVisibility(View.VISIBLE);
//        UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) LayoutInflater.from(this.context).inflate(R.layout.ad_unified_dialog, (ViewGroup) null);
//        populateUnifiedNativeAdView_dialog(this.unifindadd, unifiedNativeAdView);
//        linearLayout.addView(unifiedNativeAdView);
//    }

    public boolean isConnectedToInternet() {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
                for (NetworkInfo state : allNetworkInfo) {
                    if (state.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public void populateUnifiedNativeAdView(UnifiedNativeAd unifiedNativeAd, UnifiedNativeAdView unifiedNativeAdView) {
        int i;
        View view;
        unifiedNativeAd.getVideoController().setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {

            @Override
            public void onVideoEnd() {
                super.onVideoEnd();
            }
        });
        int i2 = this.context.getResources().getDisplayMetrics().heightPixels;
        MediaView mediaView = (MediaView) unifiedNativeAdView.findViewById(R.id.popup_appinstall_image);
        ViewGroup.LayoutParams layoutParams = mediaView.getLayoutParams();
        layoutParams.height = (int) (((float) i2) / 4.0f);
        mediaView.setLayoutParams(layoutParams);
        unifiedNativeAdView.setMediaView(mediaView);
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_call_to_action));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_app_icon));
        unifiedNativeAdView.findViewById(R.id.close_ad_popup).setVisibility(View.INVISIBLE);
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        ((Button) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        if (unifiedNativeAd.getIcon() == null) {
            view = unifiedNativeAdView.getIconView();
            i = 8;
        } else {
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            view = unifiedNativeAdView.getIconView();
            i = 0;
        }
        view.setVisibility(i);
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
    }

    public void populateUnifiedNativeAdView_dialog(UnifiedNativeAd unifiedNativeAd, UnifiedNativeAdView unifiedNativeAdView) {
        int i;
        View view;
        unifiedNativeAd.getVideoController().setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                super.onVideoEnd();
            }
        });
        int i2 = this.context.getResources().getDisplayMetrics().heightPixels;
        MediaView mediaView = (MediaView) unifiedNativeAdView.findViewById(R.id.popup_appinstall_image_dialog);
        ViewGroup.LayoutParams layoutParams = mediaView.getLayoutParams();
        layoutParams.height = (int) (((float) i2) / 3.0f);
        mediaView.setLayoutParams(layoutParams);
        unifiedNativeAdView.setMediaView(mediaView);
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_headline_dialog));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_body_dialog));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_call_to_action_dialog));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.popup_appinstall_app_icon_dialog));
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        ((Button) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        if (unifiedNativeAd.getIcon() == null) {
            view = unifiedNativeAdView.getIconView();
            i = 8;
        } else {
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            view = unifiedNativeAdView.getIconView();
            i = 0;
        }
        view.setVisibility(i);
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
    }

//    public void refreshAd(final String str) {
//        AdLoader.Builder builder = new AdLoader.Builder(this.context, str);
//        builder.forUnifiedNativeAd(unifiedNativeAd -> {
//            UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) LayoutInflater.from(AdmobAds.this.context).inflate(R.layout.ad_unified, (ViewGroup) null);
//            AdmobAdsNotNeeded.this.populateUnifiedNativeAdView(unifiedNativeAd, unifiedNativeAdView);
//            AdmobAdsNotNeeded.this.linnative.setBackgroundResource(R.drawable.shape_roundedwhite);
//            AdmobAdsNotNeeded.this.linnative.addView(unifiedNativeAdView);
//        });
//        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
//        builder.withAdListener(new AdListener() {
//            @Override
//            public void onAdFailedToLoad(int i) {
//                AdmobAdsNotNeeded.this.refreshAd(str);
//            }
//        }).build().loadAd(new AdRequest.Builder().build());
//    }

    public boolean refreshAd_dialog(final String str) {
        if (isConnectedToInternet()) {
            AdLoader.Builder builder = new AdLoader.Builder(this.context, str);
            builder.forUnifiedNativeAd(unifiedNativeAd -> {
                AdmobAdsNotNeeded.this.adloadddoalog = true;
                AdmobAdsNotNeeded.this.unifindadd = unifiedNativeAd;
            });
            builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(int i) {
                    AdmobAdsNotNeeded.this.adloadddoalog = false;
                    AdmobAdsNotNeeded.this.refreshAd_dialog(str);
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
        return this.adloadddoalog;
    }
}
