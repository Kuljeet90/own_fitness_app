package com.own.fitness.app.all_about_men.database.sortnameclass;

import com.own.fitness.app.all_about_men.database.activity.MainExcerciseActivityNew1;
import com.travijuu.numberpicker.library.Enums.ActionEnum;
import com.travijuu.numberpicker.library.Interface.ValueChangedListener;


public final  class t implements ValueChangedListener {


    private final  MainExcerciseActivityNew1 f24a;

    public  t(MainExcerciseActivityNew1 mainExcerciseActivityNew) {
        this.f24a = mainExcerciseActivityNew;
    }

    public final void valueChanged(int i, ActionEnum actionEnum) {
        this.f24a.a();
    }
}
