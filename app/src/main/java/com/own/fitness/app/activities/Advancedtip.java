package com.own.fitness.app.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.own.fitness.app.R;
import com.own.fitness.app.adapters.Pageradapter_advtips;
import com.own.fitness.app.aputils.DepthPageTransformer;

public class Advancedtip extends Fragment {

    ViewPager f752a;
    ImageView b;
    ImageView c;


    SuperMainActivity h;
    AppBarLayout i;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_advancedtip, viewGroup, false);
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        ((Toolbar) inflate.findViewById(R.id.tipstoolbar)).setNavigationOnClickListener(view -> Advancedtip.this.h.onBackPressed());
        this.i = (AppBarLayout) inflate.findViewById(R.id.appBarLayout);


        this.f752a = (ViewPager) inflate.findViewById(R.id.viewPager);
        this.b = (ImageView) inflate.findViewById(R.id.previoustip);
        this.c = (ImageView) inflate.findViewById(R.id.nexttip);

        this.f752a.setAdapter(new Pageradapter_advtips(supportFragmentManager));
        this.f752a.setClipToPadding(false);
        this.f752a.setPadding(20, 0, 20, 0);
        this.f752a.setPageMargin(12);
        this.f752a.setPageTransformer(true, new DepthPageTransformer());

        this.f752a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int i, float f, int i2) {
                ImageView imageView = Advancedtip.this.b;
                if (i == 0) {
                    imageView.setVisibility(View.INVISIBLE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                }
                if (i == 9) {
                    Advancedtip.this.c.setVisibility(View.INVISIBLE);
                } else {
                    Advancedtip.this.c.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("", "scrolled");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("", "scrolled_change");
            }


        });
        this.b.setOnClickListener(view -> {

            this.c.setVisibility(View.VISIBLE);
            if (this.f752a.getCurrentItem() - 1 == 0) {
                this.b.setVisibility(View.INVISIBLE);
            }
            ViewPager viewPager = this.f752a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);

        });
        this.c.setOnClickListener(view -> {

            b.setVisibility(View.VISIBLE);
            ViewPager viewPager = f752a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            if (f752a.getCurrentItem() + 1 == 10) {
                c.setVisibility(View.INVISIBLE);
            }

        });

        return inflate;
    }


}
