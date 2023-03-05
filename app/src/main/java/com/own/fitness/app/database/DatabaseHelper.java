package com.own.fitness.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.own.fitness.app.R;
import org.json.JSONException;
import org.json.JSONObject;

public class DatabaseHelper extends SQLiteOpenHelper {
     static int d = 3;
     static String e = "FitDB";
     static String f = "exc_day";
     static String g = "day";
     static String h = "progress";
     static String i = "counter";
     static String j = "cycles";


     Context f800a;
     int[] b = {R.array.buttock_cycles, R.array.weightloss_cycles, R.array.abs_cycles, R.array.fatburn_cycles, R.array.morning_cycle, R.array.evening_cycle};
     String c = ("CREATE TABLE " + f + " (" + g + " TEXT, " + h + " REAL, " + i + " INTEGER, " + j + " TEXT)");

    public DatabaseHelper(Context context) {
        super(context, e, (SQLiteDatabase.CursorFactory) null, d);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(this.c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Log.i("dbpath: ", "path: " + sQLiteDatabase.getPath());
        if (i2 == 2 || i2 == 3) {
            sQLiteDatabase.execSQL("ALTER TABLE " + f + " ADD COLUMN " + j + " TEXT");
            int i4 = 1;
            while (i4 <= 6) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    int i5 = 0;
                    for (int put : this.f800a.getResources().getIntArray(this.b[i4 - 1])) {
                        try {
                            jSONObject.put(String.valueOf(i5), put);
                            i5++;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    Log.e("TAG", "json str databs: " + jSONObject.toString());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(j, jSONObject.toString());
                    if (sQLiteDatabase != null) {
                        try {
                            String str = f;
                            StringBuilder sb = new StringBuilder();
                            sb.append("res: ");
                            sb.append((long) sQLiteDatabase.update(str, contentValues, g + "='Day " + i4 + "'", (String[]) null));
                            Log.e("TAG", sb.toString());
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    i4++;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
        }
    }
}
