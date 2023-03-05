package com.own.fitness.app.sortnameclass.d;

import android.speech.tts.TextToSpeech;
import com.own.fitness.app.aputils.AbsWomenApplication;


public final  class b implements TextToSpeech.OnInitListener {


    private final  AbsWomenApplication f44a;

    public  b(AbsWomenApplication absWomenApplication) {
        this.f44a = absWomenApplication;
    }

    public final void onInit(int i) {
        this.f44a.a(i);
    }
}
