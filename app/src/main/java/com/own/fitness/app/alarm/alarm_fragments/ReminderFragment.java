package com.own.fitness.app.alarm.alarm_fragments;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.own.fitness.app.R;
import com.own.fitness.app.alarm.alarm_adapter.ReminderAdapter;
import com.own.fitness.app.alarm.alarm_pojo_classes.Reminder_custom;
import com.own.fitness.app.alarm.alarmmanagerdemo.AlarmHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReminderFragment extends Fragment {
    static final String TAG = "ReminderFragment";
    AlarmHelper alarmHelper;
    Gson gson;
    ReminderAdapter mAdapter;
    List mReCu;
    RecyclerView mRecyclerView;
    SharedPreferences mSharedPreferences;
    TextView noreminders;
    SharedPreferences.Editor prefsEditor;


    public void showTimePickerDialog() {
        Calendar instance = Calendar.getInstance();
        new TimePickerDialog(getActivity(), (timePicker, i, i2) -> {
            if (timePicker.isShown()) {
                Calendar instance1 = Calendar.getInstance();
                instance1.set(Calendar.HOUR_OF_DAY, i);
                instance1.set(Calendar.MINUTE, i2);
                Log.d(ReminderFragment.TAG, "onTimeSet: " + ReminderFragment.this.startTimeFormat().format(instance1.getTime()));
                ReminderFragment.this.showDialog(instance1);
            }
        }, instance.get(Calendar.HOUR_OF_DAY), instance.get(Calendar.MINUTE), false).show();
    }

    public void a(AlarmHelper alarmHelper2, Calendar calendar) {
        int i;
        int i2;
        int i3;
        if (startTimeFormat().format(calendar.getTime()).endsWith("AM")) {
            i3 = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            i = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i2 = 0;
        } else {
            i3 = Integer.parseInt(getHourFormat().format(calendar.getTime()));
            i = Integer.parseInt(getMinuteFormat().format(calendar.getTime()));
            i2 = 1;
        }
        alarmHelper2.schedulePendingIntent(i3, i, i2);
    }

    public SimpleDateFormat getHourFormat() {
        return new SimpleDateFormat("hh");
    }

    public SimpleDateFormat getMinuteFormat() {
        return new SimpleDateFormat("mm");
    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_reminderfragment, viewGroup, false);
        inflate.setTag(TAG);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon((int) R.drawable.back_pink);
        toolbar.setNavigationOnClickListener(view -> ReminderFragment.this.getActivity().finish());
        setHasOptionsMenu(true);
        this.alarmHelper = new AlarmHelper(getActivity());
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.reminderlist);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.noreminders = (TextView) inflate.findViewById(R.id.noreminder);
        this.gson = new Gson();
        this.mReCu = (List) this.gson.fromJson(this.mSharedPreferences.getString("Reminder_customObjectList",
                (String) null), new TypeToken<List<Reminder_custom>>() {


        }.getType());
        List<Reminder_custom> list = this.mReCu;
        if (list == null || list.size() <= 0) {
            this.mRecyclerView.setVisibility(View.GONE);
            this.noreminders.setVisibility(View.VISIBLE);
        } else {
            this.mRecyclerView.setVisibility(View.VISIBLE);
            this.mAdapter = new ReminderAdapter(getActivity(), this.mReCu, this.gson, this.mSharedPreferences, this.prefsEditor, this.alarmHelper);
            this.mRecyclerView.setAdapter(this.mAdapter);
            this.noreminders.setVisibility(View.GONE);
        }
        ((FloatingActionButton) inflate.findViewById(R.id.addreminder)).setOnClickListener(view -> ReminderFragment.this.showTimePickerDialog());
        return inflate;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void showDialog(final Calendar calendar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getContext().getResources().getString(R.string.days));
        final ArrayList arrayList = new ArrayList();
        builder.setMultiChoiceItems(getResources()
                .getStringArray(R.array.day_list), (boolean[]) null, (dialogInterface, i, z) -> {

            if (z) {

                arrayList.add(Integer.valueOf(i));

            } else if (arrayList.contains(Integer.valueOf(i))) {
                arrayList.remove(Integer.valueOf(i));
            }
        });
        builder.setPositiveButton(getString(17039370), (dialogInterface, i) -> {
            if (arrayList.size() > 0) {
                dialogInterface.dismiss();
                Reminder_custom remcustom = new Reminder_custom();
                remcustom.settime(ReminderFragment.this.startTimeFormat().format(calendar.getTime()));
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (((Integer) arrayList.get(i2)).equals(0)) {
                        remcustom.setMon(true);
                    } else if (((Integer) arrayList.get(i2)).equals(1)) {
                        remcustom.setTue(true);
                    } else if (((Integer) arrayList.get(i2)).equals(2)) {
                        remcustom.setWen(true);
                    } else if (((Integer) arrayList.get(i2)).equals(3)) {
                        remcustom.setThr(true);
                    } else if (((Integer) arrayList.get(i2)).equals(4)) {
                        remcustom.setFri(true);
                    } else if (((Integer) arrayList.get(i2)).equals(5)) {
                        remcustom.setSat(true);
                    } else if (((Integer) arrayList.get(i2)).equals(6)) {
                        remcustom.setSun(true);
                    }
                }
                ReminderFragment reminderFragment = ReminderFragment.this;
                reminderFragment.a(reminderFragment.alarmHelper, calendar);
                remcustom.setOnoff(true);
                if (ReminderFragment.this.mReCu == null || ReminderFragment.this.mReCu.size() <= 0) {
                    ReminderFragment.this.mReCu = new ArrayList();
                }
                ReminderFragment.this.mReCu.add(remcustom);
                String json = ReminderFragment.this.gson.toJson((Object) ReminderFragment.this.mReCu);
                ReminderFragment reminderFragment2 = ReminderFragment.this;
                reminderFragment2.prefsEditor = reminderFragment2.mSharedPreferences.edit();
                ReminderFragment.this.prefsEditor.putString("Reminder_customObjectList", json);
                ReminderFragment.this.prefsEditor.apply();
                ReminderFragment.this.mRecyclerView.setVisibility(View.VISIBLE);
                ReminderFragment reminderFragment3 = ReminderFragment.this;
                reminderFragment3.mAdapter = new ReminderAdapter(reminderFragment3.getActivity(), ReminderFragment.this.mReCu, ReminderFragment.this.gson, ReminderFragment.this.mSharedPreferences, ReminderFragment.this.prefsEditor, ReminderFragment.this.alarmHelper);
                ReminderFragment.this.mRecyclerView.setAdapter(ReminderFragment.this.mAdapter);
                ReminderFragment.this.noreminders.setVisibility(View.GONE);
                return;
            }
            Toast.makeText(ReminderFragment.this.getActivity(), ReminderFragment.this.getContext().getResources().getString(R.string.please_select_at_least_one_day), Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton(getString(17039360), (dialogInterface, i) -> dialogInterface.dismiss());
        builder.create().show();
    }

    public SimpleDateFormat startTimeFormat() {
        return new SimpleDateFormat("hh:mm a");
    }
}
