package com.own.fitness.app.sortnameclass.c;

import com.own.fitness.app.fragments.TrainingFragment;


public final  class k implements Runnable {


    private final  TrainingFragment f42a;

    public  k(TrainingFragment trainingFragment) {
        this.f42a = trainingFragment;
    }

    public final void run() {
        this.f42a.a();
    }
}
