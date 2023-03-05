package com.own.fitness.app.sortnameclass.c;

import com.own.fitness.app.fragments.TrainingFragment;


public final  class h implements Runnable {


    private final  TrainingFragment f39a;

    public  h(TrainingFragment trainingFragment) {
        this.f39a = trainingFragment;
    }

    public final void run() {
        this.f39a.c();
    }
}
