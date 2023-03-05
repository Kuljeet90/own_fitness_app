package com.own.fitness.app.sortnameclass.b;

import android.view.View;
import com.own.fitness.app.adapters.IndividualDayAdapter;


public final  class a implements View.OnClickListener {


    private final  IndividualDayAdapter f31a;
    private final  IndividualDayAdapter.ViewHolder b;
    private final  int c;

    public  a(IndividualDayAdapter individualDayAdapter, IndividualDayAdapter.ViewHolder viewHolder, int i) {
        this.f31a = individualDayAdapter;
        this.b = viewHolder;
        this.c = i;
    }

    public final void onClick(View view) {
        this.f31a.a(this.b, this.c);
    }
}
