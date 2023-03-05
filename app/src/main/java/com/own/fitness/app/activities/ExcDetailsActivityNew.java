package com.own.fitness.app.activities;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.getkeepsafe.android.multistateanimation.MultiStateAnimation;
import com.google.android.material.appbar.AppBarLayout;
import com.own.fitness.app.R;
import com.own.fitness.app.database.DatabaseOperations;
import com.own.fitness.app.allads.AdmobAds;
import com.travijuu.numberpicker.library.NumberPicker;

import org.json.JSONException;
import org.json.JSONObject;

public class ExcDetailsActivityNew extends AppCompatActivity {
    int dayvalue;
    DatabaseOperations databaseOperations;
    String day;
    int editCycle;
    boolean editedValue = false;
    int exercisepos;
    int l;
    TextView m;
    TextView n;
    NumberPicker numpicker;
    Context o;
    AdmobAds p = null;
    MultiStateAnimation.SectionBuilder q;
    MultiStateAnimation r;
    int[] s = {R.array.buttock_cycles, R.array.weightloss_cycles, R.array.abs_cycles, R.array.fatburn_cycles, R.array.morning_cycle, R.array.evening_cycle};


    public String createJsonArray(String str) {
        String valueOf = null;
        int i = 0;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        int[] intArray = getResources().getIntArray(this.s[this.dayvalue - 1]);
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 0;
        for (int i3 : intArray) {
            try {
                if (this.exercisepos == i2) {
                    valueOf = String.valueOf(this.exercisepos);

                    i = this.editCycle;
                } else if (jSONObject == null || !jSONObject.has(String.valueOf(i2))) {
                    jSONObject2.put(String.valueOf(i2), i3);
                    i2++;
                } else {
                    valueOf = String.valueOf(i2);
                    i = jSONObject.getInt(String.valueOf(i2));
                }
                jSONObject2.put(valueOf, i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            i2++;
        }
        Log.e("TAG", "json str: " + jSONObject2.toString());
        return jSONObject2.toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e("TAG", " exc details onbackpress saved");
        DatabaseOperations databaseOperations2 = this.databaseOperations;
        String str = this.day;
        databaseOperations2.insertExcCycles(str, createJsonArray(databaseOperations2.getDayExcCycles(str)));
        if (this.editedValue) {
            Toast.makeText(getApplicationContext(), "Exercise cycles are updated.", Toast.LENGTH_SHORT).show();
        }
        this.editedValue = false;
    }

    AppBarLayout appBarLayout;
    Button decrement;
    EditText display;
    Button increment;


    @Override
    public void onCreate(@Nullable Bundle bundle) {
        TextView textView;
        int i;
        Resources resources;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.exc_details_layout_new);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.women_color));

        decrement= (Button) findViewById(R.id.decrement);
        decrement.setBackgroundColor(getResources().getColor(R.color.women_color));

        display= (EditText) findViewById(R.id.display);
        display.setBackgroundColor(getResources().getColor(R.color.women_color));

        increment= (Button) findViewById(R.id.increment);
        increment.setBackgroundColor(getResources().getColor(R.color.women_color));

        this.o = this;
        Bundle extras = getIntent().getExtras();
        int[] intArray = extras.getIntArray("framesIdArray");
        String string = extras.getString("excName");
        int i2 = extras.getInt("excCycle");
        this.l = extras.getInt("excNameDescResId");
        this.day = extras.getString("day", "");
        Log.d("TAG", "EXc = " + string + "    Day = " + this.day);
        this.dayvalue = Integer.parseInt(this.day.replaceAll("[^0-9]", ""));
        this.exercisepos = extras.getInt("excPosition");
        Log.e("TAG", "exercise position " + this.exercisepos);
        this.l = ((Integer) getIntent().getSerializableExtra("excNameDescResId")).intValue();
        this.q = new MultiStateAnimation.SectionBuilder("loading");
        this.databaseOperations = new DatabaseOperations(this);
        String upperCase = string.replace("_", " ").toUpperCase();
        Toolbar toolbar = (Toolbar) findViewById(R.id.exc_details_layout_mtoolbar);
        ((TextView) toolbar.findViewById(R.id.exc_details_layout_toolbar_title)).setText(upperCase);
        toolbar.setNavigationOnClickListener(view -> {
            DatabaseOperations b = ExcDetailsActivityNew.this.databaseOperations;
            String a2 = ExcDetailsActivityNew.this.day;
            ExcDetailsActivityNew excDetailsActivityNew = ExcDetailsActivityNew.this;
            b.insertExcCycles(a2, excDetailsActivityNew.createJsonArray(excDetailsActivityNew.databaseOperations.getDayExcCycles(ExcDetailsActivityNew.this.day)));
            if (ExcDetailsActivityNew.this.editedValue) {
                Toast.makeText(ExcDetailsActivityNew.this.getApplicationContext(), "Excercise cycles are updated.", Toast.LENGTH_SHORT).show();
            }

            ExcDetailsActivityNew.this.editedValue = false;
            ExcDetailsActivityNew.this.finish();
        });
        this.m = (TextView) findViewById(R.id.description_exDetail);
        ImageView imageView = (ImageView) findViewById(R.id.animation_exDetail);
        for (int addFrame : intArray) {
            this.q.addFrame(addFrame);
        }
        this.q.setOneshot(false);
        this.q.setFrameDuration(1000);
        this.r = new MultiStateAnimation.Builder(imageView).addSection(this.q).build(this);
        this.r.transitionNow("loading");
        this.m.setText(this.l);
        this.p = new AdmobAds(this.o, (LinearLayout) findViewById(R.id.nativeAdContainer));
        this.p.refreshAd(getString(R.string.AdMob_Native_ID));
        this.n = (TextView) findViewById(R.id.numberpicker_cycles);
        if (intArray.length < 2) {
            textView = this.n;
            resources = getResources();
            i = R.string.seconds_text;
        } else {
            textView = this.n;
            resources = getResources();
            i = R.string.cycles_text;
        }
        textView.setText(resources.getString(i));
        this.numpicker = (NumberPicker) findViewById(R.id.number_picker);
        this.numpicker.setMax(100);
        this.numpicker.setMin(5);
        this.numpicker.setValue(i2);
        this.editCycle = i2;
        this.numpicker.setValueChangedListener((i1, actionEnum) -> {
            ExcDetailsActivityNew.this.editCycle = i1;
            ExcDetailsActivityNew.this.editedValue = true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
