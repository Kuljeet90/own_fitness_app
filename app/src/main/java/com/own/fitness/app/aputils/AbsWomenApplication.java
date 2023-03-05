package com.own.fitness.app.aputils;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.own.fitness.app.R;
import com.own.fitness.app.sortnameclass.d.a;
import com.own.fitness.app.sortnameclass.d.b;

import java.util.HashMap;
import java.util.Locale;

public class AbsWomenApplication extends Application {
    static AbsWomenApplication absWomenApplication;

    TextToSpeech textToSpeech;

    public static AbsWomenApplication getInstance() {
        return absWomenApplication;
    }


    public void a() {
        if (this.textToSpeech == null) {
            this.textToSpeech = new TextToSpeech(getInstance(), new b(this));
        }
    }

    public void a(int i) {
        if (i == 0) {
            this.textToSpeech.setLanguage(Locale.US);
        }
    }

    public void addEarCorn() {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.addEarcon("tick", "com.own.workout.pro", R.raw.clocktick_trim);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        absWomenApplication = this;
        new Thread(new a(this)).start();
    }

    public void playEarCorn() {
        try {
            if (this.textToSpeech == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.textToSpeech.playEarcon("tick", 0, (Bundle) null, "com.own.workout.pro");
            } else {
                this.textToSpeech.playEarcon("tick", 0, (HashMap) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void speak(String str) {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.setSpeechRate(1.0f);
                this.textToSpeech.speak(str, 1, (HashMap) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if (this.textToSpeech != null) {
                this.textToSpeech.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
