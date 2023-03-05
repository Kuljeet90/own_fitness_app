package com.own.fitness.app.sortnameclass.c;

import com.own.fitness.app.fragments.TrainingFragment;


public final  class j implements Runnable {


    private final  TrainingFragment f41a;

    public  j(TrainingFragment trainingFragment) {
        this.f41a = trainingFragment;
    }

    public final void run() {
        this.f41a.d();
    }
}
