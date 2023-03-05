package com.own.fitness.app.all_about_men.database.c;

import com.own.fitness.app.all_about_men.database.fragment.TrainingFragment1;


public final  class i implements Runnable {


    private final  TrainingFragment1 f40a;

    public  i(TrainingFragment1 trainingFragment) {
        this.f40a = trainingFragment;
    }

    public final void run() {
        this.f40a.b();
    }
}
