package com.own.fitness.app.alarm.alarmmanagerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PowerConnectedBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "PowerConnectedBroRe";

    public void onReceive(Context context, Intent intent) {
        AlarmHelper alarmHelper = new AlarmHelper(context);
        Log.d(TAG, "PendingIntent.getBroadcast(...) != null: " + alarmHelper.isAlarmScheduled());
    }
}
