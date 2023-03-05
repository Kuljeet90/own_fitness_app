package com.own.fitness.app.all_about_men.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



import com.own.fitness.app.R;
import com.own.fitness.app.adapters.WorkoutData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations1 {


    public int[] f801a = {R.array.buttock_cycles1, R.array.weightloss_cycles1, R.array.abs_cycles1, R.array.fatburn_cycles1, R.array.morning_cycle1, R.array.evening_cycle1};
    public int[] b;
    public Context c;
    public DatabaseHelper1 dbHelper;
    public SQLiteDatabase sqlite;



    public DatabaseOperations1(Context context) {
        this.dbHelper = new DatabaseHelper1(context);
        this.c = context;
    }

    public int CheckDBEmpty() {
        this.sqlite = this.dbHelper.getReadableDatabase();
        Cursor rawQuery = this.sqlite.rawQuery("SELECT count(*) FROM " + DatabaseHelper1.f, (String[]) null);
        rawQuery.moveToFirst();
        return rawQuery.getInt(0) > 0 ? 1 : 0;
    }

    public int deleteTable() {
        this.sqlite = this.dbHelper.getWritableDatabase();
        int delete = this.sqlite.delete(DatabaseHelper1.f, (String) null, (String[]) null);
        this.sqlite.close();
        return delete;
    }

    public List<WorkoutData> getAllDaysProgress() {
        ArrayList arrayList = new ArrayList();
        this.sqlite = this.dbHelper.getReadableDatabase();
        try {
            if (this.sqlite != null) {
                SQLiteDatabase sQLiteDatabase = this.sqlite;
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + DatabaseHelper1.f, (String[]) null);
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        WorkoutData workoutData = new WorkoutData();
                        workoutData.setDay(rawQuery.getString(rawQuery.getColumnIndex(DatabaseHelper1.g)));
                        workoutData.setProgress(rawQuery.getFloat(rawQuery.getColumnIndex(DatabaseHelper1.h)));
                        rawQuery.moveToNext();
                        arrayList.add(workoutData);
                    }
                }
                this.sqlite.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public int getDayExcCounter(String str) {
        this.sqlite = this.dbHelper.getReadableDatabase();
        SQLiteDatabase sQLiteDatabase = this.sqlite;
        int i = 0;
        if (sQLiteDatabase != null) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + DatabaseHelper1.f + " where " + DatabaseHelper1.g + " = '" + str + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(rawQuery.getColumnIndex(DatabaseHelper1.i));
            }
            this.sqlite.close();
        }
        return i;
    }

    public String getDayExcCycles(String str) {
        this.sqlite = this.dbHelper.getReadableDatabase();
        SQLiteDatabase sQLiteDatabase = this.sqlite;
        String str2 = "";
        if (sQLiteDatabase != null) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + DatabaseHelper1.f + " where " + DatabaseHelper1.g + " = '" + str + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(rawQuery.getColumnIndex(DatabaseHelper1.j));
            }
            this.sqlite.close();
        }
        return str2;
    }

    public float getExcDayProgress(String str) {
        Log.d("DatabaseCheck", "Database Operations " + str);
        this.sqlite = this.dbHelper.getReadableDatabase();
        SQLiteDatabase sQLiteDatabase = this.sqlite;
        float f = 0.0f;
        if (sQLiteDatabase != null) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + DatabaseHelper1.f + " where " + DatabaseHelper1.g + " = '" + str + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                f = rawQuery.getFloat(rawQuery.getColumnIndex(DatabaseHelper1.h));
            }
            this.sqlite.close();
        }
        return f;
    }

    public long insertExcALLDayData() {
        long j = 0;
        try {
            this.sqlite = this.dbHelper.getWritableDatabase();
            for (int i = 1; i <= 6; i++) {
                JSONObject jSONObject = new JSONObject();
                this.b = this.c.getResources().getIntArray(this.f801a[i - 1]);
                int i2 = 0;
                for (int put : this.b) {
                    try {
                        jSONObject.put(String.valueOf(i2), put);
                        i2++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.e("TAG", "json str databs123: " + jSONObject.toString());
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper1.g, "Day " + i);
                contentValues.put(DatabaseHelper1.h, Double.valueOf(0.0d));
                contentValues.put(DatabaseHelper1.i, 0);
                contentValues.put(DatabaseHelper1.j, jSONObject.toString());
                if (this.sqlite != null) {
                    try {
                        j = this.sqlite.insert(DatabaseHelper1.f, (String) null, contentValues);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            this.sqlite.close();
        }
        return j;
    }

    public int insertExcCounter(String str, int i) {
        int i2 = 0;
        try {
            this.sqlite = this.dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper1.i, Integer.valueOf(i));

            if (this.sqlite != null) {
                try {
                   i2 = this.sqlite.update(DatabaseHelper1.f, contentValues, DatabaseHelper1.g + "='" + str + "'", (String[]) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.sqlite.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.sqlite.close();
        }
        return i2;
    }

    public int insertExcCycles(String str, String str2) {
        Log.d("DatabaseCheck", "insertExcCycles " + str);
        int i = 0;
        try {
            this.sqlite = this.dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper1.j, str2);
            if (this.sqlite != null) {
                try {
                    i = this.sqlite.update(DatabaseHelper1.f, contentValues, DatabaseHelper1.g + "='" + str + "'", (String[]) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.sqlite.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.sqlite.close();
        }
        return i;
    }

    public int insertExcDayData(String str, float f) {
        int i = 0;
        try {
            this.sqlite = this.dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper1.h, Float.valueOf(f));
            if (this.sqlite != null) {
                try {
                    SQLiteDatabase sQLiteDatabase = this.sqlite;
                    String str2 = DatabaseHelper1.f;
                    i = sQLiteDatabase.update(str2, contentValues, DatabaseHelper1.g + "='" + str + "'", (String[]) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.sqlite.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.sqlite.close();
        }
        return i;
    }
}
