package com.own.fitness.app.all_about_men.database.c;
import com.own.fitness.app.all_about_men.database.fragment.TrainingFragment1;


public final  class j implements Runnable {


    private final  TrainingFragment1 f41a;

    public  j(TrainingFragment1 trainingFragment) {
        this.f41a = trainingFragment;
    }

    public final void run() {
        this.f41a.d();
    }
}
