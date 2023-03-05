package com.own.fitness.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.own.fitness.app.alarm.alarm_pojo_classes.Reminder_custom;
import com.own.fitness.app.alarm.alarmmanagerdemo.AlarmHelper;
import com.own.fitness.app.alarm.alarmmanagerdemo.NotificationPublisher;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class FemaleFitnessBootReceiver extends BroadcastReceiver {
     static final int REQUEST_CODE = 1234;
     static final String TAG = FemaleFitnessBootReceiver.class.getSimpleName();
     AlarmHelper alarmHelper;
     Context context;
     SharedPreferences sharedPreferences;
     SimpleDateFormat startTimeFormat;

    private PendingIntent getPendingIntent() {
        Intent intent = new Intent("com.own.workout.pro.alarmmanagerdemo.NOTIFY_ACTION");
        intent.setClass(this.context, NotificationPublisher.class);
        intent.setFlags(268435456);
        return PendingIntent.getBroadcast(this.context, 1234, intent, 134217728);
    }

    private void setBootReceiverEnabled(int i) {
        Log.d(TAG, "setBootReceiverEnabled: ");
        this.context.getPackageManager().setComponentEnabledSetting(new ComponentName(this.context, FemaleFitnessBootReceiver.class), i, 1);
    }

    public void a(int i, int i2, int i3) {
        Log.d(TAG, "schedulePendingIntent: ");
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, i);
        instance.set(Calendar.MINUTE, i2);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        instance.set(Calendar.AM_PM, i3);
        a(instance.getTimeInMillis(), getPendingIntent());
    }

    public void a(long j, PendingIntent pendingIntent) {
        String str = TAG;
        Log.d(str, "scheduling_PendingIntent: " + j + "/" + pendingIntent);
        AlarmManager alarmManager = (AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            Log.d(TAG, "setExactAndAllowWhileIdle");
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, j, pendingIntent);
        } else if (i >= 19) {
            Log.d(TAG, "setExact");
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, j, pendingIntent);
        } else {
            Log.d(TAG, "set");
            alarmManager.set(AlarmManager.RTC_WAKEUP, j, pendingIntent);
        }
        setBootReceiverEnabled(1);
    }

    public void a(Calendar calendar) {
        int i;
        int i2;
        int i3;
        String str = TAG;
        Log.d(str, "hr" + Integer.parseInt(getHourFormat().format(calendar.getTime())));
        String str2 = TAG;
        Log.d(str2, "min" + Integer.parseInt(getMinuteFormat().format(calendar.getTime())));
        if (timeformet().format(calendar.getTime()).endsWith("AM")) {
            Log.d(TAG, "am");
            i2 = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            i = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i3 = 0;
        } else {
            Log.d(TAG, "pm");
            i2 = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            i = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i3 = 1;
        }
        a(i2, i, i3);
    }

    public SimpleDateFormat getHourFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh");
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }

    public SimpleDateFormat getMinuteFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }

    public void onReceive(Context context2, Intent intent) {
        String str = TAG;
        Log.d(str, "onReceive - Intent Action: " + intent.getAction());
        this.context = context2;
        setAlarm(context2);
    }

    public void setAlarm(Context context2) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
        List list = (List) new Gson().fromJson(this.sharedPreferences.getString("Reminder_customObjectList", (String) null), new TypeToken<List<Reminder_custom>>() {
        }.getType());
        if (list != null) {
            this.alarmHelper = new AlarmHelper(context2);
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
            for (int i = 0; i < list.size(); i++) {
                try {
                    instance.setTime(simpleDateFormat.parse(((Reminder_custom) list.get(i)).gettime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String str = TAG;
                Log.d(str, "setAlarm: hr===" + instance.get(Calendar.HOUR) + "min==" + instance.get(Calendar.MINUTE));
                a(instance);
            }
        }
    }

    public SimpleDateFormat timeformet() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }
}
