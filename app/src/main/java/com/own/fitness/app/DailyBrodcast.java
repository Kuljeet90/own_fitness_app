package com.own.fitness.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.Calendar;

public class DailyBrodcast extends BroadcastReceiver {


     SharedPreferences f748a;
     Context context;

    public void onReceive(Context context2, Intent intent) {
        this.context = context2;
        Log.i("intent.getAction(): " + intent.getAction(), "DailyBrodcast");
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED") || intent.getAction().equals("android.intent.action.QUICKBOOT_POWERON")) {
            setAlarm();
        }
    }

    public void setAlarm() {
        this.f748a = PreferenceManager.getDefaultSharedPreferences(this.context);
        Calendar instance = Calendar.getInstance();
        SharedPreferences sharedPreferences = this.f748a;
        instance.set(10, sharedPreferences.getInt("notification_hour", sharedPreferences.getInt("notification_hour", 7)));
        instance.set(12, this.f748a.getInt("notification_minute", 0));
        instance.set(13, 0);
        ((AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(this.context, 100, new Intent(this.context, NotificationReceiver.class), 134217728));
    }
}
