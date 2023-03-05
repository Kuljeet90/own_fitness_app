package com.own.fitness.app.alarm.alarmmanagerdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.own.fitness.app.R;
import com.own.fitness.app.activities.SuperMainActivity;
import com.own.fitness.app.alarm.alarm_pojo_classes.Reminder_custom;
import com.own.fitness.app.aputils.CommonMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class NotificationPublisher extends BroadcastReceiver {
     static final String PREFERENCE_LAST_NOTIF_ID = "PREFERENCE_LAST_NOTIF_ID";
     String TAG = "NotificationPublisher";


     List<Reminder_custom> f799a;
     AlarmHelper alarmHelper;
     Context context;
     SharedPreferences sharedPreferences;
     SimpleDateFormat startTimeFormat;




    private int getNextNotifId() {
        int i = this.sharedPreferences.getInt(PREFERENCE_LAST_NOTIF_ID, 0) + 1;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        this.sharedPreferences.edit().putInt(PREFERENCE_LAST_NOTIF_ID, i).apply();
        return i;
    }


    private void startNotification(Context context2) {
        new CommonMethods(context).updateLocale(PreferenceManager.getDefaultSharedPreferences(context).getString("languageToLoad", "en"));

        PendingIntent existAlarm = this.alarmHelper.existAlarm(this.sharedPreferences.getInt(PREFERENCE_LAST_NOTIF_ID, 0));
        if (existAlarm != null) {
            existAlarm.cancel();
        }
        if (Build.VERSION.SDK_INT < 26) {
            String title = context.getString(R.string.noti3);
            String content = context.getString(R.string.noti4);
            Intent intent = new Intent(context2, SuperMainActivity.class);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            ((NotificationManager) context2.getSystemService(Context.NOTIFICATION_SERVICE))
                    .notify(getNextNotifId(), new Notification.Builder(context2)
                            .setContentIntent(PendingIntent.getActivity(context2, getNextNotifId(), intent, 0))
                            .setSmallIcon(R.drawable.small_noti_icon).setAutoCancel(true)
                            .setWhen(System.currentTimeMillis()).setContentTitle(title)
                            .setContentText(content).setDefaults(1).build());
            return;
        }
        String title = context.getString(R.string.noti3);
        String content = context.getString(R.string.noti4);
        Intent intent2 = new Intent(context2, SuperMainActivity.class);
        intent2.setAction("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.addFlags(268435456);
        NotificationManager notificationManager = (NotificationManager) context2.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = new NotificationChannel("my_channel_id_01", "My Notifications", NotificationManager.IMPORTANCE_HIGH);
        notificationChannel.setDescription("Channel description");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
        notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, "my_channel_id_01");

        builder.setAutoCancel(true)
                .setContentIntent(PendingIntent.getActivity(context2, getNextNotifId(), intent2, 0))
                .setDefaults(-1).setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.small_noti_icon)
                .setContentTitle(title)
                .setContentText(content).setDefaults(1);
        notificationManager.notify(getNextNotifId(), builder.build());
    }

    public void a(AlarmHelper alarmHelper2, Calendar calendar) {
        int parseInt;
        int parseInt2;
        int i;
        if (startTimeFormat().format(calendar.getTime()).endsWith("AM")) {
            parseInt = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            parseInt2 = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i = 0;
        } else if (startTimeFormat().format(calendar.getTime()).equalsIgnoreCase("PM")) {
            parseInt = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            parseInt2 = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i = 1;
        } else {
            return;
        }
        alarmHelper2.schedulePendingIntent(parseInt, parseInt2, i, 86400000);
    }

    public SimpleDateFormat getHourFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh", Locale.ENGLISH);
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }

    public SimpleDateFormat getMinuteFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm", Locale.ENGLISH);
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }

    public void onReceive(Context context2, Intent intent) {
        String str = this.TAG;
        Log.d(str, "onReceive ==========" + intent.getAction());
        this.context = context2;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
        Gson gson = new Gson();
        String string = this.sharedPreferences.getString("Reminder_customObjectList", (String) null);
        if (string != null) {
            this.f799a = (List) gson.fromJson(string, new TypeToken<List<Reminder_custom>>() {
            }.getType());
        }
        Calendar instance = Calendar.getInstance();
        instance.get(Calendar.HOUR_OF_DAY);
        instance.get(Calendar.MINUTE);
        int i = instance.get(Calendar.DAY_OF_WEEK);
        List<Reminder_custom> list = this.f799a;
        if (list != null && list.size() > 0) {
            this.alarmHelper = new AlarmHelper(context2);
            for (int i2 = 0; i2 < this.f799a.size(); i2++) {
                if (this.f799a.get(i2).gettime().equals(startTimeFormat().format(instance.getTime())) && this.f799a.get(i2).getOnoff()) {
                    if ((this.f799a.get(i2).getSun() && i == 1) || ((this.f799a.get(i2).getMon() && i == 2) || ((this.f799a.get(i2).getTue() && i == 3) || ((this.f799a.get(i2).getWen() && i == 4) || ((this.f799a.get(i2).getThr() && i == 5) || ((this.f799a.get(i2).getFri() && i == 6) || (this.f799a.get(i2).getSat() && i == 7))))))) {
                        startNotification(context2);
                    }
                    this.alarmHelper = new AlarmHelper(context2);
                    a(this.alarmHelper, instance);
                }
            }
            if (((String) Objects.requireNonNull(intent.getAction())).equals("android.intent.action.TIME_SET")) {
                for (int i3 = 0; i3 < this.f799a.size(); i3++) {
                    String str2 = this.TAG;
                    Log.d(str2, "onReceive: +++++++++++++" + this.f799a.get(i3).gettime());
                    if (this.f799a.get(i3).gettime().toUpperCase().endsWith("AM") || this.f799a.get(i3).gettime().toLowerCase().endsWith("am") || this.f799a.get(i3).gettime().toUpperCase().endsWith("a.m.") || this.f799a.get(i3).gettime().toLowerCase().endsWith("a.m.")) {
                        this.alarmHelper.schedulePendingIntent(Integer.parseInt(this.f799a.get(i3).gettime().substring(0, 2)), Integer.parseInt(this.f799a.get(i3).gettime().substring(3, 5)), 0);
                    } else if (this.f799a.get(i3).gettime().toUpperCase().endsWith("PM") || this.f799a.get(i3).gettime().toUpperCase().endsWith("pm") || this.f799a.get(i3).gettime().toUpperCase().endsWith("p.m.") || this.f799a.get(i3).gettime().toLowerCase().endsWith("p.m.")) {
                        this.alarmHelper.schedulePendingIntent(Integer.parseInt(this.f799a.get(i3).gettime().substring(0, 2)), Integer.parseInt(this.f799a.get(i3).gettime().substring(3, 5)), 1);
                    }
                }
            }
        }
    }

    public SimpleDateFormat startTimeFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        this.startTimeFormat = simpleDateFormat;
        return simpleDateFormat;
    }
}
