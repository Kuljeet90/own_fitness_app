package com.own.fitness.app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.own.fitness.app.activities.SuperMainActivity;
import com.own.fitness.app.aputils.CommonMethods;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class NotificationReceiver extends BroadcastReceiver {

     SharedPreferences f829a;
     String b;
     CommonMethods c;
     Context context;


     String d;
     String e;
     Target target = new Target() {


        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            try {
                ((NotificationManager) NotificationReceiver.this.context.getSystemService(Context.NOTIFICATION_SERVICE))
                        .notify(100, new NotificationCompat.Builder(NotificationReceiver.this.context, "reminder_notification")
                                .setContentIntent(PendingIntent.getActivity(NotificationReceiver.this.context,
                                        100, new Intent(NotificationReceiver.this.context, SuperMainActivity.class), 134217728))
                                .setSmallIcon(R.drawable.small_noti_icon)
                                .setContentTitle(String.valueOf(R.string.noti1))
                                .setContentText(NotificationReceiver.this.d)
                                .setStyle(new NotificationCompat.BigPictureStyle()
                                        .bigPicture(bitmap).setBigContentTitle("Hi guys! Let's start")
                                        .setSummaryText(NotificationReceiver.this.e))
                                .setAutoCancel(true).build());
            } catch (Exception exx) {
                exx.printStackTrace();
            }
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            try {
                ((NotificationManager) NotificationReceiver.this.context.getSystemService(Context.NOTIFICATION_SERVICE))
                        .notify(100, new NotificationCompat.Builder(NotificationReceiver.this.context,
                                "reminder_notification")
                                .setContentIntent(PendingIntent.getActivity(NotificationReceiver.this.context, 100,
                                        new Intent(NotificationReceiver.this.context, SuperMainActivity.class), 134217728))
                                .setSmallIcon(R.drawable.small_noti_icon)
                                .setContentTitle(String.valueOf(R.string.noti1))
                                .setVibrate(new long[]{0, 1000, 500, 1000})
                                .setContentText(NotificationReceiver.this.d)
                                .setAutoCancel(true).build());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        public void onPrepareLoad(Drawable drawable) {
            Log.d("", "Hello");
        }
    };

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("reminder_notification", "Reminder Notification", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Include all the notifications");
            ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(notificationChannel);
        }
    }


    private void setLocalNotification() {
        String title = context.getString(R.string.noti4);
        String content = context.getString(R.string.noti1);

        Bitmap decodeResource = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.notification_banner);
        ((NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(100, new NotificationCompat.Builder(this.context, "reminder_notification")
                        .setContentIntent(PendingIntent.getActivity(this.context, 100, new Intent(this.context, SuperMainActivity.class), 134217728))
                        .setSmallIcon(R.drawable.small_noti_icon)
                        .setContentTitle(title)
                        .setContentText(content)
                        .setVibrate(new long[]{0, 1000, 500, 1000})
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(decodeResource).setBigContentTitle(title)
                                .setSummaryText(content)).setAutoCancel(true).build());
    }

    public void onReceive(Context context, Intent intent) {
        this.context = context;
        this.c = new CommonMethods(context);
        this.f829a = PreferenceManager.getDefaultSharedPreferences(context);
        this.b = this.f829a.getString("languageToLoad", "en");
        this.c.updateLocale(this.b);
        createNotificationChannel(context);
        setLocalNotification();

    }


}
