package com.own.fitness.app.all_about_men.database.b;

import android.view.View;

import com.own.fitness.app.all_about_men.database.adapter.IndividualDayAdapter1;


public final  class a1 implements View.OnClickListener {


    private final IndividualDayAdapter1 f31a;
    private final  IndividualDayAdapter1.ViewHolder b;
    private final  int c;

    public a1(IndividualDayAdapter1 individualDayAdapter, IndividualDayAdapter1.ViewHolder viewHolder, int i) {
        this.f31a = individualDayAdapter;
        this.b = viewHolder;
        this.c = i;
    }

    public final void onClick(View view) {
        this.f31a.a(this.b, this.c);
    }
}
