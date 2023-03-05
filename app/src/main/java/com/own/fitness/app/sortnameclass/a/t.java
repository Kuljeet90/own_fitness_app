package com.own.fitness.app.sortnameclass.a;

import com.own.fitness.app.activities.MainExcerciseActivityNew;
import com.travijuu.numberpicker.library.Enums.ActionEnum;
import com.travijuu.numberpicker.library.Interface.ValueChangedListener;


public final  class t implements ValueChangedListener {


    private final  MainExcerciseActivityNew f24a;

    public  t(MainExcerciseActivityNew mainExcerciseActivityNew) {
        this.f24a = mainExcerciseActivityNew;
    }

    public final void valueChanged(int i, ActionEnum actionEnum) {
        this.f24a.a();
    }
}
