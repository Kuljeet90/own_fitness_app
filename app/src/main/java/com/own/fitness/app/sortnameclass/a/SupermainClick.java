package com.own.fitness.app.sortnameclass.a;

import android.app.Dialog;
import android.view.View;
import com.own.fitness.app.activities.SuperMainActivity;


public final  class SupermainClick implements View.OnClickListener {


    private final  SuperMainActivity f1a;
    private final  Dialog b;

    public SupermainClick(SuperMainActivity superMainActivity, Dialog dialog) {
        this.f1a = superMainActivity;
        this.b = dialog;
    }

    public final void onClick(View view) {
        this.f1a.c(this.b);
    }
}
