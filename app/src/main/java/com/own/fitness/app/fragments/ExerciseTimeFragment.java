package com.own.fitness.app.fragments;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.own.fitness.app.R;
import com.own.fitness.app.aputils.CommonMethods;
import java.util.Objects;

public class ExerciseTimeFragment extends Fragment {


     TimePicker f810a;
     int b;
     int c;
     CommonMethods commonMethods;
     Button d;
     SharedPreferences e;
     String languageToLoad;
     SharedPreferences launchDataPreferences1;
     SharedPreferences.Editor prefsEditor;

     @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.commonMethods = new CommonMethods(activity);
        this.e = PreferenceManager.getDefaultSharedPreferences(activity);
        this.prefsEditor = this.e.edit();
        View inflate = layoutInflater.inflate(R.layout.fragment_exercisetime, viewGroup, false);
        ((Toolbar) inflate.findViewById(R.id.exercisetoolbar)).setNavigationOnClickListener((View.OnClickListener) view -> ((FragmentActivity) Objects.requireNonNull(ExerciseTimeFragment.this.getActivity())).onBackPressed());
        this.f810a = (TimePicker) inflate.findViewById(R.id.datePicker1);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f810a.setHour(this.e.getInt("notification_hour", this.b));
            this.f810a.setMinute(this.e.getInt("notification_minute", this.c));
        }
        this.d = (Button) inflate.findViewById(R.id.set);
        this.d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ExerciseTimeFragment exerciseTimeFragment;
                int i;
                if (Build.VERSION.SDK_INT >= 23) {
                    ExerciseTimeFragment exerciseTimeFragment2 = ExerciseTimeFragment.this;
                    exerciseTimeFragment2.b = exerciseTimeFragment2.f810a.getHour();
                    exerciseTimeFragment = ExerciseTimeFragment.this;
                    i = exerciseTimeFragment.f810a.getMinute();
                } else {
                    ExerciseTimeFragment exerciseTimeFragment3 = ExerciseTimeFragment.this;
                    exerciseTimeFragment3.b = exerciseTimeFragment3.f810a.getCurrentHour().intValue();
                    exerciseTimeFragment = ExerciseTimeFragment.this;
                    i = exerciseTimeFragment.f810a.getCurrentMinute().intValue();
                }
                exerciseTimeFragment.c = i;
                Toast.makeText(ExerciseTimeFragment.this.getActivity(), ExerciseTimeFragment.this.getResources().getString(R.string.time_saved), Toast.LENGTH_SHORT).show();
                ExerciseTimeFragment.this.prefsEditor.putBoolean("user_selection", true);
                ExerciseTimeFragment.this.prefsEditor.putInt("notification_hour", ExerciseTimeFragment.this.b);
                ExerciseTimeFragment.this.prefsEditor.putInt("notification_minute", ExerciseTimeFragment.this.c);
                Log.d("ReminderCheck", "Reminder set in ExerciseFragment page");
                ExerciseTimeFragment.this.prefsEditor.apply();
                StringBuilder sb = new StringBuilder();
                sb.append("Reminder set in ");
                ExerciseTimeFragment exerciseTimeFragment4 = ExerciseTimeFragment.this;
                sb.append(exerciseTimeFragment4.e.getInt("notification_hour", exerciseTimeFragment4.b));
                sb.append(":");
                ExerciseTimeFragment exerciseTimeFragment5 = ExerciseTimeFragment.this;
                sb.append(exerciseTimeFragment5.e.getInt("notification_minute", exerciseTimeFragment5.c));
                sb.append(":");
                sb.append(0);
                Log.d("ReminderCheck", sb.toString());
                CommonMethods b = ExerciseTimeFragment.this.commonMethods;
                ExerciseTimeFragment exerciseTimeFragment6 = ExerciseTimeFragment.this;
                int i2 = exerciseTimeFragment6.e.getInt("notification_hour", exerciseTimeFragment6.b);
                ExerciseTimeFragment exerciseTimeFragment7 = ExerciseTimeFragment.this;
                b.setAlarm(i2, exerciseTimeFragment7.e.getInt("notification_minute", exerciseTimeFragment7.c), 0);
                ExerciseTimeFragment.this.getActivity().onBackPressed();
            }
        });
        return inflate;
    }
}
