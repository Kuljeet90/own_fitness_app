package com.own.fitness.app.alarm.alarm_activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.own.fitness.app.R;
import com.own.fitness.app.alarm.alarm_fragments.ReminderFragment;

public class AlarmMainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.alarm_activity_main);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.sample_content_fragment, new ReminderFragment());
            beginTransaction.commit();
        }
    }
}
