package com.own.fitness.app.sortnameclass.a;

import android.app.Dialog;
import android.view.View;
import com.own.fitness.app.activities.SuperMainActivity;


public final  class bClick implements View.OnClickListener {


    private final  SuperMainActivity f3a;
    private final  Dialog b;

    public bClick(SuperMainActivity superMainActivity, Dialog dialog) {
        this.f3a = superMainActivity;
        this.b = dialog;
    }

    public final void onClick(View view) {
        this.f3a.b(this.b);
    }
}
