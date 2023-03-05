package com.own.fitness.app.sortnameclass.c;

import com.own.fitness.app.fragments.TrainingFragment;


public final  class i implements Runnable {


    private final  TrainingFragment f40a;

    public  i(TrainingFragment trainingFragment) {
        this.f40a = trainingFragment;
    }

    public final void run() {
        this.f40a.b();
    }
}
