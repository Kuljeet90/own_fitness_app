package com.own.fitness.app.aputils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.own.fitness.app.NotificationReceiver;
import com.own.fitness.app.R;

import java.util.Calendar;
import java.util.Locale;

public class CommonMethods {


    AlarmManager f845a;
    Calendar b = Calendar.getInstance();
    Context context;

    public CommonMethods(Context context2) {
        this.context = context2;
    }

    public void actionView(String str) {
        if (isConnectedToInternet()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this.context, R.string.check_internet_str, 0).show();
        }
    }

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

    public void setAlarm(int i, int i2, int i3) {
        Log.d("TimeSet", "Time" + i + ":" + i2 + ":" + i3);
        this.f845a = (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.b.set(11, i);
        this.b.set(12, i2);
        this.b.set(13, i3);
        Intent intent = new Intent(this.context, NotificationReceiver.class);
        intent.getIntExtra("RequestCode", 100);
        this.f845a.cancel(PendingIntent.getBroadcast(this.context, 100, intent, 134217728));
        Log.d("Tag", "previous alarm canceled");
        Log.d("Tag", "new alarm sets");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context.getApplicationContext(), 100, new Intent(this.context.getApplicationContext(), NotificationReceiver.class), 134217728);
        this.f845a = (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        AlarmManager alarmManager = this.f845a;
        if (alarmManager != null) {
            alarmManager.setRepeating(0, this.b.getTimeInMillis(), 86400000, broadcast);
        }
    }

    public void updateLocale(String str) {
        Locale locale = new Locale(str);
        Resources resources = this.context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
    }
}
