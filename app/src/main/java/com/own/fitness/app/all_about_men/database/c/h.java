package com.own.fitness.app.all_about_men.database.c;

import com.own.fitness.app.all_about_men.database.fragment.TrainingFragment1;


public final  class h implements Runnable {


    private final  TrainingFragment1 f39a;

    public  h(TrainingFragment1 trainingFragment) {
        this.f39a = trainingFragment;
    }

    public final void run() {
        this.f39a.c();
    }
}
