package com.own.fitness.app.sortnameclass.a;

import android.app.Dialog;
import android.view.View;
import com.own.fitness.app.activities.MainExcerciseActivityNew;


public final  class n implements View.OnClickListener {


    private final  MainExcerciseActivityNew f18a;
    private final  Dialog b;

    public  n(MainExcerciseActivityNew mainExcerciseActivityNew, Dialog dialog) {
        this.f18a = mainExcerciseActivityNew;
        this.b = dialog;
    }

    public final void onClick(View view) {
        this.f18a.b(this.b);
    }
}
