package com.own.fitness.app.all_about_men.database.sortnameclass;

import android.app.Dialog;
import android.view.View;
import com.own.fitness.app.all_about_men.database.activity.MainExcerciseActivityNew1;

public final  class l implements View.OnClickListener {


    private final  MainExcerciseActivityNew1 f16a;
    private final  Dialog b;

    public  l(MainExcerciseActivityNew1 mainExcerciseActivityNew, Dialog dialog) {
        this.f16a = mainExcerciseActivityNew;
        this.b = dialog;
    }

    public final void onClick(View view) {
        this.f16a.a(this.b);
    }
}
