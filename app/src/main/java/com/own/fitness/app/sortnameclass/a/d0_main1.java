package com.own.fitness.app.sortnameclass.a;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.own.fitness.app.activities.SuperMainActivity;


public final  class d0_main1 implements BottomNavigationView.OnNavigationItemSelectedListener {


    private final  SuperMainActivity f7a;

    public d0_main1(SuperMainActivity superMainActivity) {
        this.f7a = superMainActivity;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return this.f7a.a1(menuItem);
    }
}
