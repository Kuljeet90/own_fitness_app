package com.own.fitness.app.sortnameclass.a;

import android.app.Dialog;
import android.view.View;
import com.own.fitness.app.activities.MainExcerciseActivityNew;


public final  class l implements View.OnClickListener {


    private final  MainExcerciseActivityNew f16a;
    private final  Dialog b;

    public  l(MainExcerciseActivityNew mainExcerciseActivityNew, Dialog dialog) {
        this.f16a = mainExcerciseActivityNew;
        this.b = dialog;
    }

    public final void onClick(View view) {
        this.f16a.a(this.b);
    }
}
