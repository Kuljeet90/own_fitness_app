package com.own.fitness.app.all_about_men.database.sortnameclass;

import android.app.Dialog;
import android.view.View;

import com.own.fitness.app.all_about_men.database.activity.MainExcerciseActivityNew1;


public final  class n implements View.OnClickListener {


    private final  MainExcerciseActivityNew1 f18a;
    private final  Dialog b;

    public  n(MainExcerciseActivityNew1 mainExcerciseActivityNew, Dialog dialog) {
        this.f18a = mainExcerciseActivityNew;
        this.b = dialog;
    }

    public final void onClick(View view) {
        this.f18a.b(this.b);
    }
}
