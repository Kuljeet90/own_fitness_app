package com.own.fitness.app.alarm.alarmmanagerdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.own.fitness.app.FemaleFitnessBootReceiver;
import java.util.Calendar;

public class AlarmHelper {
    public static final String PREFERENCE_LAST_REQUEST_CODE = "PREFERENCE_LAST_REQUEST_CODE";
    public static final int REQUEST_CODE = 1234;
    public static final String TAG = "AlarmMainActivity";
     AlarmManager alarmManager;
     Context context;
     SharedPreferences sharedPreferences;

    public AlarmHelper(Context context2) {
        this.context = context2;
        this.alarmManager = (AlarmManager) context2.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
    }

    private int getNextRequestCode() {
        int i = this.sharedPreferences.getInt(PREFERENCE_LAST_REQUEST_CODE, 0) + 1;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        this.sharedPreferences.edit().putInt(PREFERENCE_LAST_REQUEST_CODE, i).apply();
        return i;
    }

    private PendingIntent getPendingIntent() {
        Intent intent = new Intent("com.own.workout.pro.alarmmanagerdemo.NOTIFY_ACTION");
        intent.setClass(this.context, NotificationPublisher.class);
        intent.setFlags(268435456);
        return PendingIntent.getBroadcast(this.context, getNextRequestCode(), intent, 134217728);
    }

    private void setBootReceiverEnabled(int i) {
        Log.d(TAG, "setBootReceiverEnabled: ");
        this.context.getPackageManager().setComponentEnabledSetting(new ComponentName(this.context, FemaleFitnessBootReceiver.class), i, 1);
    }

    public PendingIntent existAlarm(int i) {
        Intent intent = new Intent("com.outthinking.abs.alarmmanagerdemo.NOTIFY_ACTION");
        intent.setClass(this.context, NotificationPublisher.class);
        return PendingIntent.getBroadcast(this.context, i, intent, 536870912);
    }

    public boolean isAlarmScheduled() {
        Intent intent = new Intent("com.own.workout.pro.alarmmanagerdemo.NOTIFY_ACTION");
        intent.setClass(this.context, NotificationPublisher.class);
        return PendingIntent.getBroadcast(this.context, 1234, intent, 536870912) != null;
    }

    public void schedulePendingIntent(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, i);
        instance.set(Calendar.MINUTE, i2);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        instance.set(Calendar.AM_PM, i3);
        schedulePendingIntent(instance.getTimeInMillis(), getPendingIntent());
    }

    public void schedulePendingIntent(int i, int i2, int i3, long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, i);
        instance.set(Calendar.MINUTE, i2);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        instance.set(Calendar.AM_PM, i3);
        schedulePendingIntent(instance.getTimeInMillis(), getPendingIntent(), j);
    }

    public void schedulePendingIntent(long j, PendingIntent pendingIntent) {
        Log.d(TAG, "schedulePendingIntent: " + j + "/" + pendingIntent);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            Log.d(TAG, "setExactAndAllowWhileIdle");
            this.alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, j, pendingIntent);
        } else if (i >= 19) {
            Log.d(TAG, "setExact");
            this.alarmManager.setExact(AlarmManager.RTC_WAKEUP, j, pendingIntent);
        } else {
            Log.d(TAG, "set");
            this.alarmManager.set(AlarmManager.RTC_WAKEUP, j, pendingIntent);
        }
        setBootReceiverEnabled(1);
    }

    public void schedulePendingIntent(long j, PendingIntent pendingIntent, long j2) {
        Log.d(TAG, "schedulePendingIntent: " + j + "/" + pendingIntent);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            Log.d(TAG, "setExactAndAllowWhileIdle");
            this.alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, j + j2, pendingIntent);
        } else if (i >= 19) {
            Log.d(TAG, "setExact");
            this.alarmManager.setExact(AlarmManager.RTC_WAKEUP, j + j2, pendingIntent);
        } else {
            Log.d(TAG, "set");
            this.alarmManager.set(AlarmManager.RTC_WAKEUP, j + j2, pendingIntent);
        }
        setBootReceiverEnabled(1);
    }

    public void unschedulePendingIntent() {
        PendingIntent pendingIntent = getPendingIntent();
        pendingIntent.cancel();
        this.alarmManager.cancel(pendingIntent);
    }
}
