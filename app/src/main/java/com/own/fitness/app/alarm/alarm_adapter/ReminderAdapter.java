package com.own.fitness.app.alarm.alarm_adapter;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.own.fitness.app.R;
import com.own.fitness.app.alarm.alarm_pojo_classes.Reminder_custom;
import com.own.fitness.app.alarm.alarmmanagerdemo.AlarmHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ProductViewHolder> {
    AlarmHelper alarmHelper;
    Gson gson;
    Context mCtx;
    long mLastClickTime = 0;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor prefsEditor;
    List<Reminder_custom> productList;
    Reminder_custom reminderproduct;

    public class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView f793a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;
        ImageView i;
        Switch j;

        public ProductViewHolder(View view) {
            super(view);
            this.f793a = view.findViewById(R.id.time);
            this.b = view.findViewById(R.id.day1);
            this.c = view.findViewById(R.id.day2);
            this.d = view.findViewById(R.id.day3);
            this.e = view.findViewById(R.id.day4);
            this.f = view.findViewById(R.id.day5);
            this.g = view.findViewById(R.id.day6);
            this.h = view.findViewById(R.id.day7);
            this.i = view.findViewById(R.id.timedelete);
            this.j = view.findViewById(R.id.timeswitch);
        }
    }

    public ReminderAdapter(Context context, List<Reminder_custom> list, Gson gson2, SharedPreferences sharedPreferences, SharedPreferences.Editor editor, AlarmHelper alarmHelper2) {
        this.mCtx = context;
        this.productList = list;
        this.mSharedPreferences = sharedPreferences;
        this.prefsEditor = editor;
        this.gson = gson2;
        this.alarmHelper = alarmHelper2;
    }


    public void showTimePickerDialog(final Reminder_custom remindercustom, final int i) {
        Calendar instance = Calendar.getInstance();
        new TimePickerDialog(this.mCtx, (timePicker, i1, i2) -> {
            if (timePicker.isShown()) {
                Calendar instance1 = Calendar.getInstance();
                instance1.set(Calendar.HOUR_OF_DAY, i1);
                instance1.set(Calendar.MINUTE, i2);
                ReminderAdapter.this.showDialog(instance1, remindercustom, i1);
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

    public int getItemCount() {
        return this.productList.size();
    }

    public SimpleDateFormat getMinuteFormat() {
        return new SimpleDateFormat("mm");
    }


    public void onBindViewHolder(final ProductViewHolder productViewHolder, int i) {
        this.reminderproduct = this.productList.get(i);
        productViewHolder.f793a.setText(this.reminderproduct.gettime());
        productViewHolder.f793a.setOnClickListener(view -> {
            ReminderAdapter reminderAdapter = ReminderAdapter.this;
            reminderAdapter.reminderproduct = reminderAdapter.productList.get(productViewHolder.getAdapterPosition());
            ReminderAdapter reminderAdapter2 = ReminderAdapter.this;
            reminderAdapter2.showTimePickerDialog(reminderAdapter2.reminderproduct, productViewHolder.getAdapterPosition());
        });
        productViewHolder.b.setVisibility(View.VISIBLE);
        productViewHolder.c.setVisibility(View.VISIBLE);
        productViewHolder.d.setVisibility(View.VISIBLE);
        productViewHolder.e.setVisibility(View.VISIBLE);
        productViewHolder.f.setVisibility(View.VISIBLE);
        productViewHolder.g.setVisibility(View.VISIBLE);
        productViewHolder.h.setVisibility(View.VISIBLE);
        if (this.reminderproduct.getMon()) {
            productViewHolder.b.setText(this.mCtx.getResources().getString(R.string.monday));
        } else {
            productViewHolder.b.setVisibility(View.GONE);
        }
        if (this.reminderproduct.getTue()) {
            productViewHolder.c.setText(this.mCtx.getResources().getString(R.string.tu));
        } else {
            productViewHolder.c.setVisibility(View.GONE);
        }
        if (this.reminderproduct.getWen()) {
            productViewHolder.d.setText(this.mCtx.getResources().getString(R.string.wed));
        } else {
            productViewHolder.d.setVisibility(View.GONE);
        }
        if (this.reminderproduct.getThr()) {
            productViewHolder.e.setText(this.mCtx.getResources().getString(R.string.thursday));
        } else {
            productViewHolder.e.setVisibility(View.GONE);
        }
        if (this.reminderproduct.getFri()) {
            productViewHolder.f.setText(this.mCtx.getResources().getString(R.string.fri));
        } else {
            productViewHolder.f.setVisibility(View.GONE);
        }
        if (this.reminderproduct.getSat()) {
            productViewHolder.g.setText(this.mCtx.getResources().getString(R.string.sat));
        } else {
            productViewHolder.g.setVisibility(View.GONE);
        }
        if (this.reminderproduct.getSun()) {
            productViewHolder.h.setText(this.mCtx.getResources().getString(R.string.sun));
        } else {
            productViewHolder.h.setVisibility(View.GONE);
        }
        productViewHolder.j.setChecked(this.reminderproduct.getOnoff());
        productViewHolder.j.setOnCheckedChangeListener((compoundButton, z) -> {
            ReminderAdapter reminderAdapter = ReminderAdapter.this;
            reminderAdapter.reminderproduct = reminderAdapter.productList.get(productViewHolder.getAdapterPosition());
            ReminderAdapter.this.reminderproduct.setOnoff(z);
            String json = ReminderAdapter.this.gson.toJson(ReminderAdapter.this.productList);
            ReminderAdapter reminderAdapter2 = ReminderAdapter.this;
            reminderAdapter2.prefsEditor = reminderAdapter2.mSharedPreferences.edit();
            ReminderAdapter.this.prefsEditor.putString("Reminder_customObjectList", json);
            ReminderAdapter.this.prefsEditor.apply();
        });
        productViewHolder.i.setOnClickListener(view -> {
            if (SystemClock.elapsedRealtime() - ReminderAdapter.this.mLastClickTime >= 1000) {

                ReminderAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
                ReminderAdapter.this.removeAt(productViewHolder.getAdapterPosition());
            }
        });
    }

    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ProductViewHolder(LayoutInflater.from(this.mCtx).inflate(R.layout.layout_remindercustom_row, null));
    }

    public void removeAt(int i) {
        this.productList.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, this.productList.size());
        String json = this.gson.toJson(this.productList);
        this.prefsEditor = this.mSharedPreferences.edit();
        this.prefsEditor.putString("Reminder_customObjectList", json);
        this.prefsEditor.apply();
    }

    public void showDialog(Calendar calendar, Reminder_custom remcustom, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mCtx);
        builder.setTitle(this.mCtx.getResources().getString(R.string.days));
        final ArrayList arrayList = new ArrayList();
        builder.setMultiChoiceItems(this.mCtx.getResources().getStringArray(R.array.day_list), null, (dialogInterface, i1, z) -> {

            if (z) {
                arrayList.add(Integer.valueOf(i1));
            } else arrayList.remove(Integer.valueOf(i1));
        });
        final Reminder_custom remindercustomee = remcustom;
        final Calendar calendar2 = calendar;
        final int i2 = i;
        builder.setPositiveButton(this.mCtx.getString(17039370), (dialogInterface, i12) -> {
            if (arrayList.size() > 0) {
                dialogInterface.dismiss();
                remindercustomee.settime(ReminderAdapter.this.startTimeFormat().format(calendar2.getTime()));
                remindercustomee.setMon(false);
                remindercustomee.setTue(false);
                remindercustomee.setWen(false);
                remindercustomee.setThr(false);
                remindercustomee.setFri(false);
                remindercustomee.setSat(false);
                remindercustomee.setSun(false);
                for (int i21 = 0; i21 < arrayList.size(); i21++) {
                    if (arrayList.get(i21).equals(0)) {
                        remindercustomee.setMon(true);
                    } else if (arrayList.get(i21).equals(1)) {
                        remindercustomee.setTue(true);
                    } else if (arrayList.get(i21).equals(2)) {
                        remindercustomee.setWen(true);
                    } else if (arrayList.get(i21).equals(3)) {
                        remindercustomee.setThr(true);
                    } else if (arrayList.get(i21).equals(4)) {
                        remindercustomee.setFri(true);
                    } else if (arrayList.get(i21).equals(5)) {
                        remindercustomee.setSat(true);
                    } else if (arrayList.get(i21).equals(6)) {
                        remindercustomee.setSun(true);
                    }
                }
                remindercustomee.setOnoff(true);
                ReminderAdapter reminderAdapter = ReminderAdapter.this;
                reminderAdapter.a(reminderAdapter.alarmHelper, calendar2);
                String json = ReminderAdapter.this.gson.toJson(ReminderAdapter.this.productList);
                ReminderAdapter reminderAdapter2 = ReminderAdapter.this;

                reminderAdapter2.prefsEditor = reminderAdapter2.mSharedPreferences.edit();
                ReminderAdapter.this.prefsEditor.putString("Reminder_customObjectList", json);
                ReminderAdapter.this.prefsEditor.apply();
                ReminderAdapter.this.notifyItemChanged(i2);
                ReminderAdapter reminderAdapter3 = ReminderAdapter.this;
                reminderAdapter3.notifyItemRangeChanged(i2, reminderAdapter3.productList.size());
                return;
            }
            Toast.makeText(ReminderAdapter.this.mCtx, ReminderAdapter.this.mCtx.getResources().getString(R.string.please_select_at_least_one_day), Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton(this.mCtx.getString(17039360), (dialogInterface, i13) -> dialogInterface.dismiss());
        builder.create().show();
    }

    public SimpleDateFormat startTimeFormat() {
        return new SimpleDateFormat("hh:mm a");
    }
}
