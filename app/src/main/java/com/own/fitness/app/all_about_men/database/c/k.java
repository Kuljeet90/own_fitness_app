package com.own.fitness.app.all_about_men.database.c;
import com.own.fitness.app.all_about_men.database.fragment.TrainingFragment1;


public final  class k implements Runnable {


    private final  TrainingFragment1 f42a;

    public  k(TrainingFragment1 trainingFragment) {
        this.f42a = trainingFragment;
    }

    public final void run() {
        this.f42a.a();
    }
}
